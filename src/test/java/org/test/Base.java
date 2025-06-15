package org.test;



import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.utilities.PropertiesFileHandling;

import java.net.MalformedURLException;
import java.net.URL;


public class Base {
	public static Logger logger;
	public static WebDriver driver;
	public static Properties pr;

	
	
	@BeforeMethod
	//@Parameters({"chrome"})

	public void BrowserSetup(){
		pr = PropertiesFileHandling.configload("config");
		logger = LogManager.getLogger(this.getClass());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		 /*ChromeOptions options = new ChromeOptions();
         String hubHost = System.getenv("HUB_HOST") != null ? System.getenv("HUB_HOST") : "localhost";

         try {
			driver = new RemoteWebDriver(
			         new URL("http://" + hubHost + ":4444/wd/hub"),
			         options
			 );
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
         driver.manage().window().maximize();
		
		//driver.get("https://www.saucedemo.com/");
		driver.get(pr.getProperty("appURL"));
		

	}
	@AfterMethod
	public static void TearDown(){
		if (driver != null) {
            driver.quit();
        }

	}

}

