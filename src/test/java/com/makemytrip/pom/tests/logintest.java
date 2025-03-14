package com.makemytrip.pom.tests;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.makemytrip.utils.DriverManager;
import com.mytrip.pom.pages.loginpage;

public class logintest{
WebDriver driver;
WebDriverWait wait;
loginpage loginPage;
@BeforeClass
public void setup() throws Exception {
    driver = DriverManager.getDriver();
    loginPage = new loginpage(driver);
    driver.get("https://www.makemytrip.com/");
    //loginPage.closepopup();
    
    wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //WebElement closeButton=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("commonModal__close"))));
    WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'commonModal__close')]")));
    closeButton.click();
    //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/div[2]/img"))));
    loginPage.goToLogin();
    loginPage.selectmail();
}
@Test(groups = "login")
public void testLogin() {
	
    loginPage.enterUsername("yisojak371@payposs.com");
    loginPage.enterPassword("testtest@123");
    loginPage.clickLogin();
    boolean cnd = driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[4]/div[2]/p")).getText().contains("Hi");
    Assert.assertTrue(cnd);
}

//@AfterClass
//public void teardown() {
//    DriverManager.quitDriver();
//}
}
