package org.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.CartPage;
import org.pages.CheckOutPage;
import org.pages.LoginPage;
import org.pages.MenuPage;
import org.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base {
	
public static LoginPage login;
public static CartPage cart;


	@Test(priority=1)
public void TC1() throws IOException {
		try {
			logger.info("URL Open Please enter login details");
			login = new LoginPage(driver);
			login.loginWithValidUserName("standard_user", "secret_sauce");
			logger.info("Login successfully");
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Test case 1 failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
}
	@Test(priority=2)
public void TC2() throws IOException {
		try {
			logger.info("URL Open Please enter login details");
			login = new LoginPage(driver);
			login.loginWithLockedOutUserName("locked_out_user", "secret_sauce");
			logger.info("Tried login with locked out user");
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Test case 2 failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
}
	@Test(priority=3)
	public void TC3() throws IOException {
		try {
			logger.info("URL Open Please enter login details");
			login = new LoginPage(driver);
			LoginPage.loginWithValidUserName("", "");
			logger.info("Login details are not correct");
		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Test case 3 failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
}

}
