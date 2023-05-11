package com.mayflower;

import com.mayflower.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSuite {
    private WebDriver driver;
    private CustomersPage customersPage;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/sql/trysql.asp?filename=trysql_select_all");
        customersPage = new CustomersPage(driver);
    }

    @Test
    /* Задание 1: Вывести все строки таблицы Customers и убедиться, что запись с
    ContactName равной 'Giovanni Rovelli' имеет Address = 'Via Ludovico il Moro 22'. */
    public void task1() throws InterruptedException {
        customersPage.runButton().click();
        Thread.sleep(1000);
        String address = customersPage.getAddressForCustomer("Giovanni Rovelli");
        Assert.assertEquals(address, "Via Ludovico il Moro 22");
    }

    @Test
    //Вывести только те строки таблицы Customers, где city='London'. Проверить, что в таблице ровно 6 записей.
    public void task2() {
        customersPage.executeSql("SELECT * FROM Customers WHERE City = 'London';");
        customersPage.runButton().click();
        int rowCount = customersPage.getRows().size();
        LoggerUtil.info("Row count: " + rowCount +", expected: 6");
        Assert.assertEquals(rowCount, 6);
    }

    /*@Test
    public void testAddressForCustomer() {
        // Проверяем запись с ContactName 'Giovanni Rovelli' и Address 'Via Ludovico il Moro 22'
        String address = customersPage.getAddressForCustomer("Giovanni Rovelli");
        Assert.assertEquals(address, "Via Ludovico il Moro 22");
    } */

    @AfterMethod
    public void teardown() throws InterruptedException {
        // Закрываем браузер
        Thread.sleep(4000);
        driver.quit();
    }
}
