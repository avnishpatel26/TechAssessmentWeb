package com.cucumbertest.stepdef;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumbertest.helper.Browser;
import com.cucumbertest.po.ContactUs;
import com.cucumbertest.po.HomePage;
import com.cucumbertest.po.InstantQuote;
import com.cucumbertest.po.LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class CommonStepDef extends Browser{

    public WebDriver driver = Browser.driver;

    LoginPage login = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    InstantQuote instantQuote = new InstantQuote(driver);
    ContactUs contactus = new ContactUs(driver);

    @Given("^User navigates to Login page$")
    public void given_user_navigates_to_login_page(){ 
        Assert.assertTrue(login.navigateToLoginPage());
    }

    @Given("^user enters username with \"([^\"]*)\"$")
    public void user_enters_username_with(String arg1) throws Exception {
    	Assert.assertTrue(login.enterEmail(arg1));
    }

    @Given("^user enters password with \"([^\"]*)\"$")
    public void user_enters_password_with(String arg1) throws Exception {
    	Assert.assertTrue(login.enterPassword(arg1));
    }

    @Given("^user clicks on Login button$")
    public void user_click_on_Login_button() throws Exception {
    	Assert.assertTrue(login.clickOnLogin());
    }

    @Given("^user should logged in successfully$")
    public void user_should_logged_in_successfully() throws Exception {
    	Assert.assertTrue(homePage.verifyLogoutButton());
    }
    
    @Given("^user should not be logged in and gets a validation message \"([^\"]*)\"$")
    public void user_should_not_logged_in_successfully(String arg1) throws Exception {
    	Assert.assertTrue(login.validateInvalidLoginMessage(arg1));
    }
    
    @Given("^user selects service as \"([^\"]*)\"$")
    public void user_selects_service_as(String arg1) throws Throwable {
        
        Assert.assertTrue(login.selectAService(arg1));
    }

    @Then("^user should be on Automobile Instant Quote Page$")
    public void user_should_be_on_Automobile_Instant_Quote_Page() throws Throwable {
    	Assert.assertTrue(instantQuote.verifyInstantQuoteLbl());
        
    }

    @Then("^user enters Zip Code as \"([^\"]*)\", E-mail as \"([^\"]*)\" and select Automobile Type as \"([^\"]*)\"$")
    public void user_enters_Zip_Code_as_E_mail_as_and_select_Automobile_Type_as(String arg1, String arg2, String arg3) throws Throwable {
    	Assert.assertTrue(instantQuote.enterZipCode(arg1));
    	Assert.assertTrue(instantQuote.enterEmail(arg2));
    	Assert.assertTrue(instantQuote.clickOnRadioBtn(arg3));    
    }

    @Then("^user clicks on Next button$")
    public void user_clicks_on_Next_button() throws Throwable {
        
    	Assert.assertTrue(instantQuote.clickOnNextBtn());
    }

    @Then("^user enters Age as \"([^\"]*)\", select Geneder as \"([^\"]*)\" and Driving Record as \"([^\"]*)\"$")
    public void user_enters_Age_as_select_Geneder_as_and_Driving_Record_as(String arg1, String arg2, String arg3) throws Throwable {
        
    	Assert.assertTrue(instantQuote.enterAge(arg1));
    	Assert.assertTrue(instantQuote.clickOnRadioBtn(arg2));
    	Assert.assertTrue(instantQuote.clickOnRadioBtn(arg3));
    }

    @Then("^user enters Year as \"([^\"]*)\", select Make as \"([^\"]*)\", Model as \"([^\"]*)\" and Financial Info as \"([^\"]*)\"$")
    public void user_enters_Year_as_select_Make_as_Model_as_and_Financial_Info_as(String arg1, String arg2, String arg3, String arg4) throws Throwable {
        
    	Assert.assertTrue(instantQuote.enterYear(arg1));
    	Assert.assertTrue(instantQuote.selectMake(arg2));
    	Assert.assertTrue(instantQuote.selectModel(arg3));
    	Assert.assertTrue(instantQuote.clickOnRadioBtn(arg4));
    }

    @Then("^quote should be created successfully$")
    public void quote_should_be_created_successfully() throws Throwable {
        
    	Assert.assertFalse(instantQuote.verifyErrorMessage());
    }
    
    @Given("^user clicks on Contact Us link$")
    public void user_clicks_on_Contact_Us_link() throws Throwable {
    	Assert.assertTrue(login.clickOnContactUS());
    }

    @Then("^user should be on contact us page$")
    public void user_should_be_on_contact_us_page() throws Throwable {
    	Assert.assertTrue(contactus.verifyContactUsLbl());
    }

    @Then("^user fills all the details$")
    public void user_fills_all_the_details(DataTable arg1) throws Throwable {
    	for(Map<String,String> data : arg1.asMaps(String.class,String.class)) { 
        
        	Assert.assertTrue(contactus.enterTitle(data.get("Title")));
        	Assert.assertTrue(contactus.enterFirstName(data.get("FirstName")));
        	Assert.assertTrue(contactus.enterLastName(data.get("LastName")));
        	Assert.assertTrue(contactus.enterAddress(data.get("Address")));
        	Assert.assertTrue(contactus.enterCity(data.get("City")));
        	Assert.assertTrue(contactus.enterState(data.get("State")));
        	Assert.assertTrue(contactus.enterZipCode(data.get("ZipCode")));
        	Assert.assertTrue(contactus.enterTelephone(data.get("Telephone")));
        	Assert.assertTrue(contactus.enterEmail(data.get("Email")));
        	Assert.assertTrue(contactus.enterComment(data.get("Comment")));
    	}
    }

    @Then("^user clicks on submit button$")
    public void user_clicks_on_submit_button() throws Throwable {
    	Assert.assertTrue(contactus.clickOnSubmit());
    }

    @Then("^user should be on Home Page$")
    public void user_should_be_on_Home_Page() throws Throwable {
    	Assert.assertTrue(login.verifyLoginButton());
    }

}
