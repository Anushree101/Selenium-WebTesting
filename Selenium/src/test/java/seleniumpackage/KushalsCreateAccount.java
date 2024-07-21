package seleniumpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class KushalsCreateAccount {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Kushals website
            driver.get("https://www.kushals.com/");
            driver.manage().window().maximize();

            // Locate the profile button using XPath and click it
            WebElement profileButton = driver.findElement(By.xpath("//*[@id='pageheader']/div[1]/div[3]/div/a[2]"));
            profileButton.click();
            
            // Locate the "Continue with Google" button and click it
            WebElement createaccount = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[3]/div/a"));
            createaccount.click();
            
         // Fill out the form fields
            WebElement firstName =driver.findElement(By.xpath("//*[@id='first_name']"));
            firstName.sendKeys("John");

            WebElement lastName = driver.findElement(By.xpath("//*[@id='last_name']"));
            lastName.sendKeys("Doe");

            WebElement birthDate = driver.findElement(By.xpath("//*[@id='birthday']"));
            birthDate.sendKeys("01-01-1990");

            WebElement email = driver.findElement(By.xpath("//*[@id='email']"));
            email.sendKeys("john.doe@example.com");

            WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
            password.sendKeys("SecurePass123");
            
            WebElement createButton = driver.findElement(By.xpath("//button[contains(text(), 'Create')]"));
            createButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }
}
