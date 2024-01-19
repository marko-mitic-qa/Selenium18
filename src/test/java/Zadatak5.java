import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak5 {
    public static void main(String[] args) {
        // Zadatak 5
// Testirati log in stranice https://practicetestautomation.com/

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


        String validUsername = "student";
        String validPassword = "Student123";
        WebElement username = driver.findElement(By.id("username"));
        //WebElement korisnikInput = driver.findElement(By.xpath("/html/body/div/div/section/section/ul/li[2]/b[1]"));
        //String korisnik = korisnikInput.getText();
        username.sendKeys(validUsername);
        //username.sendKeys(korisnik);



        WebElement password = driver.findElement(By.id("password"));
        //WebElement sifraInput = driver.findElement(By.xpath("/html/body/div/div/section/section/ul/li[2]/b[2]"));

        password.sendKeys(validPassword);
        //String sifra = sifraInput.getText();
        //password.sendKeys(sifra);

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        //----------------------------------------------------------

        //URL
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        //Page Title
        String pageTitle = driver.findElement(By.className("post-title")).getText();
        String expectedTitle = "Logged In Successfully";
        Assert.assertEquals(pageTitle, expectedTitle);

        //Logout button

        WebElement logoutButton = driver.findElement(By.cssSelector(".wp-block-button__link.has-text-color.has-background.has-very-dark-gray-background-color"));
        String logoutButtonText = logoutButton.getText();
        String expectedLogoutButtonText = "Log out";
        //Assert.assertEquals(logoutButtonText, expectedLogoutButtonText);

        //WebElement logoutButton = driver.findElement(By.linkText("Log out"));` // ako ima tekst u okviru linka
        Assert.assertTrue(logoutButton.isDisplayed());

        // Info tekst
        String expectedTextOutput = "Congratulations " + validUsername +". You successfully logged in!"; // student koji je username on uzima za ovaj ispis
        String actualOutputText = driver.findElement(By.className("has-text-align-center")).getText();
        Assert.assertEquals(actualOutputText, expectedTextOutput);







    }
}
