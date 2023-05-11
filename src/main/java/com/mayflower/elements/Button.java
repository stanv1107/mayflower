package com.mayflower.elements;

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
        System.out.println("Button '" + name + "' clicked.");
    }
}