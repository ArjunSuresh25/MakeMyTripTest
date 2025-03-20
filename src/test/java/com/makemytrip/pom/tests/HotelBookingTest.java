package com.makemytrip.pom.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.makemytrip.pom.pages.HotelBookingPage;
import com.makemytrip.utils.DriverManager;
import com.makemytrip.utils.ExcelReader;

public class HotelBookingTest {
    WebDriver driver;
    HotelBookingPage hotelPage;
    ExcelReader excelReader;
    WebDriverWait wait;
    @BeforeClass
    public void setUp() {
    	driver = DriverManager.getDriver();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.get("https://www.makemytrip.com/");
        hotelPage = new HotelBookingPage(driver);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'commonModal__close')]")));
        closeButton.click();
        excelReader = new ExcelReader("src/test/resources/TestData.xlsx");
    }

    @Test(priority=3, groups="hotel")
    public void testHotelBooking() {
    	
    	driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[2]/span/a")).click();
    	
        String place = excelReader.getCellData("Sheet1", 0, 1);
        String checkIn = excelReader.getCellData("Sheet1", 1, 1);
        String checkOut = excelReader.getCellData("Sheet1", 2, 1);
        System.out.println("Ran till bedore");
        hotelPage.enterDestination(place);
        System.out.println("PLave select");
        hotelPage.enterCheckInDate(checkIn);
        System.out.println("checkin date");
        hotelPage.enterCheckOutDate(checkOut);
        System.out.println("checkout date");
        hotelPage.clickSearch();
        System.out.println("searfchclied");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
