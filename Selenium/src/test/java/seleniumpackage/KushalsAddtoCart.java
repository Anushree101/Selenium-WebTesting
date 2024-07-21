package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class KushalsAddtoCart {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Kushals website
            driver.get("https://www.kushals.com/");
            driver.manage().window().maximize();
            // Locate the search box
            WebElement searchBox = driver.findElement(By.name("q")); // Update if needed

            // Enter "necklaces" and submit
            searchBox.sendKeys("necklaces");
            searchBox.submit();

            // Wait for results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']/div/div[2]/div[2]/div[2]/ul/li[1]/div[1]/div/div[2]/div/div/div[1]/a/div"))); // Update with actual class

            // Locate the item using XPath and click it
            WebElement item = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div[2]/div[2]/ul/li[1]/div[1]/div/div[2]/div/div/div[1]/a/div"));
            item.click();
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id='product-form-template--16980985348252__main-8107011932316']/div[1]/div[4]/div/button"));
            addToCartButton.click();
            
            Thread.sleep(6000);
            
            driver.get("https://www.kushals.com/");
            WebElement searchBox1 = driver.findElement(By.name("q")); // Update if needed
            searchBox1.sendKeys("bangles");
            searchBox1.submit();
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/div[2]/ul/li[1]/div[1]/div/div[2]/div/div/div[1]/a/div"))); 
            WebElement item2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/div[2]/ul/li[1]/div[1]/div/div[2]/div/div/div[1]/a/div"));
            item2.click();
            WebElement addToCartButton2 = driver.findElement(By.xpath("//*[@id=\"product-form-template--16980985348252__main-7722403430556\"]/div[1]/div[4]/div/button"));
            addToCartButton2.click();
            
            Thread.sleep(6000);
            
            driver.get("https://www.kushals.com/");
            WebElement searchBox2 = driver.findElement(By.name("q")); // Update if needed
            searchBox2.sendKeys("earrings");
            searchBox2.submit();
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/div[2]/ul/li[1]/div[1]/div/div[2]/div/div/div[1]/a/div")));
            WebElement item3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div[2]/div[2]/ul/li[1]/div[1]/div/div[2]/div/div/div[1]/a/div"));
            item3.click();
            WebElement addToCartButton3 = driver.findElement(By.xpath("//*[@id=\'product-form-template--16980985348252__main-7182987755676\']/div[1]/div[4]/div/button"));
            addToCartButton3.click();
            
            Thread.sleep(6000);

            driver.get("https://www.kushals.com/");
           
            // Locate the cart element using XPath and click on it
            WebElement cartElement = driver.findElement(By.xpath("//*[@id='pageheader']/div[1]/div[3]/div/div[3]/a"));
            cartElement.click();
            Thread.sleep(2000);
            WebElement remove = driver.findElement(By.xpath("/html/body/div[12]/div/div[1]/ul/li[1]/div[3]/button"));
            remove.click();
            Thread.sleep(6000);
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
