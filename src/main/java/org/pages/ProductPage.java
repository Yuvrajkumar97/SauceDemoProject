package org.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.utilities.PropertiesFileHandling;

public class ProductPage {
	private static WebDriver driver;
    private static Properties pr;
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		pr = PropertiesFileHandling.load("ProductPage");
	}

	public static void additemstocart() throws InterruptedException {
		driver.findElement(By.xpath(pr.getProperty("additemscart_xpath"))).click();		
		Thread.sleep(2000);
	}
	public static void SortBy(String value) throws InterruptedException {

		WebElement sortdropdown= driver.findElement(By.xpath(pr.getProperty("dropdwnsort_xpath")));
		Thread.sleep(2000);
		sortdropdown.click();
		Thread.sleep(2000);
		Select select= new Select(sortdropdown);
		select.selectByVisibleText(value);
		Thread.sleep(2000);
	}

}
