package com.makemytrip.pom.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.makemytrip.utils.ConvertDateFormat;

public class HotelBookingPage {
    WebDriver driver;
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));;

    // Locators for hotel search
    By destination = By.xpath("//*[@id=\"city\"]");
    By checkInDate = By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[1]/div/div[1]/p/span[2]");
    By checkOutDate = By.xpath("//input[@placeholder='Check-out Date']");
    By searchButton = By.xpath("//*[@id=\"hsw_search_button\"]");

    // Constructor
    public HotelBookingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDestination(String place) {
        driver.findElement(destination).click();
        driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/div/div/div/div[1]/input")).sendKeys(place);
        driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div/div/p/span/b")).click();
    }

    public void enterCheckInDate(String date) {
    	
    	String date1XPath = "//div[contains(@class,'DayPicker-Day') and @aria-disabled='false' and @aria-label='Thu Apr 10 2025']";
    	String date2XPath = "//div[contains(@class,'DayPicker-Day') and @aria-disabled='false' and @aria-label='Thu Apr 17 2025']";
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(date1XPath)))).click();
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(date2XPath)))).click();
    	

        String formattedDate = ConvertDateFormat.convertDate(date);
        String xpath = String.format("//div[@aria-label='%s']", formattedDate);
        
        System.out.println("Trying to find date with XPath: " + xpath);  // Debugging
//
//        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElement);
//        wait.until(ExpectedConditions.elementToBeClickable(dateElement)).click();
//        driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div[2]/div[2]"));
//        driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[2]"));
    }

    public void enterCheckOutDate(String date) {
    	wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@data-cy='RoomsGuestsNew_327']"))));
    	driver.findElement(By.xpath("//button[@data-cy='RoomsGuestsNew_327']")).click();

        String formattedDate = ConvertDateFormat.convertDate(date);
        String xpath = String.format("//div[@aria-label='%s']", formattedDate);

        System.out.println("Trying to find date with XPath: " + xpath);  // Debugging

//        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElement);
//        wait.until(ExpectedConditions.elementToBeClickable(dateElement)).click();
    }


    public void clickSearch() {
        driver.findElement(searchButton).click();
    }
}