package com.testtask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    protected CustomersPage customersPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all");
        customersPage = new CustomersPage(driver);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}