import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak6 {
    public static void main(String[] args) {

        // Zadatak 6
// Testirati log out funkcionalnost

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/");
        WebElement tabLink = driver.findElement(By.id("menu-item-20"));
        tabLink.click();

        //WebElement testLink = driver.findElement(By.xpath("/html/body/div/div/section/div/div/article/div[2]/div[1]/div[1]/p/a"));
        WebElement testLink = driver.findElement(By.linkText("Test Login Page"));
        testLink.click();

/*        Lista<WebElement> username1 = driver.findElement(By.id("username"));
        System.out.println("Lista: " + username1.size()); //provera da li je element jedinstven*/


        WebElement username = driver.findElement(By.id("username"));
        //WebElement korisnikInput = driver.findElement(By.xpath("/html/body/div/div/section/section/ul/li[2]/b[1]"));
        //String korisnik = korisnikInput.getText();
        username.sendKeys("student");
        //username.sendKeys(korisnik);



        WebElement password = driver.findElement(By.id("password"));
        //WebElement sifraInput = driver.findElement(By.xpath("/html/body/div/div/section/section/ul/li[2]/b[2]"));

        password.sendKeys("Password123");
        //String sifra = sifraInput.getText();
        //password.sendKeys(sifra);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));
        logoutButton.click();


        // URL
        String expectedURLAfterLogOut = "https://practicetestautomation.com/practice-test-login/";
        String actualURLAfterLogOut = driver.getCurrentUrl();
        Assert.assertEquals(actualURLAfterLogOut, expectedURLAfterLogOut);

        //Assert.assertNotEquals(driver.getCurrentUrl(),""); //uspesan login link

        //Submit button
        WebElement submitButtonAfterLogout = driver.findElement(By.id("submit"));
        Assert.assertTrue(submitButtonAfterLogout.isDisplayed());

        //Page title
/*        String actualPageTitle = driver.findElement(By.id("login")).getText();
        String expectedPageTitle = "Test login";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);*/





    }
}
