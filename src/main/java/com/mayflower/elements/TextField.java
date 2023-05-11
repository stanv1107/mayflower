package com.mayflower.elements;

import com.mayflower.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TextField extends BaseElement {
    private String name;

    public TextField(WebDriver driver, By locator, String name) {
        super(driver, locator);
        this.name = name;
    }

    public void sendKeysViaJs(String text){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String escapedText = escapeJavaScript(text);
        String script = "arguments[0].value = '" + escapedText + "';";
        jsExecutor.executeScript(script, element);
        LoggerUtil.info(text + " entered to the " + name + " text field");
    }

    private String escapeJavaScript(String input) {
        input = input.replace("\\", "\\\\")
                .replace("'", "\\'")
                .replace("\"", "\\\"")
                .replace("\r", "\\r")
                .replace("\n", "\\n")
                .replace("\t", "\\t")
                .replace("\b", "\\b")
                .replace("\f", "\\f");
        return input;
    }
}
