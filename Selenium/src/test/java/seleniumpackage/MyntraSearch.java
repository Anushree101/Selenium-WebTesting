package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyntraSearch {

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

            // Perform search and add to bag for men's section
            searchAndAddToBag(driver, "mens shirts", "42");

            // Perform search and add specific women's dress to bag
            searchAndAddSpecificDressToBag(driver, "women dresses");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    private static void searchAndAddToBag(WebDriver driver, String searchTerm, String size) {
        try {
            // Locate the search box element
            WebElement searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
            // Enter search query
            searchBox.sendKeys(searchTerm);

            // Click search button
            WebElement searchButton = driver.findElement(By.xpath("//a[@class='desktop-submit']"));
            searchButton.click();

            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".results-base .product-base")));

            // Example: Click on the first product in the search results and add to bag
            WebElement firstProduct = driver.findElement(By.cssSelector(".results-base .product-base"));
            firstProduct.click();

            // Wait for product page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sizeButtonsContainer\"]")));

            // Select specified size
            WebElement sizeButton = driver.findElement(By.xpath("//*[@id=\"sizeButtonsContainer\"]/div[2]/div[2]/div[1]/button"));
            sizeButton.click();

            // Wait for Add to Bag button to be clickable and click it
            WebElement addToBagButton = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]"));
            addToBagButton.click();

            // Wait for success message or confirmation
            WebElement addToBagSuccessMessage = driver.findElement(By.xpath("//div[contains(@class, 'addToBagSuccessMessage')]"));
            wait.until(ExpectedConditions.visibilityOf(addToBagSuccessMessage));
            System.out.println("Product added to Bag!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void searchAndAddSpecificDressToBag(WebDriver driver, String searchTerm) {
        try {
            // Locate the search box element
            WebElement searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
            // Enter search query
            searchBox.sendKeys(searchTerm);

            // Click search button
            WebElement searchButton = driver.findElement(By.xpath("//a[@class='desktop-submit']"));
            searchButton.click();

            // Wait for search results to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".results-base .product-base")));

            // Click on the specific dress
            WebElement specificDress = driver.findElement(By.xpath("//*[@id=\"28886552\"]/a/div[2]"));
            specificDress.click();

            // Wait for product page to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"sizeButtonsContainer\"]/div[2]")));

            // Select size S
            WebElement sizeButton = driver.findElement(By.xpath("//*[@id=\"sizeButtonsContainer\"]/div[2]/div[2]/div[1]/button"));
            sizeButton.click();

            // Wait for Add to Bag button to be clickable and click it
            WebElement addToBagButton = driver.findElement(By.xpath("//*[@id=\"mountRoot\"]/div/div[1]/main/div[2]/div[2]/div[2]/div[2]/div/div[1]"));
            addToBagButton.click();

            // Wait for success message or confirmation
            WebElement addToBagSuccessMessage = driver.findElement(By.xpath("//div[contains(@class, 'addToBagSuccessMessage')]"));
            wait.until(ExpectedConditions.visibilityOf(addToBagSuccessMessage));
            System.out.println("Specific dress added to Bag!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
