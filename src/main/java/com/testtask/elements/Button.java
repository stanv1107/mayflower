package com.testtask.elements;

import com.testtask.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends BaseElement {

    private String name;

    public Button(WebDriver driver, By locator, String name) {
        super(driver, locator);
        this.name = name;
    }

    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        LoggerUtil.info("Button '" + name + "' clicked.");
    }

}