package com.testtask.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Label extends BaseElement {

    public Label(WebDriver driver, By locator, String name) {
        super(driver, locator);
    }

}