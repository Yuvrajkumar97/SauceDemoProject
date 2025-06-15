package org.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.utilities.PropertiesFileHandling;

public class MenuPage {
	public static WebDriver driver;
	private static Properties pr;

	public MenuPage(WebDriver driver) {
		this.driver=driver;
		pr = PropertiesFileHandling.load("MenuPage");
	}
	public static void Logoutbuttonisdisplayed() throws InterruptedException {
		driver.findElement(By.xpath(pr.getProperty("openmenu_xpath"))).click();
		WebElement logout=driver.findElement(By.xpath(pr.getProperty("logoutbutton_xpath")));
		Thread.sleep(2000);
		if (logout.isDisplayed()) {
			logout.click();
			Thread.sleep(2000);
		}
	}

	/*public static void ResetAppFunctionlity() {
	driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
	WebElement reset=driver.findElement(By.xpath("//a[text()='Reset App State']"));
	if (reset.isDisplayed()) {
		reset.click();		 
	}

	}
	 */
}
