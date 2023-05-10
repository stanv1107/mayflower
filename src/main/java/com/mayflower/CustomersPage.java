package com.mayflower;

import org.apache.commons.text.StringEscapeUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersPage {
    private WebDriver driver;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTable() {
        return driver.findElement(By.id("divResultSQL"));
    }

    public WebElement runButton(){
        return driver.findElement(By.cssSelector(".ws-btn"));
    }

    public void executeSql(String sql){
        WebElement inputField = driver.findElement(By.cssSelector(".CodeMirror-scroll"));
        System.out.println("Element found");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        System.out.println("Executor is initialized");
        String escapedSql = escapeJavaScript(sql);
        System.out.println("String escaped: " + escapedSql);
        String script = "window.editor.setValue('" + escapedSql + "');";
        System.out.println("Script: " + script);
        jsExecutor.executeScript(script, inputField);
        System.out.println("");
        runButton().click();
        System.out.println("");

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

    public WebElement getCustomerRow(String contactName) {
        return driver.findElement(By.xpath("//table[@id='divResultSQL']//tr[contains(td[2], '" + contactName + "')]"));
    }

    public String getAddressForCustomer(String contactName) {
        WebElement customerRow = getCustomerRow(contactName);
        WebElement addressCell = customerRow.findElement(By.xpath(".//td[4]"));
        return addressCell.getText();
    }
}
