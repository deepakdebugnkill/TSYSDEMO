package com.demo.ui.pagemanager;


import com.demo.ui.pages.LoginPage;

public class PageObjectManager {
	
	private LoginPage loginPage;

	
	public LoginPage getLoginPage() {
		return (loginPage==null) ? loginPage = new LoginPage() : loginPage;
		
	}
	

	
	

}
