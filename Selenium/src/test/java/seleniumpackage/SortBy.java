package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SortBy {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        WebDriver driver = new ChromeDriver();

        // Go to Myntra page
        driver.get("https://www.myntra.com/");

        // Locate the search box element
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
        // Enter search query
        searchBox.sendKeys("women dresses");

        // Click search button
        WebElement searchButton = driver.findElement(By.xpath("//a[@class='desktop-submit']"));
        searchButton.click();


        // Wait for search results to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find sort button
        WebElement sortButton = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div"));
        sortButton.click();

        // Wait for 2 seconds to see the sort button click
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement arrow = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div/span[2]"));
        arrow.click();

        // Wait for 2 seconds to see the arrow click
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Select "What's New" from sort options
         WebElement whatsNewOption = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[1]/div/div/div/span[1]"));
         whatsNewOption.click();
         try {
             Thread.sleep(2000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
        // size option 
        WebElement sizeoption = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[2]/ul/li[3]/label/h4"));
        sizeoption.click();
     
        WebElement sizeoptionS = driver.findElement(By.xpath("//*[@id=\"desktopSearchResults\"]/div[1]/section/div[1]/div[2]/div/ul/li[5]/label"));
        sizeoptionS.click();
        

        // Wait for 2 seconds to see the size option click
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        


        // Close the browser
        driver.quit();
    }
}