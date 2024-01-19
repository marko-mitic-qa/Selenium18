import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.Keys.ENTER;

public class Selenium4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(); //za firefox nekada pise gecko driver
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

/*        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"))
                .sendKeys("IT Bootcamp");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"))
                .sendKeys(ENTER);

        driver.navigate().back();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"))
                .sendKeys("Wikipedia");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"))
                .sendKeys(ENTER);*/

        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"));
        searchBox.sendKeys("ITBootcamp");
        searchBox.sendKeys(ENTER);
        searchBox.sendKeys("Wikipedia");
        searchBox.sendKeys(ENTER);

        // LOKATORI ili SELEKTORI

        // Flaky testovi koji nisu stabilni, nekada rade, nekada ne i ne zna se da li je problem do aplikacije ili do nacina kako je test napisan.

        //ID-najstabilniji i najpouzdaniji za lokatore - Prvi po hijerarhiji, u idealnoj situaciji je jedinstven(ne mora biti jedinstven)
        WebElement searchBoxByID = driver.findElement(By.id("APjFqb"));

        // Name
        WebElement searchBoxByName = driver.findElement(By.name("q"));

        // Class - kada klasa obuhvata vise elemenata npr klasa prilog unutar koje su kecap, majonez i sl i onda biramo po poziciji
        WebElement searchBoxByClass = driver.findElement(By.className("gLFyf"));

        // CSS Selector
        WebElement searchBoxByCSS = driver.findElement(By.cssSelector("textarea[type='search']"));

        WebElement searchBoxByFakeClass = driver.findElement(By.className("search box google"));
        WebElement searchBoxByFakeCSS = driver.findElement(By.cssSelector(".search.box.google")); // od klase se pravi css selektor samo u slucaju kada klasa ima razmak izmedju elemenata

        // Relative Xpath (samo copy)
        WebElement searchBoxRelative = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        // Absoluth Xpath - to je sto smo radili(krece od samog pocetka HTML-a u svojoj putanji)-koristi se za brzinsko radjenje testova pa kada se utvrdi da radi, vrati se i promene se lokatori
        WebElement searchBoxAbsoluth = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea"));







    }
}
