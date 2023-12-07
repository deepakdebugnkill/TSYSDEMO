package com.demo.api.common_utils;


import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.Map;

/**
 * @description The `BaseClass` serves as a foundational class providing essential functionalities for the application or framework.
 */
public class BaseClass {

	public RequestSpecification reqspec;
	public static Response response;
	public static final Logger log = (Logger) LogManager.getLogger(BaseClass.class);

	public void addHeader(String key, String value) {
		try {
			reqspec = RestAssured.given().header(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to add header: " + key + " with value" + value);
		}
	}

	public void addHeaders(Headers headers) {
		try {
			reqspec = RestAssured.given().headers(headers);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to add headers: " + headers.toString());
		}
	}

	public void addHeaders(Map<String, String> headers) {
		try {
			reqspec = reqspec.headers(headers);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to add headers: " + headers.toString());
		}
	}

	public void addBasicAuth(String username, String password) {
		try {
			reqspec = reqspec.auth().preemptive().basic(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPathparam(String key, String value) {
		try {
			reqspec = reqspec.pathParam(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to add path param" + key + " with value: " + value);
		}
	}

	public void addQueryparam(String key, String value) {
		try {
			reqspec = reqspec.queryParam(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to add query param" + key + " with value: " + value);
		}
	}

	public void addBody(String body) {
		try {
			reqspec = reqspec.body(body);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to set request body" + e.getMessage());
		}
	}

	public void addBody(Object body) {
		try {
			reqspec = reqspec.body(body);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to set request body" + e.getMessage());
		}
	}
	
	public  void addBodywithContentType(Object body) {
		try {
			reqspec = reqspec.contentType(ContentType.JSON).body(body);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to set request body" + e.getMessage());
		}
	}

	public Response requestType(String type, String endpoint) {
		try {
			switch (type) {
			case "GET":
				response = reqspec.log().all().get(endpoint);
				break;
			case "POST":
				response = reqspec.log().all().post(endpoint);
				break;
			case "PUT":
				response = reqspec.log().all().put(endpoint);
				break;
			case "PATCH":
				response = reqspec.log().all().patch(endpoint);
				break;
			case "DELETE":
				response = reqspec.log().all().delete(endpoint);
				break;
			default:
				throw new IllegalArgumentException("Invalid request type" + type);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to send " + type + " request to " + endpoint);
		}
		return response;
	}

	public int getstatuscode(Response response) {
		try {
			int statusCode = response.getStatusCode();
			return statusCode;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	public String getAsstring(Response response) {
		try {
			String asString = response.asString();
			return asString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getasprettyformat(Response response) {
		try {
			String asPrettyString = response.getBody().asPrettyString();
			return asPrettyString;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addFormData(String key, String value) {
		try {
			reqspec = reqspec.multiPart(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
//	public static void validateResponseHeaders(Response response, Map<String, String> expectedHeaders) {
//
//		Headers actualHeaders = response.getHeaders();
//
//		for (Map.Entry<String, String> entry : expectedHeaders.entrySet()) {
//
//			String headerName = entry.getKey();
//
//			String expectedValue = entry.getValue();
//
//			String actualValue = actualHeaders.getValue(headerName);
//
//			Assert.assertEquals(actualValue, expectedValue,
//					"Header '" + headerName + "' does not match the expected value.");
//
//		}
//
//	}
//
	public static void assertStatusCode(Response response, int expectedStatusCode) {

		try {

			Assert.assertEquals(response.getStatusCode(), expectedStatusCode);

		} catch (AssertionError e) {

			e.printStackTrace();

			throw new RuntimeException("Expected status code " + expectedStatusCode +

					", but got " + response.getStatusCode());

		}

	}
	
	public static String extractResponse( String key) {
		return response.then().extract().path(key);
	}

//	public static void assertResponseBodyContains(Response response, String expectedText) {
//
//		try {
//
//			Assert.assertTrue(response.getBody().asString().contains(expectedText));
//
//		} catch (AssertionError e) {
//
//			e.printStackTrace();
//
//			throw new RuntimeException("Response body does not contain expected text: " + expectedText);
//
//		}
//
//	}
//
//	public static void validateJsonSchema(Response response, String schemaFilePath) {
//
////		response.then().assertThat().body(matchesJsonSchema(new File(schemaFilePath)));
//
//	}

//	public void validateResponseTime(Response response, long expectedResponseTimeMs) {
//
//		long actualResponseTime = response.getTime();
//
//		Assert.assertTrue(actualResponseTime <= expectedResponseTimeMs, "Response time exceeds the expected time.");
//
//	}
//
//	public void validateJsonPathValue(Response response, String jsonPathExpression, Object expectedValue) {
//
//		Object actualValue = response.jsonPath().get(jsonPathExpression);
//
//		Assert.assertEquals(actualValue, expectedValue, "JSON path value does not match the expected value.");
//
//	}
//
//	public void validateXmlPathValue(Response response, String xmlPathExpression, Object expectedValue) {
//
//		Object actualValue = response.xmlPath().get(xmlPathExpression);
//
//		Assert.assertEquals(actualValue, expectedValue, "XML path value does not match the expected value.");
//
//	}
//
//	public void validateJsonPathContains(Response response, String jsonPathExpression, String expectedValue) {
//
//		String actualValue = response.jsonPath().getString(jsonPathExpression);
//
//		Assert.assertTrue(actualValue.contains(expectedValue), "JSON path does not contain the expected value.");
//
//	}
//
//	public Response retryRequest(int maxAttempts, int retryIntervalMs, RequestSpecification requestSpec) {
//
//		for (int attempt = 1; attempt <= maxAttempts; attempt++) {
//
//			Response response = requestSpec.get();
//
//			if (response.getStatusCode() == 200) {
//
//				return response;
//
//			}
//
//			try {
//
//				Thread.sleep(retryIntervalMs);
//
//			} catch (InterruptedException e) {
//
//				Thread.currentThread().interrupt();
//
//			}
//
//		}
//
//		throw new RuntimeException("Max retry attempts reached.");
//
//	}
	
//	public void addFormData(String paramName, String paramValue) {
//		try {
//			reqspec = reqspec.contentType(ContentType.URLENC).formParam(paramName, paramValue);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("Failed to set form parameter" + paramName + "with value: " + paramValue);
//		}
//	}

//	public static void initializeRequestSpecification() {
//		reqSpec = new RequestSpecBuilder().setContentType("application/json").build();
//	}
//
//	public static void setBasicAuth(String username, String password) {
//		try {
//			if (reqSpec == null) {
//				initializeRequestSpecification();
//			}
//			reqSpec.given().header("Content-Type", "application/json").auth().preemptive().basic(username, password);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("Failed to set basic authentication with username");
//		}
//	}
}
