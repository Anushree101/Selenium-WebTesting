package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Beautyelementcheck {
    private WebDriver driver;

    public Beautyelementcheck(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getBeautyElement() {
        return driver.findElement(By.xpath("//*[@id='desktop-header-cnt']/div[2]/nav/div/div[5]/div/a"));
    }

    public WebElement getLipsticksSection() {
        return driver.findElement(By.xpath("//*[@id='mountRoot']/div/main/div[3]/div[1]/section/div/div[3]/ul/li[1]/label"));
    }

    public WebElement getLipstickProduct() {
        return driver.findElement(By.xpath("//li[contains(@class, 'product-base')]//a/div[2]/h4[contains(text(), 'Matte As Hell Lightweight & Long Lasting Lip Crayon - Scarlett O Hara 01')]"));
    }

    public WebElement getAddToBagButton() {
        return driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[3]/div/div[1]"));
    }

    public void searchBeautyElement() {
        WebElement beauty = getBeautyElement();
        beauty.click();
    }
    
    public void goToLipsticksSection() {
        WebElement lipsticks = getLipsticksSection();
        lipsticks.click();
    }
    
    public void openLipstickProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lipstickProduct = wait.until(ExpectedConditions.elementToBeClickable(getLipstickProduct()));
        lipstickProduct.click();
    }
    
    public void addToBag() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToBagButton = wait.until(ExpectedConditions.elementToBeClickable(getAddToBagButton()));
            addToBagButton.click();
         
            //WebElement addToBag = wait.until(ExpectedConditions.elementToBeClickable(getAddToBagButton()));
            //addToBag.click();
    }

    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.myntra.com");

        Beautyelementcheck beautyCheck = new Beautyelementcheck(driver);
        beautyCheck.searchBeautyElement();
        beautyCheck.goToLipsticksSection();
        beautyCheck.openLipstickProduct();
        beautyCheck.addToBag();

        driver.quit();
    }
}
