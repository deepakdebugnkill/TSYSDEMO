package com.demo.api.payload;

import com.demo.api.pojo.AuthPojo;

/**
 * @description `AuthPayload`: A class providing an authentication payload for API requests through an `AuthPojo` object.
 */
public class AuthPayload {

//	private static final ObjectMapper objectMapper = new ObjectMapper();

	public AuthPojo authPayLoad()  {
		String defaultUsername = "admin";
		String defaultPassword = "password123";
		return new AuthPojo(defaultUsername, defaultPassword);
	}

//	public AuthPojo authPayLoad() {
//			AuthPojo authPojo = objectMapper.readValue(
//					new File("src\test\resources\Auth.json"),AuthPojo.class);
//			return authPojo;
//	}

}
