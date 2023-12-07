package com.demo.ui.pages;

import com.demo.ui.common_utils.Baseclass;
import com.demo.ui.pagemanager.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends Baseclass {
	
	PageObjectManager pom = new PageObjectManager();
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Login')] ")
	private WebElement btnLogin;
	
	@FindBy(xpath ="//input[@placeholder='User']")
	private WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath ="//span[text()='Submit']")
	private WebElement btnSubmit;
	
	@FindBy(xpath= "//div[contains(text(),'Demo user')] ")
	private WebElement txtValidUser;
	
	@FindBy(xpath="//div[contains(text(),'password are incorrect')]")
    private WebElement txtInvalidUser;
	
	public PageObjectManager getPom() {
		return pom;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}
	
	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	
	public WebElement getTxtValidUser() {
		return txtValidUser;
	}

	public WebElement getTxtInvalidUser() {
		return txtInvalidUser;
	}

	public void login() {
		clkElement(getBtnLogin());
	}

	public void loginCredentials(String username, String password) {
		
		txtinput(getUsername(), username);
		txtinput(getPassword(), password);
	}
	
	public void loginSubmit() {
		clkElement(getBtnSubmit());
	}
	
	public String successMessageValidUser() {
		String text = getText(getTxtValidUser());

		return text;
	}
	
	public String errorMessageInvalidUser() {
		String text = getText(getTxtInvalidUser());
		System.out.println(text);
		return text;
	}
	
}
