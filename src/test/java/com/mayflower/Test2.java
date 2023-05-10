package com.mayflower;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test2 {
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
    public void thisIsTheTest(){
        System.out.println("Start test");
        customersPage.executeSql("SELECT * FROM Customers WHERE City = 'Berlin'");
    }

    /*@Test
    public void testGetAllCustomers() {
        // Выводим все строки таблицы Customers
        String tableText = customersPage.getTable().getText();
        System.out.println(tableText);

        Assert.assertTrue(tableText.contains("Giovanni Rovelli"));
    }

    @Test
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
