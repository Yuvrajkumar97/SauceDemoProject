package org.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.utilities.PropertiesFileHandling;

public class LoginPage {
	private static WebDriver driver;
    private static Properties pr;
	public LoginPage(WebDriver driver) throws IOException {
		this.driver=driver;
		pr = PropertiesFileHandling.load("LoginPage");
	}

	public static  void loginWithValidUserName(String username, String password) throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(pr.getProperty("username_xpath"))).sendKeys(username);
		driver.findElement(By.id(pr.getProperty("password_id"))).sendKeys(password);
		driver.findElement(By.id(pr.getProperty("loginbutton_id"))).click();
		if (driver.getTitle().contains("Swag Labs")) {
			System.out.println("Redirected to inventory page");
		} else if (driver.findElement(By.xpath(pr.getProperty("loginerror_xpath"))).getText().equals("Epic sadface: Username is required")) {
			System.out.println("Username & password is required");	
		}
	}

	public  void loginWithLockedOutUserName(String username, String password) throws InterruptedException {
		driver.findElement(By.xpath(pr.getProperty("username_xpath"))).sendKeys(username);
		driver.findElement(By.id(pr.getProperty("password_id"))).sendKeys(password);
		driver.findElement(By.id(pr.getProperty("loginbutton_id"))).click();
		boolean lockederror=driver.findElement(By.xpath(pr.getProperty("lockederror_xpath"))).isDisplayed();
		if (lockederror==true) {
			System.out.println("Error message is displayed");
		}
	}


}
