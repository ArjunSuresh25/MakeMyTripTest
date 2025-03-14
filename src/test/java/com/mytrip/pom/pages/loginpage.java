package com.mytrip.pom.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginpage{
WebDriver driver;
WebDriverWait wait;

// Locators

private By signin=By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[4]");
private By usernameField = By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[1]/div/input");
private By passwordField = By.id("pass");
private By loginButton = By.id("sgnBt");
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
    WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
    continueBtn.click();
    driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/form/div[2]/button")).click();
}
public void enterPassword(String password) {
    driver.findElement(passwordField).sendKeys(password);
}
public void clickLogin() {
    driver.findElement(loginButton).click();
}
}