package com.cucumbertest.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumbertest.helper.GenericFunctions;
import com.vimalselvam.cucumber.listener.Reporter;

public class LoginPage extends GenericFunctions {

	WebDriver driver;

	@FindBy(id = "login-form:email")
	private WebElement emailTxtbox;

	@FindBy(id = "login-form:password")
	private WebElement passwordTxtbox;

	@FindBy(id = "login-form:login")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[@id='login-messages']//td")
	private WebElement invalidLoginMsg;
	
	@FindBy(id="quick-link:jump-menu")
	private WebElement serviceDrpdown;
	
	@FindBy(xpath="//a[contains(text(),'Contact Us')]")
	private WebElement contactUsLink;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean navigateToLoginPage() {
		driver.get(getApplicationUrl());
		if (verifyElementIsVisible(driver, emailTxtbox, "Email textbox")) {
			Reporter.addStepLog("navigate to Application successfully: ");
			return true;
		}
		return false;
	}

	public boolean enterEmail(String email) {
		if (enterText(driver, emailTxtbox, email, "Email")) {
			Reporter.addStepLog("email entered successfully");
			return true;
		}
		return false;
	}

	public boolean enterPassword(String password) {
		if (enterText(driver, passwordTxtbox, password, "Password")) {
			Reporter.addStepLog("password entered successfully");
			return true;
		}
		return false;
	}

	public boolean clickOnLogin() {
		if (click(driver, loginBtn, "Login")) {
			Reporter.addStepLog("Clicked on Login button successfully");
			return true;
		}
		return false;
	}
	
	public boolean validateInvalidLoginMessage(String message)
	{
		waitForPageLoaded(driver);
		if(invalidLoginMsg.getText().contains(message)) {
			Reporter.addStepLog("Validation message is displayed");
			return true;
		}
		Reporter.addStepLog("Validation message is not displayed");
		return false;
	}
	
	public boolean selectAService(String service)
	{
		if(selectValueByVisibleText(driver, serviceDrpdown, service, "Service")) {
			Reporter.addStepLog("Service is selected" );
			return true;
		}
		return false;
	}
	
	public boolean clickOnContactUS() {
		if(!moveToElement(driver, contactUsLink, "Contact US"))
			return false;
		if (click(driver, contactUsLink, "Contact US")) {
			Reporter.addStepLog("Clicked on Contact Us button successfully");
			return true;
		}
		return false;
	}
	
	public boolean verifyLoginButton()
    {
    	waitForPageLoaded(driver);
        if(verifyElementIsVisible(driver, loginBtn, "Log In")) {
        	Reporter.addStepLog("User is on Home Page");
            return true;
        }
        return false;
    }

}
