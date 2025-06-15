package org.pages;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.utilities.PropertiesFileHandling;
import org.utilities.RandomData;

public class CheckOutPage {
	public static WebDriver driver;
	private static Properties pr;
	
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		pr = PropertiesFileHandling.load("Checkout");
		
	}

	public static void fillCheckoutInfo(String firstname,String lastname, String zipcode) {
		driver.findElement(By.xpath(pr.getProperty("checkoutbutton_xpath"))).click();
		driver.findElement(By.id(pr.getProperty("firstname_id"))).sendKeys(firstname);
		driver.findElement(By.id(pr.getProperty("lastname_id"))).sendKeys(lastname);
		driver.findElement(By.id(pr.getProperty("zipcode_id"))).sendKeys(zipcode);
		driver.findElement(By.id(pr.getProperty("continuebutton_id"))).click();
		if(driver.findElement(By.xpath(pr.getProperty("chekoutoverviewpage_xpath"))).getText().contains("Checkout: Overview")) {
			System.out.println("Checkout overview Page is loaded");
		}
		/*else if(driver.findElement(By.xpath("//h3[contains(@data-test,'error')]")).getText().contains("Error: First Name is required")) {
		System.out.println("Checkout info is missing");	
		}*/
	}
	public static void finishCheckout() {
		
		driver.findElement(By.id(pr.getProperty("finishcheckout_id"))).click();
	}
	public static void getConfirmationMessage() {
		
	String confirmation=driver.findElement(By.xpath(pr.getProperty("checkoutconfirmation_xpath"))).getText();
	if (confirmation.contains("Thank you for your order!")) {
		System.out.println("Your order has been dispatched");
	}
	
}
	}
