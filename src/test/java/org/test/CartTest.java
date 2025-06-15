package org.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.pages.CartPage;
import org.pages.LoginPage;
import org.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends Base {

	public static LoginPage login;
	public static CartPage cart;
	public static ProductPage product;

	@Test(priority=4)
	public void TC4() throws IOException {
		try {
			logger.info("URL Open Please enter login details");
			login = new LoginPage(driver);
			login.loginWithValidUserName("standard_user", "secret_sauce");
			logger.info("Login successfully");
		
			product = new ProductPage(driver);
			logger.info("Add Items to cart");
			product.additemstocart();
			cart = new CartPage(driver);
			logger.info("Go to Cart");
			cart.gotocart();
			logger.info("Item is available in the cart");



		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Test case 4 failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
	}

	@Test(priority=5)
	public void TC5() throws IOException {
		try {
			login = new LoginPage(driver);
			logger.info("URL Open Please enter login details");
			LoginPage.loginWithValidUserName("standard_user", "secret_sauce");
			login.loginWithValidUserName("standard_user", "secret_sauce");
			product = new ProductPage(driver);
			logger.info("Add Items to cart");
			product.additemstocart();

			cart = new CartPage(driver);
			logger.info("Go to Cart");
			cart.gotocart();
			logger.info("remove item from Cart");
			cart.removeItemFromCart();
			logger.info("Item removed from Cart");

		} catch (InterruptedException e) {
			e.printStackTrace();
			logger.info("Test case 5 failed");
			logger.debug("Debug logs");
			Assert.fail();
		}	

	}

}
