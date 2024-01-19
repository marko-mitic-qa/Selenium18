import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium11 {

    // SVI testovi se izvrsavaju u POSEBNOM browseru
    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    String validUsername, validPassword, invalidUsername, loggedInURL, invalidPassword;
    WebDriverWait wait;
    WebElement error;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        validUsername = "student";
        invalidUsername = "student1";
        validPassword = "Password123";
        invalidPassword = "password";
        loggedInURL = "https://practicetestautomation.com/logged-in-successfully/";
    }

    @BeforeMethod
    public void pageSetUp() {
        // U ovoj klasi cemo inicijalizaciju drivera raditi u BeforeMethod
        // To znaci da ce svaki test da se pokrece u posebnom browseru
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();
        WebElement linkButton = driver.findElement(By.linkText("Test Login Page"));
        linkButton.click();
        error = driver.findElement(By.id("error"));//proveri poziciju


        usernameField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        submitButton = driver.findElement(By.id("submit"));
    }

    @Test(priority = 10)
    public void userCanLogIn() {
        usernameField.sendKeys(validUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        Assert.assertTrue(logOutButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loggedInURL);
        WebElement profileTitle = driver.findElement(By.className("post-title"));
        Assert.assertTrue(profileTitle.isDisplayed());
    }

    @Test(priority = 20)
    public void userCannotLogInWithInvalidUsername() throws InterruptedException {
        usernameField.sendKeys(invalidUsername);
        passwordField.sendKeys(validPassword);
        submitButton.click();

        Thread.sleep(1000);
        error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();

        Assert.assertEquals(errorMessage, "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }

    @Test(priority = 30)
    public void userCannotLogInWithInvalidPassword() throws InterruptedException {
        usernameField.sendKeys(validUsername);
        passwordField.sendKeys(invalidPassword);
        submitButton.click();

        Thread.sleep(1000);
        error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();

        Assert.assertEquals(errorMessage, "Your password is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }

    @Test (priority = 40)
    public void userCannotLoginWithInvalidUsernameAndInvalidPassword(){
        error = driver.findElement(By.id("error")); //izdvoji posle ovo
        String errorMessage = error.getText();

        usernameField.sendKeys(invalidUsername);
        passwordField.sendKeys(invalidPassword);

        Assert.assertEquals(errorMessage, "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }

    @Test (priority = 50)
    public void userCannotLoginWithEmptyUsernameAndPasswordField(){
        error = driver.findElement(By.id("error"));
        String errorMessage = error.getText();


        Assert.assertEquals(driver.findElement(By.id("username")).getText(), "");
        Assert.assertEquals(driver.findElement(By.id("password")).getText(), "");

        Assert.assertEquals(errorMessage, "Your username is invalid!");
        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

    }



    @AfterMethod
    public void tearDown() {
        // driver.quit smo stavili u AfterMethod jer zelimo da zatvorimo svaki browser kada se  test zavrsi
        // Ako bismo stavili quit u AfterClass onda bi se samo poslednji browser zatvorio
        driver.quit();
    }

}
