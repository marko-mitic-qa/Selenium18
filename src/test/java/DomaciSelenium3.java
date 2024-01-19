import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DomaciSelenium3 {
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



        // 1 prazno polje username i password

        submitButton.click();
        Assert.assertTrue(errorField.isDisplayed());


        // 2 tacan username i prazna sifra

        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "");
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");

        usernameField.sendKeys(correctUsernameInput);
        submitButton.click();

        Assert.assertTrue(errorField.isDisplayed());


        // 3 prazan username i  tacna sifra

        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "");
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");

        passwordField.sendKeys(correctPasswordInput);
        submitButton.click();

        Assert.assertTrue(errorField.isDisplayed());


        // 4 tacan username i pogresna sifra
        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "");
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");

        usernameField.sendKeys(correctUsernameInput);
        passwordField.sendKeys(incorrectPasswordInput);
        submitButton.click();

        Assert.assertTrue(errorField.isDisplayed());


        // 5 pogresan username i tacna sifra

        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "");
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");

        usernameField.sendKeys(incorrectUsernameInput);
        passwordField.sendKeys(correctPasswordInput);
        submitButton.click();

        Assert.assertTrue(errorField.isDisplayed());


        // 6 pogresan username i pogresna sifra

        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "");
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");

        usernameField.sendKeys(incorrectUsernameInput);
        passwordField.sendKeys(incorrectPasswordInput);
        submitButton.click();

        Assert.assertTrue(errorField.isDisplayed());






        

    }
}
