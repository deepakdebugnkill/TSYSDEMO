package com.demo.ui.validation;

import org.testng.Assert;

public class TestNGUtils {

	public static void assertTrue(boolean condition, String message) {

		Assert.assertTrue(condition, message);

	}

	public static void assertFalse(boolean condition, String message) {

		Assert.assertFalse(condition, message);

	}

	public static void assertEquals(Object actual, Object expected, String message) {

		Assert.assertEquals(actual, expected, message);

	}

	public static void assertNotEquals(Object actual, Object expected, String message) {

		Assert.assertNotEquals(actual, expected, message);

	}

	public static void assertNull(Object object, String message) {

		Assert.assertNull(object, message);

	}

	public static void assertNotNull(Object object, String message) {

		Assert.assertNotNull(object, message);

	}

	public static void fail(String message) {

		Assert.fail(message);

	}

	public static void assertTrue(boolean condition) {

		Assert.assertTrue(condition);

	}

	public static void assertFalse(boolean condition) {

		Assert.assertFalse(condition);

	}

	public static void assertEquals(Object actual, Object expected) {

		Assert.assertEquals(actual, expected);

	}

	public static void assertNotEquals(Object actual, Object expected) {

		Assert.assertNotEquals(actual, expected);

	}

	public static void assertNull(Object object) {

		Assert.assertNull(object);

	}

	public static void assertNotNull(Object object) {

		Assert.assertNotNull(object);

	}

}
