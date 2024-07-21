package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyntraSignInTest {

    public static void main(String[] args) {
        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Visit Myntra login page
            driver.get("https://www.myntra.com/login?referer=https://www.myntra.com/");

            // Perform Sign In
            signIn(driver, "9353746207");

            // Wait for a while (optional)
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    public static void signIn(WebDriver driver, String phno) {
        try {
            // Wait for the mobile number input field to be visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement phInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reactPageContent']/div/div/div[2]/div[2]/div[1]/input")));

            // Enter mobile number
            phInput.sendKeys(phno);
            Thread.sleep(1000);

            // Click on Continue button
            WebElement continueButton = driver.findElement(By.xpath("//*[@id='reactPageContent']/div/div/div[2]/div[2]/div[3]"));
            continueButton.click();

            // Debugging: Print the current page source for analysis
            System.out.println(driver.getPageSource());

            // Check for the visibility of different elements
            boolean isMobileContainerVisible = wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reactPageContent']/div/div[2]")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reactPageContent']/div/div[2]/div[1]")),
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='reactPageContent']/div/div[2]/div[2]/button"))
            ));

            // Handle the response based on the visible element
            if (driver.findElements(By.xpath("//*[@id='reactPageContent']/div/div[2]")).size() > 0) {
                WebElement mobileContainer = driver.findElement(By.xpath("//*[@id='reactPageContent']/div/div[2]"));
                System.out.println("Processing your request... If it doesn't work, resubmit.");
                System.out.println("Container message: " + mobileContainer.getText());
            } else if (driver.findElements(By.xpath("//*[@id='reactPageContent']/div/div[2]/div[1]")).size() > 0) {
                System.out.println("OTP Sent Successfully!");
                // Here you can add code to handle OTP input if necessary
            } else if (driver.findElements(By.xpath("//*[@id='reactPageContent']/div/div[2]/div[2]/button")).size() > 0) {
                System.out.println("Resend OTP button is visible.");
            } else {
                System.out.println("Unexpected behavior. Please check the application.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
