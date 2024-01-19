import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak8 {
    public static void main(String[] args) throws InterruptedException {

        // Prvo manuelno uradi stvari koje ces kasnije automatizovati. OD TOGA SE KRECE


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
//-----------------------------------------------------------------------------------------




        driver.get("https://wordpress.com/");

        WebElement loginButton = driver.findElement(By.linkText("Log In"));
        loginButton.click();

        String username = "markomiticqa";
        String password = "pgLv^cTdso*3tA";

        WebElement usernameField = driver.findElement(By.id("usernameOrEmail"));
        usernameField.sendKeys(username);

        WebElement continueButton = driver.findElement(By.cssSelector("button[type='submit']"));
        continueButton.click();

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        continueButton.click();

        //-------------------------

        //Thread.sleep(3000); //odmah se koristi ovo da se vidi da li je do cekanja ili jednostavno element ne moze da se pronadje
        wait.until(ExpectedConditions.urlToBe("https://wordpress.com/home/markomiticqa.wordpress.com"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://wordpress.com/home/markomiticqa.wordpress.com");

        WebElement profileButton = driver.findElement(By.cssSelector(".gravatar.masterbar__item-me-gravatar"));
        profileButton.click();

        WebElement usernameTitle = driver.findElement(By.className("profile-gravatar__user-display-name"));
        String usernameText = usernameTitle.getText();

        Assert.assertEquals(usernameText, username);





    }



}
