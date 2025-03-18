package com.makemytrip.pom.pages;

import static org.junit.Assert.assertFalse;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class loginpage{
WebDriver driver;
WebDriverWait wait;

// Locators

private By signin=By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[4]");
private By usernameField = By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[1]/div/input");
private By passwordField = By.id("password");
private By loginButton = By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[2]/button");
private By continueButton = By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[2]/button");
// Constructor
public loginpage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}
// Methods
public void closepopup() {
	driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
}
public void selectmail() {
	driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/div[2]/img")).click();
}
public void goToLogin() {
	driver.findElement(signin).click();
}
public void enterUsername(String username) {
    driver.findElement(usernameField).sendKeys(username);
    WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[2]/button")));
    continueBtn.click();
    try {
        // Wait for password field to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
    } catch (TimeoutException e) {
        // Fail the test if password field is not displayed
        Assert.fail("Password field did not appear after clicking continue button.");
    }
    //driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[2]/button")).click();
}
public void enterPassword(String password) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))); 
    passwordField.sendKeys(password);
}
public void clickLogin() {
    driver.findElement(loginButton).click();
}
}