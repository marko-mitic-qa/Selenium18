import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciSelenium2 {
    public static void main(String[] args) {

        //Domaci Zadatak 2:
        //https://demoqa.com/text-box napisati test case za dati text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //--------------------------------------------------------------------------

        // Happy Flow test

        driver.get("https://demoqa.com/text-box");

        String fullNameInput = "Marko Mitic";
        String emailInput = "marko@mitic.com";
        String currentAddressInput = "Beograd";
        String permanentAddressInput = "Bor";

        WebElement fullNameButton = driver.findElement(By.id("userName"));
        WebElement emailInputButton = driver.findElement(By.id("userEmail"));
        WebElement currentAddressButton = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressButton = driver.findElement(By.id("permanentAddress"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        fullNameButton.sendKeys(fullNameInput);
        emailInputButton.sendKeys(emailInput);
        currentAddressButton.sendKeys(currentAddressInput);
        permanentAddressButton.sendKeys(permanentAddressInput);

        submitButton.click();

        WebElement output = driver.findElement(By.id("output"));

        Assert.assertTrue(output.isDisplayed());

        WebElement nameOutput = driver.findElement(By.id("name"));
        WebElement emailOutput = driver.findElement(By.id("email"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]")); //id nije jedinstven pa se morao koristiti xPath
        WebElement permanentAddressOutput = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[4]")); //id nije jedinstven pa se morao koristiti xPath

        Assert.assertEquals(nameOutput.getText(), "Name:" + fullNameInput);
        Assert.assertEquals(emailOutput.getText(), "Email:" + emailInput);
        Assert.assertEquals(currentAddressOutput.getText(), "Current Address :" + currentAddressInput);
        Assert.assertEquals(permanentAddressOutput.getText(), "Permanent Address :" + permanentAddressInput);

        //Izbacuje gresku zato sto postoji bug jer je napravljen typo za output na sajtu za Permanent Address




    }
}
