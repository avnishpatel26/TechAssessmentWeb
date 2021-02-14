package com.cucumbertest.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumbertest.helper.GenericFunctions;
import com.vimalselvam.cucumber.listener.Reporter;

public class HomePage extends GenericFunctions {

    WebDriver driver;

    @FindBy(id="logout-form:logout")
    private WebElement logOutBtn;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLogoutButton()
    {
    	waitForPageLoaded(driver);
        if(verifyElementIsVisible(driver, logOutBtn, "Log out")) {
        	Reporter.addStepLog("User logged in to Application successfully");
            return true;
        }
        return false;
    }
}
