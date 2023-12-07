package com.demo.api.pagemanager;


import com.demo.api.payload.AuthPayload;

/**
 * @descripion `PageObjectManager`: A manager class in automated testing, streamlining the creation and access of page objects for enhanced code organization and maintainability.
 */
public class PageObjectManager {


	private AuthPayload authPayload;

	public AuthPayload getAuthPayload() {
		return (authPayload == null) ? authPayload = new AuthPayload() : authPayload;
	}
	
}
