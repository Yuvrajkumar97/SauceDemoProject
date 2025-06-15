package org.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.utilities.PropertiesFileHandling;

public class CartPage {

	private static WebDriver driver;
    private static Properties pr;

	public CartPage(WebDriver driver) {
		this.driver=driver;
		pr = PropertiesFileHandling.load("CartPage");
	}

	public static void gotocart() {	
		driver.findElement(By.xpath(pr.getProperty("cartButton_xpath"))).click();

		if (driver.findElement(By.xpath(pr.getProperty("cartItems_xpath"))).isDisplayed() ){
			System.out.println("Item is visible in the cart");
		}else {
			System.out.println("Item is not visible in the cart");
		}
	}
	public static void removeItemFromCart() {	
		driver.findElement(By.xpath(pr.getProperty("cartButton_xpath"))).click();

		if (driver.findElement(By.xpath(pr.getProperty("cartItems_xpath"))).isDisplayed() ){
			driver.findElement(By.xpath(pr.getProperty("removeCartButton_xpath"))).click();
			System.out.println("Item Removed from cart");
		}else {
			System.out.println("Item is not Removed from cart");
		}




	}

}
