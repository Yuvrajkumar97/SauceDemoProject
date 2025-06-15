package org.utilities;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PropertiesFileHandling {
	
	public static Properties load(String fileName) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("../SauceDemoProject/PropertiesFiles/"+ fileName.trim() +".properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
	public static Properties configload(String fileName) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("../SauceDemoProject/src/test/resources/"+ fileName.trim() +".properties")) {
            props.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
	
	}

	