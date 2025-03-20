package com.makemytrip.pom.tests;

import org.testng.annotations.Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import com.makemytrip.pom.pages.FlightSearch;
import com.makemytrip.utils.DriverManager;

public class FlightSearchTest {
    WebDriver driver;
    FlightSearch flightSearch;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get("https://www.makemytrip.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'commonModal__close')]")));
        closeButton.click();
        flightSearch = new FlightSearch(driver);
    }

    @Test(priority=2, groups = "flight")
    public void testFlightSearch() {
        flightSearch.selectFromCity("Bengaluru");
        flightSearch.selectToCity("Mumbai");
        flightSearch.selectDepartureDate();
        flightSearch.clickSearch();
    }

    @AfterClass
    public void teardown() {
        DriverManager.quitDriver();
    }
}
