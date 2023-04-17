package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class searchfield {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-notifications");
        driver = new ChromeDriver(options);
    }

    @Test(description = "User can search item successful")
    void checkSearch_product() throws InterruptedException {
        driver.get("https://www.bewakoof.com/");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/header/div[2]/div/div[3]/div[2]/div/form/input")).sendKeys("shirts");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[1]/header/div[2]/div/div[3]/div[2]/div/form/input")).sendKeys(Keys.ENTER);
        System.out.println("Searched Item Succesfully");
    }

    @AfterMethod
    void tearDown() {
        driver.close();
    }
}