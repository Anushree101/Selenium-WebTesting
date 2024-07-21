package seleniumpackage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KushalsNavigate {
    public static void main(String[] args) {
        // Set the path to your ChromeDriver
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to Kushals website
            driver.get("https://www.kushals.com/");
            driver.manage().window().maximize();
            WebElement Necklaces =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[1]/a[1]"));
            Necklaces.click();
            Thread.sleep(200);
            
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            
            WebElement Earrings =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[2]/a[1]"));
            Earrings.click();
            Thread.sleep(200);
            
            JavascriptExecutor js1 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js1.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            WebElement Bangles =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[3]/a[1]"));
            Bangles.click();
            Thread.sleep(200);
            JavascriptExecutor js2 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js2.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            
            WebElement Accessories =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[4]/a[1]"));
            Accessories.click();
            Thread.sleep(200);
            JavascriptExecutor js3 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js3.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            WebElement silver =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[5]/a[1]"));
            silver.click();
            Thread.sleep(200);
            JavascriptExecutor js4 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js4.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            WebElement wedding =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[6]/a[1]"));
            wedding.click();
            Thread.sleep(200);
            JavascriptExecutor js5 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js5.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            WebElement occasion =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[7]/a[1]"));
            occasion.click();
            Thread.sleep(200);
            JavascriptExecutor js6 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js6.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            WebElement collection =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[8]/a[1]"));
            collection.click();
            Thread.sleep(200);
            
            JavascriptExecutor js7 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js7.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            // Locate the "Happy Customer" button using XPath and click it
            WebElement happyCustomerButton = driver.findElement(By.xpath("//*[@id='main-nav']/div/div/ul/li[9]/a"));
            happyCustomerButton.click();
            Thread.sleep(200);
            JavascriptExecutor js8 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js8.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            WebElement celebcorner =driver.findElement(By.xpath("//*[@id=\"main-nav\"]/div/div/ul/li[10]/a[1]"));
            celebcorner.click();
            Thread.sleep(200);
            JavascriptExecutor js9 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js9.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            
            WebElement localStoresButton = driver.findElement(By.xpath("//*[@id='section-id-announcement-bar']/div/div[3]/span/a"));
            localStoresButton.click();
            Thread.sleep(1000);
            JavascriptExecutor js10 = (JavascriptExecutor) driver;

            // Scroll slowly
            for (int i = 0; i < 10; i++) {
                js10.executeScript("window.scrollBy(0, 200);"); // Scroll down by 200 pixels
                Thread.sleep(500); // Pause for 500 milliseconds
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
