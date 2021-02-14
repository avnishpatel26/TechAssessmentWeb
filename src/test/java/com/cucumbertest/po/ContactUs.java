package com.cucumbertest.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumbertest.helper.GenericFunctions;
import com.vimalselvam.cucumber.listener.Reporter;

public class ContactUs extends GenericFunctions {

	WebDriver driver;

	@FindBy(id="autoquote:f1")
	private WebElement titleText;
	
	@FindBy(id="autoquote:f2")
	private WebElement firstNameText;
	
	@FindBy(id="autoquote:f3")
	private WebElement LastNameText;
	
	@FindBy(id="autoquote:f5")
	private WebElement addressText;
	
	@FindBy(id="autoquote:f7")
	private WebElement cityText;
	
	@FindBy(id="autoquote:f8")
	private WebElement stateText;
	
	@FindBy(id="autoquote:f9")
	private WebElement zipCodeText;
	
	@FindBy(id="autoquote:f10")
	private WebElement telephoneText;
	
	@FindBy(id="autoquote:f11")
	private WebElement emailText;
	
	@FindBy(id="autoquote:f12")
	private WebElement commentText;
	
	@FindBy(id="autoquote:year")
	private WebElement yearText;
	
	@FindBy(id="makeCombo")
	private WebElement makeText;
	
	@FindBy(xpath="//img[contains(@src,'submit')]")
	private WebElement submitBtn;
	
	@FindBy(xpath="//div//h1[contains(text(),'Contact Us')]")
	private WebElement contactUsLbl;
	
	public ContactUs(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean enterTitle(String title) {
		if (enterText(driver, titleText, title, "title")) {
			Reporter.addStepLog("title entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterFirstName(String firstName) {
		if (enterText(driver, firstNameText, firstName, "firstName")) {
			Reporter.addStepLog("firstName entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterLastName(String lastName) {
		if (enterText(driver, LastNameText, lastName, "lastName")) {
			Reporter.addStepLog("lastName entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterAddress(String address) {
		if (enterText(driver, addressText, address, "address")) {
			Reporter.addStepLog("address entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterCity(String city) {
		if (enterText(driver, cityText, city, "city")) {
			Reporter.addStepLog("city entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterState(String state) {
		if (enterText(driver, stateText, state, "state")) {
			Reporter.addStepLog("state entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterZipCode(String zipCode) {
		if (enterText(driver,zipCodeText, zipCode, "zipCode")) {
			Reporter.addStepLog("zipCode entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterTelephone(String telephone) {
		if (enterText(driver, telephoneText, telephone, "telephone")) {
			Reporter.addStepLog("telephone entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterEmail(String email) {
		if (enterText(driver, emailText, email, "email")) {
			Reporter.addStepLog("email entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterComment(String comment) {
		if (enterText(driver, commentText, comment, "comment")) {
			Reporter.addStepLog("comment entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean clickOnSubmit() {
		if (click(driver, submitBtn, "Submit")) {
			Reporter.addStepLog("Clicked on Submit button successfully");
			return true;
		}
		return false;
	}
	
	public boolean verifyContactUsLbl()
    {
    	waitForPageLoaded(driver);
        if(verifyElementIsVisible(driver, contactUsLbl, "Contact US")) {
        	Reporter.addStepLog("Contact Us page opened successfully");
            return true;
        }
        return false;
    }
	
	
	
}
