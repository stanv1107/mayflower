package com.testtask.utils;

import org.testng.Assert;

public class AssertionUtils {

    public static void assertEqualStrings(String actual, String expected, String message) {
        Assert.assertEquals(actual, expected, message);
        LoggerUtil.info("Expected: " + expected);
        LoggerUtil.info("Actual: " + actual);
    }

    public static void assertEquals(int actual, int expected, String message) {
        Assert.assertEquals(actual, expected, message);
        LoggerUtil.info("Expected: " + expected);
        LoggerUtil.info("Actual: " + actual);
    }

    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
        LoggerUtil.info("Expected: true");
        LoggerUtil.info("Actual: " + condition);
    }

    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
        LoggerUtil.info("Expected: false");
        LoggerUtil.info("Actual: " + condition);
    }

}