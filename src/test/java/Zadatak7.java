import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak7 {
    public static void main(String[] args) {

        // Zadatak 7
        // Testirati neuspesan log in

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");
        WebElement tabLink = driver.findElement(By.id("menu-item-20"));
        tabLink.click();

        WebElement testLink = driver.findElement(By.linkText("Test Login Page"));
        testLink.click();

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password1231");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();



        String expectedErrorUsername = "Your username is invalid!";
        String actualError = driver.findElement(By.id("error")).getText();
        Assert.assertEquals(actualError, expectedErrorUsername);

        //Your password is invalid!

        String expectedErrorPassword = "Your password is invalid!";
        String actualErrorPassword = driver.findElement(By.id("error")).getText();
        Assert.assertEquals(actualError, expectedErrorPassword);
        Assert.assertTrue(submit.isDisplayed());

        // security pitanje - treba se dobiti ista genericka poruka za nevalidno logovanje, a ne da se ukazuje da li je pogresan username ili password



    }
}
