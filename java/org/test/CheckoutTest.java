package org.test;

import java.io.IOException;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.WebDriver;
import org.pages.CartPage;
import org.pages.CheckOutPage;
import org.pages.LoginPage;
import org.pages.ProductPage;
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
				login.loginWithValidUserName("standard_user", "secret_sauce");	
				product = new ProductPage(driver);
				product.additemstocart();

				cart = new CartPage(driver);
				cart.gotocart();
				checkout = new CheckOutPage(driver);
				checkout.fillCheckoutInfo(random.randomString(), random.randomString(), random.randomNumber());
				checkout.finishCheckout();
				checkout.getConfirmationMessage();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
		}
	@Test(priority=7)
			public void TC7() throws IOException {
				try {
					login = new LoginPage(driver);
					login.loginWithValidUserName("standard_user", "secret_sauce");
					
					product = new ProductPage(driver);
					product.additemstocart();
				
					cart = new CartPage(driver);
					cart.gotocart();
					checkout = new CheckOutPage(driver);
					checkout.fillCheckoutInfo(random.randomString(), random.randomString(), random.randomNumber());
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
	}

}

