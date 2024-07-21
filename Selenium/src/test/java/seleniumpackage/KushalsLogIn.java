package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class KushalsLogIn {
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

            // Wait for the email field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer_email']")));
            emailField.sendKeys("john.doe@example.com");

            // Locate the password field and fill it
            WebElement passwordField = driver.findElement(By.xpath("//*[@id='customer_password']"));
            passwordField.sendKeys("SecurePass123");
            Thread.sleep(2000);
            // Locate and click the sign-in button
            WebElement signInButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[3]/div/button"));
            signInButton.click();
            Thread.sleep(200000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
