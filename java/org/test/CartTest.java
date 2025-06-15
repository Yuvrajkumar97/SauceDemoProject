package org.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.pages.CartPage;
import org.pages.LoginPage;
import org.pages.ProductPage;
import org.testng.annotations.Test;

public class CartTest extends Base {

	public static LoginPage login;
	public static CartPage cart;
	public static ProductPage product;

	@Test(priority=4)
	public void TC4() throws IOException {
		try {
			login = new LoginPage(driver);
			login.loginWithValidUserName("standard_user", "secret_sauce");
			product = new ProductPage(driver);
			product.additemstocart();
			cart = new CartPage(driver);
			cart.gotocart();




		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority=5)
	public void TC5() throws IOException {
		try {
			login = new LoginPage(driver);
			LoginPage.loginWithValidUserName("standard_user", "secret_sauce");

			product = new ProductPage(driver);

			product.additemstocart();

			cart = new CartPage(driver);
			cart.gotocart();
			cart.removeItemFromCart();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}	

	}

}
