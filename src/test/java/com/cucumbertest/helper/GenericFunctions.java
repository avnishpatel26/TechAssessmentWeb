package com.cucumbertest.helper;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vimalselvam.cucumber.listener.Reporter;

public class GenericFunctions extends ConfigFileReader {

    public boolean click(WebDriver driver, WebElement element, String elementName)
    {
        try
        {
        	waitForPageLoaded(driver);
            element.click();
            return true;
        }
        catch(Exception e)
        {
        	Reporter.addStepLog("Unable to click at element : " + elementName + " " + e.getMessage());
            return false;
        }
    }

    public boolean enterText(WebDriver driver, WebElement element, String text, String elementName)
    {
        try
        {
        	waitForPageLoaded(driver);
        	element.clear();
            element.sendKeys(text);
            return true;
        }
        catch(Exception e)
        {
        	Reporter.addStepLog("Unable to enter text in : " + elementName + " " + e.getMessage());
        	return false;
        }
        
    }

    public boolean verifyElementIsVisible(WebDriver driver, WebElement element, String elementName)
    {
        try
        {
        	waitForPageLoaded(driver);
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(element));
            if(element.isDisplayed()) {
                return true;
            }
        }
        catch(Exception e)
        {
            Reporter.addStepLog("Unable to verify presence of : " + elementName + " " + e.getMessage());
        }
        return false;
    }
    
    public static void waitForPageLoaded(WebDriver driver) 
	{
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>()
        {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
    
    public boolean selectValueByVisibleText(WebDriver driver,WebElement element, String value, String elementName)
    {
    	try
    	{
    		waitForPageLoaded(driver);
    		Select select = new Select(element);
    		select.selectByVisibleText(value);
    		return true;
    		
    	}
    	catch(Exception e)
    	{
    		Reporter.addStepLog("Unable to select value from dropdown: " + elementName + " "+ e.getMessage());
    	}
    	return false;
    }
    
    public boolean moveToElement(WebDriver driver, WebElement element, String elementName)
    {
    	try
    	{
    		Actions act = new Actions(driver);
    		act.moveToElement(element).perform();
    		return true;
    	}
    	catch(Exception e)
    	{
    		Reporter.addStepLog("Unable to move to Element: " + elementName + " " + e.getMessage());
    	}
    	return false;
    }
}
