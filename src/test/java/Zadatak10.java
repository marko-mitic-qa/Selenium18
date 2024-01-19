import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Zadatak10 {
    public static void main(String[] args) throws InterruptedException, IOException {

        //Zadatak 10
//Otici na stranicu https://imgflip.com/memegenerator
//Uploadovati sliku od koje treba napraviti mim
//Mim mora biti vezan za IT, QA ili kurs
//Sliku rucno skinuti i ubaciti na Slack thread poruku
//Autor mima sa najvise lajkova dobija pivo na druzenju
//
//Napomena: Izazov zadatka je kod lokatora, assertove ne treba dodavati i ne treba raditi sa anotacijama


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebDriverWait wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        String imageLocation = "C:\\Users\\mitic\\OneDrive\\Desktop\\meme.png";


        driver.get("https://imgflip.com/memegenerator");



        WebElement uploadNewTemplateButton = driver.findElement(By.id("mm-show-upload"));
        uploadNewTemplateButton.click();


        WebElement uploadFileButton = driver.findElement(By.id("mm-upload-file"));
        uploadFileButton.sendKeys(imageLocation);

        WebElement uploadButton = driver.findElement(By.id("mm-upload-btn"));
        uploadButton.click();

        List<WebElement> topTextList = driver.findElements(By.className("mm-text"));

        topTextList.getFirst().sendKeys("Debugger what??");

        List<WebElement> changeFontColorButtonList = driver.findElements(By.cssSelector(".color-picker.mm-font-color-picker"));
        changeFontColorButtonList.getFirst().click();

        List<WebElement> color = driver.findElements(By.className("color-box"));
        color.get(8).click();

        WebElement colorOutlinebutton = driver.findElement(By.cssSelector(".color-picker.mm-outline-color-picker"));
        colorOutlinebutton.click();
        WebElement colorOutline = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[6]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div[2]"));
        colorOutline.click();

        WebElement generateButton = driver.findElement(By.cssSelector(".mm-generate.b.but"));
        generateButton.click();

        //Save image
        WebElement meme = driver.findElement(By.id("done-img"));
        wdwait.until(ExpectedConditions.attributeContains(meme, "src", "imgflip.com"));
        String link = meme.getAttribute("src");
        URL imageURL = new URL(link);
        BufferedImage saveImage = ImageIO.read(imageURL);
        ImageIO.write(saveImage, "png", new File("C:\\Users\\mitic\\OneDrive\\Desktop\\debugger_what.png"));



    }
}
