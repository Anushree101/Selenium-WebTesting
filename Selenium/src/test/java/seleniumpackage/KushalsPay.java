package seleniumpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class KushalsPay {
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
            Thread.sleep(2000);
            // Locate the "Proceed to Checkout" button using XPath and click it
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'mm-checkout-button') and text()='Proceed to Checkout']")));

            // Locate the "Proceed to Checkout" button and click it
            WebElement proceedToCheckoutButton = driver.findElement(By.xpath("//a[contains(@class,'mm-checkout-button') and text()='Proceed to Checkout']"));
            proceedToCheckoutButton.click();
            Thread.sleep(10000);
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.close();
        }
    }
}

