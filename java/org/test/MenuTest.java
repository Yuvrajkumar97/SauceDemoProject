package org.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.pages.CartPage;
import org.pages.LoginPage;
import org.pages.MenuPage;
import org.pages.ProductPage;
import org.testng.annotations.Test;

public class MenuTest extends Base {

	public static LoginPage login;

	public static MenuPage menu;
	


	@Test(priority=9)
	public void TC9() throws IOException {
		try {
			login = new LoginPage(driver);
			login.loginWithValidUserName("standard_user", "secret_sauce");
			menu = new MenuPage(driver);
			menu.Logoutbuttonisdisplayed();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}