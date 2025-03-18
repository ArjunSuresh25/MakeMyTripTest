package com.makemytrip.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            EdgeOptions options = new EdgeOptions();
            options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
            driver = new EdgeDriver(options);  // Assign the instance to the class variable
        	//driver = new ChromeDriver();
        	driver.manage().window().maximize();
  
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
