package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Brandname {

    public static void main(String[] args) {
        // Set ChromeDriver path (replace with your own)
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Open Myntra website
            driver.get("https://www.myntra.com");

            // Perform search and filter by price range for a specific brand
            searchAndFilterByPrice(driver, "H&M");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void searchAndFilterByPrice(WebDriver driver, String brandName) {
        try {
            // Locate the search box element
            WebElement searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
            // Enter search query
            searchBox.sendKeys(brandName);

            // Click search button
            WebElement searchButton = driver.findElement(By.xpath("//a[@class='desktop-submit']"));
            searchButton.click();

            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".results-base .product-base")));

            // Filter by price range
            WebElement priceFilter = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/main/div[3]/div[1]/section/div/div[3]/ul/li[1]/label"));
            priceFilter.click();

            // Wait for filtered results to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".results-base .product-base")));

            // Example: Click on the first product in the search results and add to wishlist
            List<WebElement> products = driver.findElements(By.cssSelector(".results-base .product-base"));
            if (!products.isEmpty()) {
                // Click on the first product
                products.get(0).click();

                // Wait for product page to load and select size
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sizeButtonsContainer\"]/div[2]/div[2]/div[1]/button")));
                List<WebElement> sizeOptions = driver.findElements(By.xpath("//*[@id=\"sizeButtonsContainer\"]/div[2]/div[2]/div[1]/button"));
                if (!sizeOptions.isEmpty()) {
                    sizeOptions.get(0).click(); // Select the first available size
                }

                // Wait for Wishlist button to be clickable and click it
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[3]/div/div[2]")));
                WebElement wishlistButton = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[3]/div/div[2]"));
                wishlistButton.click();

                // Wait for success message or confirmation
                WebElement wishlistSuccessMessage = driver.findElement(By.xpath("//div[contains(@class, 'wishlistSuccessMessage')]"));
                wait.until(ExpectedConditions.visibilityOf(wishlistSuccessMessage));
                System.out.println("Product added to Wishlist!");

            } else {
                System.out.println("No products found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
