package com.testtask.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BaseElement {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebElement element;
    protected Duration timeout = Duration.ofSeconds(10);

    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        this.element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected List<WebElement> waitUntilElementsVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

}