import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Domaci3Anotacije {

    WebDriver driver;
    WebDriverWait wait;
    String correctUsernameInput, incorrectUsernameInput, correctPasswordInput, incorrectPasswordInput, loggedInURL;
    WebElement usernameField;
    WebElement passwordField;
    WebElement submitButton;
    WebElement errorField;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        correctUsernameInput = "student";
        incorrectUsernameInput = "pogresankorisnik";
        correctPasswordInput = "Password123";
        incorrectPasswordInput = "pogresnasifra";
        loggedInURL = "https://practicetestautomation.com/logged-in-successfully/";
    }

    @BeforeMethod
    public void pageSetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/");

        WebElement practiceLink = driver.findElement(By.id("menu-item-20"));
        practiceLink.click();
        WebElement testLoginLink = driver.findElement(By.linkText("Test Login Page"));
        testLoginLink.click();

        usernameField = driver.findElement(By.id("username"));
        passwordField = driver.findElement(By.id("password"));
        submitButton = driver.findElement(By.id("submit"));
    }

    @Test
    public void prazanUsernameIPassword(){



    }





}
