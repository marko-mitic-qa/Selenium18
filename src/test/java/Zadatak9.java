import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak9 {
    public static void main(String[] args) throws InterruptedException {

        ///*Zadatak 9
        //https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2
        //Testirati dodavanje knjige u korpu i da li se knjiga obrise kada obrisete kolacice*/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");


        Thread.sleep(10000);

/*        WebElement bookDesription = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div[1]/div[8]/div[26]/div/div[1]/h4[2]/span"));
        Assert.assertEquals(bookDesription.getText(), "Book Description");*/

        WebElement productTitle = driver.findElement(By.id("productTitle"));

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement itemCount = driver.findElement(By.id("nav-cart"));
        Assert.assertEquals("1", itemCount.getText());



    }
}
