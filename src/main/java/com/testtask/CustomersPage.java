package com.testtask;

import com.testtask.elements.Button;
import com.testtask.elements.Label;
import com.testtask.elements.Table;
import com.testtask.elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomersPage {

    private WebDriver driver;

    public Button runButton;
    public Table table;
    public TextField sqlStatementTextField;
    public Label resultLabel;

    public CustomersPage(WebDriver driver) {
        this.driver = driver;

        runButton = new Button(driver, By.cssSelector(".ws-btn"), "Run SQL");
        table = new Table(driver, By.id("divResultSQL"), By.cssSelector("table.ws-table-all tbody tr:not(:first-child)"));
        sqlStatementTextField = new TextField(driver, By.cssSelector(".CodeMirror-scroll"), "SQL Statement");

    }

    public void initResultLabel() {
        resultLabel = new Label(driver, By.xpath(
                "//div[@id='divResultSQL' and contains(., 'You have made changes to the database.')]"),
                "Result Label");
    }

}