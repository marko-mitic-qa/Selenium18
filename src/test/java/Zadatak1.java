import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) {
        //Zadatak 1
//Pokrenite browser, idite na Linkedin sajt, uradite refresh, idite na Joberty sajt
//vratite se nazad i odstampajte poslednji URL na kom se nalazite
//na kraju zatvorite driver


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverManager.chromedriver().setup();
        driver.navigate().to("https://www.linkedin.com/");
        driver.navigate().refresh();
        driver.navigate().back();

        driver.navigate().to("https://www.joberty.com/");

        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}

