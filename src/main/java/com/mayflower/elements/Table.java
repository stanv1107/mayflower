package com.mayflower.elements;

import com.mayflower.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.NoSuchElementException;

public class Table extends BaseElement {
    private By rowsLocator;

    public Table(WebDriver driver, By locator, By rowsLocator) {
        super(driver, locator);
        this.rowsLocator = rowsLocator;
    }

    public List<WebElement> getRows() {
        List<WebElement> rows = waitUntilElementsVisible(rowsLocator);

        for (WebElement row : rows) {
            LoggerUtil.info("Row: " + row.getText());
        }
        return rows;
    }

    public WebElement getCustomerRow(String contactName) {
        List<WebElement> rows = waitUntilElementsVisible(rowsLocator);

        for (WebElement row : rows) {
            WebElement contactNameCell = row.findElement(By.cssSelector("td:nth-child(3)"));
            if (contactNameCell.getText().equals(contactName)) {
                return row;
            }
        }

        throw new NoSuchElementException("Customer row with contact name '" + contactName + "' not found");
    }

    public String getAddressForCustomer(String contactName) {
        WebElement customerRow = getCustomerRow(contactName);
        WebElement addressCell = customerRow.findElement(By.cssSelector("td:nth-child(4)"));
        return addressCell.getText();
    }
}
