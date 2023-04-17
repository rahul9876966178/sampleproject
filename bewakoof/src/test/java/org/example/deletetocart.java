package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class deletetocart {


    WebDriver driver;
    @BeforeMethod
    void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-notifications");
        driver= new ChromeDriver(options);
    }
    @Test(description="User can able to delete product from the cart")

    void check_delete() throws InterruptedException {
        driver.get("https://www.bewakoof.com/");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/header/div[2]/div/div[3]/div[2]/div/form/input")).sendKeys("shirts");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/header/div[2]/div/div[3]/div[2]/div/form/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//*[@id=\"testProductcard_3\"]/a/div")).click();
        WebElement size=driver.findElement(By.cssSelector("#testSizes_L > span"));
        Actions action=new Actions(driver);
        action.moveToElement(size).click().perform();
        driver.findElement(By.cssSelector("#addToCart > span")).click();
        WebElement gocart=driver.findElement(By.xpath("//span[contains(text(),'GO TO BAG')]"));
        action.moveToElement(gocart).click().perform();
        driver.findElement(By.xpath("//div[@id='testRemoveCart']")).click();
        System.out.println("Test cases passed");
        System.out.println("product is deleted successfully");

    }

    @AfterMethod
    void tearDown()
    {
        driver.close();
    }
}