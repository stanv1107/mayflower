package com.testtask;

import com.testtask.utils.AssertionUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSuite extends BaseTest {

    @Test
    /* Задание 1: Вывести все строки таблицы Customers и убедиться, что запись с
    ContactName равной 'Giovanni Rovelli' имеет Address = 'Via Ludovico il Moro 22'. */
    public void task1() {
        customersPage.runButton.click();
        String address = customersPage.table.getAddressForCustomer("Giovanni Rovelli");
        AssertionUtils.assertEqualStrings(address, "Via Ludovico il Moro 22",
                "Address for 'Giovanni Rovelli' does not match the expected value.");
    }

    @Test
    /* Задание 2: Вывести только те строки таблицы Customers, где city='London'.
    Проверить, что в таблице ровно 6 записей. */
    public void task2() {
        customersPage.sqlStatementTextField.sendKeysViaJs(
                "SELECT * FROM Customers WHERE City = 'London';");
        customersPage.runButton.click();
        int rowCount = customersPage.table.getRows().size();
        AssertionUtils.assertEquals(rowCount, 6,
                "Row count does not match the expected value.");
    }

    @DataProvider(name = "customerData")
    public Object[][] provideCustomerData() {
        Customer insertCustomer = new Customer(
                "Test Customer Name",
                "Test Contact Name",
                "Test Address",
                "Test City",
                "Test Postal Code",
                "Test Country");
        Customer updateCustomer = new Customer(
                "Updated Company",
                "Updated Contact",
                "Updated Address",
                "Updated City",
                "Updated Postal Code",
                "Updated Country");

        return new Object[][]{
                {insertCustomer, "INSERT INTO Customers "
                                 + "(CustomerName, ContactName, Address, City, PostalCode, Country) "
                                 + "VALUES ('%s', '%s', '%s', '%s', '%s', '%s');"},
                {updateCustomer, "UPDATE Customers "
                                 + "SET CustomerName = '%s', ContactName = '%s', "
                                 + "Address = '%s', City = '%s', PostalCode = '%s', "
                                 + "Country = '%s' WHERE CustomerID = 1;"}
        };
    }

    @Test(dataProvider = "customerData")
    /* Задание 3: Добавить новую запись в таблицу Customers и проверить, что эта запись добавилась.
    Задание 4: Обновить все поля (кроме CustomerID) в любой записи таблицы Customers и проверить,
     что изменения записались в базу. */
    public void task3And4(Customer customer, String sqlTemplate) {
        String sqlStatement = String.format(sqlTemplate,
                customer.getCustomerName(),
                customer.getContactName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getPostalCode(),
                customer.getCountry());
        customersPage.sqlStatementTextField.sendKeysViaJs(sqlStatement);
        customersPage.runButton.click();
        customersPage.initResultLabel();
        customersPage.sqlStatementTextField.sendKeysViaJs("SELECT * FROM Customers;");
        customersPage.runButton.click();
        boolean isRecordFound = customersPage.table.isRecordFoundInTable(
                customer.getCustomerName(),
                customer.getContactName(),
                customer.getAddress(),
                customer.getCity(),
                customer.getPostalCode(),
                customer.getCountry());
        AssertionUtils.assertTrue(isRecordFound, "The record was not found in the table.");
    }

    @Test
    // Задание 5: Удалить все строки из таблицы Customers, у которых Country = 'Mexico'.
    public void task5() {
        customersPage.sqlStatementTextField.sendKeysViaJs("DELETE FROM Customers "
                                                          + "WHERE Country = 'Mexico';");
        customersPage.runButton.click();
        customersPage.initResultLabel();
        customersPage.sqlStatementTextField.sendKeysViaJs("SELECT * FROM Customers;");
        customersPage.runButton.click();
        boolean isRecordFound = customersPage.table.isRecordFoundInTable("Mexico");
        AssertionUtils.assertFalse(isRecordFound,
                "Records with Country = 'Mexico' are still present in the table.");
    }

}