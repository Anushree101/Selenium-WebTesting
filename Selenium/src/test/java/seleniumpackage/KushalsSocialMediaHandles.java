package seleniumpackage;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KushalsSocialMediaHandles {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Kushals website
            driver.get("https://www.kushals.com/");
            driver.manage().window().maximize();
      
            WebElement facebook = driver.findElement(By.xpath(" //*[@id=\"section-id-announcement-bar\"]/div/div[1]/div/ul/li[1]/a"));
            facebook.click();
            Thread.sleep(1000);
            
            
            WebElement Instagram = driver.findElement(By.xpath("//*[@id=\"section-id-announcement-bar\"]/div/div[1]/div/ul/li[2]/a"));
            Instagram.click();
            Thread.sleep(8000);
            
            WebElement Pinterest = driver.findElement(By.xpath(" //*[@id=\"section-id-announcement-bar\"]/div/div[1]/div/ul/li[3]/a"));
            Pinterest.click();
            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
