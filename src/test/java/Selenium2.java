import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Selenium2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());

        System.out.println(listaTabova);

        driver.switchTo().window(listaTabova.get(1));
        driver.get("https://www.linkedin.com");

        driver.switchTo().window(listaTabova.get(2));
        driver.get("https://www.joberty.com");

        driver.switchTo().window(listaTabova.get(3));
        driver.get("https://www.youtube.com");



        // 0 -- prvi tab
        // 0 - 1 -- kada otvorimo novi tab
        // 0- 2 - 1 -- kada otvorimo novi tab kada smo na tabu 0
        // 0 - 3 - 2 - 1 -- kada otvorimo jos jedan tab dok smo na tabu 0

/*        driver.close();// zatvara tab na kome se trenutno nalazimo
        driver.switchTo().window(listaTabova.get(2));
        driver.close();
        driver.switchTo().window(listaTabova.get(1));
        driver.close();*/

        driver.quit(); //zatvara sve



    }
}
