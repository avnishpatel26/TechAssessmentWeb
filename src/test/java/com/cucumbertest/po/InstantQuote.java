package com.cucumbertest.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumbertest.helper.GenericFunctions;
import com.vimalselvam.cucumber.listener.Reporter;

public class InstantQuote extends GenericFunctions {

	WebDriver driver;

	@FindBy(id="autoquote:zipcode")
	private WebElement zipCodeText;
	
	@FindBy(id="autoquote:e-mail")
	private WebElement emailText;
	
	private String RadioBtn_startXpath = "//input[@value='";
	private String RadioBtn_endXpath = "']";
	
	@FindBy(id="autoquote:age")
	private WebElement ageText;
	
	@FindBy(id="autoquote:next")
	private WebElement NextBtn;
	
	@FindBy(id="autoquote:year")
	private WebElement yearText;
	
	@FindBy(id="makeCombo")
	private WebElement makeText;
	
	private String make_startXpath = "//div[@id='ext-gen8']//div[contains(text(),'";
	private String make_endXpath = "')]";
	
	private String model_startXpath = "//div[@id='ext-gen12']//div[contains(text(),'";
	private String model_endXpath = "')]";
	
	@FindBy(xpath="//span[@class='message-error']")
	private WebElement errorMessage;
	
	@FindBy(xpath="//div//h1[contains(text(),'Automobile Instant Quote')]")
	private WebElement automobileInstantQuoteLbl;
	
	@FindBy(id="modelCombo")
	private WebElement modelTxt;

	public InstantQuote(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean enterZipCode(String zipcode) {
		if (enterText(driver, zipCodeText, zipcode, "Zipcode")) {
			Reporter.addStepLog("zipcode entered successfully");
			return true;
		}
		return false;
	}

	public boolean enterEmail(String email) {
		if (enterText(driver, emailText, email, "Email")) {
			Reporter.addStepLog("Email entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterAge(String age) {
		if (enterText(driver, ageText, age, "Age")) {
			Reporter.addStepLog("Age entered successfully");
			return true;
		}
		return false;
	}
	
	public boolean enterYear(String year) {
		if (enterText(driver, yearText, year, "Year")) {
			Reporter.addStepLog("Year entered successfully");
			return true;
		}
		return false;
	}

	public boolean clickOnRadioBtn(String btnName) {
		WebElement radioBtn = driver.findElement(By.xpath(RadioBtn_startXpath + btnName + RadioBtn_endXpath));
		if (click(driver, radioBtn, "btnName")) {
			Reporter.addStepLog("Clicked on Radio button successfully");
			return true;
		}
		return false;
	}
	
	public boolean clickOnNextBtn() {
		if (click(driver, NextBtn, "Next")) {
			Reporter.addStepLog("Clicked on Next button successfully");
			return true;
		}
		return false;
	}
	
	public boolean verifyInstantQuoteLbl()
    {
    	waitForPageLoaded(driver);
        if(verifyElementIsVisible(driver, automobileInstantQuoteLbl, "Instant Quote")) {
        	Reporter.addStepLog("User is on Automobile Instant Quote page");
            return true;
        }
        return false;
    }
	
	public boolean selectMake(String make)
    {
    	waitForPageLoaded(driver);
    	if(!enterText(driver, makeText, make, "make"))
    		return false;
    	waitForPageLoaded(driver);
    	WebElement element = driver.findElement(By.xpath(make_startXpath + make + make_endXpath));
        if(click(driver, element, "make")) {
        	Reporter.addStepLog("User selected Make");
            return true;
        }
        return false;
    }
	
	public boolean selectModel(String model)
    {
    	waitForPageLoaded(driver);
    	if(!enterText(driver, modelTxt, model, "model"))
    		return false;
    	waitForPageLoaded(driver);
    	WebElement element = driver.findElement(By.xpath(model_startXpath + model + model_endXpath));
        if(click(driver, element, "model")) {
        	Reporter.addStepLog("User selected model");
            return true;
        }
        return false;
    }
	
	public boolean verifyErrorMessage()
    {
    	waitForPageLoaded(driver);
        if(verifyElementIsVisible(driver, errorMessage, "ErrorMessage")) {
        	Reporter.addStepLog("Error message is displayed: " + errorMessage.getText());
            return true;
        }
        return false;
    }
	
}
