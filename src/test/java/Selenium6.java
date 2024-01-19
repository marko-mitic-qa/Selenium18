import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class Selenium6 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.wordpress.com/");

        Cookie cookie = new Cookie("wordpress_logged_in","markomiticqa%7C1800039320%7CKGIb4ORA9baieXD10927RfD9AfLamhEKjVcZ4xI9qGJ%7C08198ce39bd94a3e967bef2035653f6cedfecc0678a596c3baf66e130ef27bbc");


        driver.manage().addCookie(cookie); // logovanje pomocu podataka iz cookies. Korisno kada se ne radi testiranje login-a da bismo ubrzali proces
        driver.navigate().refresh(); // posle dodavanja objekata ovog tipa obavezan je refresh

        Thread.sleep(4000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();





    }
}