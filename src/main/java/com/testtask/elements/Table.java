package com.testtask.elements;

import com.testtask.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public WebElement getCustomerRowByContactName(String contactName) {
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
        WebElement customerRow = getCustomerRowByContactName(contactName);
        WebElement addressCell = customerRow.findElement(By.cssSelector("td:nth-child(4)"));
        return addressCell.getText();
    }

    public boolean isRecordFoundInTable(String... values) {
        List<WebElement> rows = getRows();
        for (WebElement row : rows) {
            boolean isMatch = true;
            for (String value : values) {
                if (!row.getText().contains(value)) {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) {
                LoggerUtil.info("Found record in table: " + row.getText());
                return true;
            }
        }
        LoggerUtil.error("Record not found in table.");
        return false;
    }

}