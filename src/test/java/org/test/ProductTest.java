package org.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.pages.CartPage;
import org.pages.CheckOutPage;
import org.pages.LoginPage;
import org.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends Base {
	public static LoginPage login;

	public static ProductPage product;

	@Test(priority=8)
	public void TC8() throws IOException {
		try {
			logger.info("URL Open Please enter login details");
			login = new LoginPage(driver);
			login.loginWithValidUserName("standard_user", "secret_sauce");
			logger.info("Login successfully");
			product = new ProductPage(driver);

			product.SortBy("Price (low to high)");
			logger.info("Product Sorted");

		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Test case 8 failed");
			logger.debug("Debug logs");
			Assert.fail();
		}

	}
}
