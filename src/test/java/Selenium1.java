import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.com");//ne ceka da program reaguje pre nego sto nastavi dalje(Dragoljub ovo koristi)
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com"); //get ceka da se stranica aktivira pa nastavlja dalje

        System.out.println(driver.getCurrentUrl());

        driver.navigate().refresh();

        driver.navigate().back();

        System.out.println(driver.getCurrentUrl());

        driver.navigate().forward();

        driver.quit(); //kada se sve zavrsi i kada zavrsimo testiranje zatvaramo driver(Dragoljub ovo koristi)
        //driver.close();//zatvora trenutni tab na kome se nalazi(u novijim verzijama izbacuje silne greske za ovo pa bolje koristiti quit za sada)



    }
}
