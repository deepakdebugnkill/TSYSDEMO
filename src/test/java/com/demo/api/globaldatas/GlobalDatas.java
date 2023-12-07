package com.demo.api.globaldatas;

import java.util.List;

/**
 * @description The `GlobalData` class serves as a repository for storing reusable variables across projects, ensuring a centralized and easily accessible location for shared data.
 */
public class GlobalDatas {
	private int statusCode;
	private static List<Integer> bookings;
	private String token;
	private String newID;
	private String cookieValue;
	
	public int getStatusCode() {
		return statusCode;
	}
	public List<Integer> getBookings() {
		return bookings;
	}
	public String getToken() {
		return token;
	}
	public String getNewID() {
		return newID;
	}
	public String getCookieValue() {
		return cookieValue;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setBookings(List<Integer> bookingIDs) {
		this.bookings = bookingIDs;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setNewID(String newID) {
		this.newID = newID;
	}
	public void setCookieValue(String cookieValue) {
		this.cookieValue = cookieValue;
	}
	
	
}
