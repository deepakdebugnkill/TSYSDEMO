package com.demo.api.pojo;

/**
 * @description class represents authentication details, encapsulating data for api requests.
 */
public class AuthPojo{
    public String username;
    public String password;
    
    public AuthPojo(String username, String password) {
    	super();
    	this.username = username;
    	this.password = password;
    
    }
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
