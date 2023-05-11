package com.mayflower;

import com.mayflower.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class CustomersPage {
    private WebDriver driver;
    Duration timeout = Duration.ofSeconds(10);
    WebDriverWait wait;

    public CustomersPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement getTable() {
        return driver.findElement(By.id("divResultSQL"));
    }

    public WebElement runButton(){
        return driver.findElement(By.cssSelector(".ws-btn"));
    }

}
