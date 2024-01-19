import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciSelenium3_2 {
    public static void main(String[] args) {
        //Domaci Zadatak 1:
        //Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //------------------------------------------------------------------------

        driver.navigate().to("https://practicetestautomation.com/");

        //Path to Login page

        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();

        WebElement testLoginLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginLink.click();
        //------------------------------------------------------------------------------

        // Provera da su polja username i password prazna

        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "");
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");

        //------------------------------------------------------------------------------------

        //Elementi stranice

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));
        WebElement errorField = driver.findElement(By.id("error"));

        //----------------------------------------------------------------------

        //Nasi inputi

        String correctUsernameInput = "student";
        String incorrectUsernameInput = "pogresankorisnik";
        String correctPasswordInput = "Password123";
        String incorrectPasswordInput = "pogresnasifra";



        // 2 tacan username i prazna sifra

        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "");
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");

        usernameField.sendKeys(correctUsernameInput);
        submitButton.click();

        Assert.assertTrue(errorField.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://practicetestautomation.com/practice-test-login/"); // ako je ocekivani rezultat da ostane na login stranici
        Assert.assertEquals(driver.findElement(By.id("username")).getText(), ""); // ako se ocekuje da polja za unos budu prazna nakon neuspesnog logina
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), ""); // ako se ocekuje da polja za unos budu prazna nakon neuspesnog logina


        //Assert.assertEquals(errorField.getText(), "You didn't enter valid data! Try again.");


    }
}
