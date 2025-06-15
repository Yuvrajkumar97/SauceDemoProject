package org.test;

import java.io.IOException;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.pages.CartPage;
import org.pages.CheckOutPage;
import org.pages.LoginPage;
import org.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.utilities.RandomData;

public class CheckoutTest extends Base {
	public static LoginPage login;
	public static CartPage cart;
	public static ProductPage product;
	public static CheckOutPage checkout;
	public static RandomData random ;
	

	@Test(priority=6)
		public void TC6() throws IOException {
			try {
				login = new LoginPage(driver);
				logger.info("URL Open Please enter login details");
				login.loginWithValidUserName("standard_user", "secret_sauce");	
				product = new ProductPage(driver);
				product.additemstocart();
				logger.info("Add Items to cart");
				cart = new CartPage(driver);
				logger.info("Go to Cart");
				cart.gotocart();
				checkout = new CheckOutPage(driver);
				logger.info("Fill the checkout info");
				checkout.fillCheckoutInfo(random.randomString(), random.randomString(), random.randomNumber());
				checkout.finishCheckout();
				logger.info("Chekout finished");
				checkout.getConfirmationMessage();
				logger.info("Checkout Confirmed");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				logger.info("Test case 6 failed");
				logger.debug("Debug logs");
				Assert.fail();
		}
		}
	@Test(priority=7)
			public void TC7() throws IOException {
				try {
					login = new LoginPage(driver);
					logger.info("URL Open Please enter login details");
					login.loginWithValidUserName("standard_user", "secret_sauce");
					
					product = new ProductPage(driver);
					logger.info("Add Items to cart");
					product.additemstocart();
				
					cart = new CartPage(driver);
					logger.info("Go to Cart");
					cart.gotocart();
					checkout = new CheckOutPage(driver);
					checkout.fillCheckoutInfo(random.randomString(), random.randomString(), random.randomNumber());
					
				} catch (InterruptedException e) {
					e.printStackTrace();
					logger.info("Test case 7 failed");
					logger.debug("Debug logs");
					Assert.fail();
				}
			
	}

}

