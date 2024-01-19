import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Zadatak4 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Wikipedia");

        List<WebElement> searchButton = driver.findElements(By.name("btnK"));
        searchButton.get(0).click();

        //Pogresan nacin

        //WebElement wikipediaLink = driver.findElement(By.className("LC20lb MBeuO DKV0Md"));
        WebElement wikipediaLink = driver.findElement(By.cssSelector(".LC20lb.MBeuO.DKV0Md"));
        wikipediaLink.click();

        WebElement wikipediaSearch = driver.findElement(By.id("searchInput"));
        wikipediaSearch.sendKeys("Nikola Tesla");

        //WebElement wikipediaButton = driver.findElement(By.cssSelector(".pure-button.pure-button-primary-progressive"));
        WebElement wikipediaButton = driver.findElement(By.cssSelector("button[type='submit']"));
        wikipediaButton.click();

        //------------------------------------

        String expectedURL = "https://en.wikipedia.org/wiki/Nikola_Tesla";

        //Kada koristimo assertEquals sa leve strane je REALAN rezultat, sa desne je OCEKIVAN rezultat
        //nakon asertacije odradite test da padne, da bi se videlo sta i kako radi i da li smo mi negde slucajno napravili gresku
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement pageTitle = driver.findElement(By.className("mw-page-title-main"));
        String pageTitleText = pageTitle.getText();
        String expectedTitle = "Nikola Tesla";

        Assert.assertEquals(pageTitleText, expectedTitle);

        WebElement pageImage = driver.findElement(By.className("infobox-image"));

        Assert.assertTrue(pageImage.isDisplayed());




    }
}
