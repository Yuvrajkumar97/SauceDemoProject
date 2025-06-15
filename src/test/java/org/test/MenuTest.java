package org.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pages.CartPage;
import org.pages.LoginPage;
import org.pages.MenuPage;
import org.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends Base {

	public static LoginPage login;

	public static MenuPage menu;
	


	@Test(priority=9)
	public void TC9() throws IOException {
		try {
			logger.info("URL Open Please enter login details");
			login = new LoginPage(driver);
			login.loginWithValidUserName("standard_user", "secret_sauce");
			logger.info("Login successfully");
			menu = new MenuPage(driver);
			menu.Logoutbuttonisdisplayed();
			logger.info("Logout button work properly");

		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Test case 9 failed");
			logger.debug("Debug logs");
			Assert.fail();
		}

	}
}