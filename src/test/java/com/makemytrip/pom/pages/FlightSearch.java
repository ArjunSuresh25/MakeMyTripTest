package com.makemytrip.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FlightSearch {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "fromCity")
    WebElement fromCity;

    @FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")
    WebElement fromInput;

    @FindBy(id = "toCity")
    WebElement toCity;

    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement toInput;

//    @FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[7]/div")
//    WebElement departureDate;

    @FindBy(xpath = "//a[text()='Search']")
    WebElement searchButton;

    public FlightSearch(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void selectFromCity(String from) {
        fromCity.sendKeys(from);
        //fromInput.sendKeys(from);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'" + from + "')]"))).click();
    }

    public void selectToCity(String to) {
        toCity.click();
        toInput.sendKeys(to);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'" + to + "')]"))).click();
    }

//    public void selectDepartureDate() {
//        departureDate.click();
//    }
    public void selectDepartureDate() {
        LocalDate date = LocalDate.now().plusDays(7);
        String formattedDate = date.format(DateTimeFormatter.ofPattern("EEE MMM dd yyyy"));
        String xpath = String.format("//div[@aria-label='%s']", formattedDate);
        WebElement dateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dateElement);
        wait.until(ExpectedConditions.elementToBeClickable(dateElement)).click();
    }
    public void clickSearch() {
        searchButton.click();
    }
}