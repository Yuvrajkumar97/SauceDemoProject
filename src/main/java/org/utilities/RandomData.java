package org.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

	public static String randomString() {
		String generatedString= RandomStringUtils.randomAlphabetic(4);
		return generatedString;
	}
	public static String randomNumber() {
		String generatedString= RandomStringUtils.randomNumeric(5);
		return generatedString;
	}
	public static String alphaNumeric() {
		String generatedString= RandomStringUtils.randomAlphanumeric(5);
		return generatedString;
	}

}
