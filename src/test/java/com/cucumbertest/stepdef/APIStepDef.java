package com.cucumbertest.stepdef;

import org.junit.Assert;

import com.cucumbertest.po.APIUtility;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class APIStepDef extends APIUtility{
	
	@When("^user set Rest API url$")
	public void user_set_Rest_API_url() throws Throwable {
	    setAPIURI();	    
	}

	@When("^send a GET HTTP Request to fetch list of users from page \"([^\"]*)\"$")
	public void send_a_GET_HTTP_Request_to_fetch_list_of_users_from_page(String arg1) throws Throwable {
		sendGetRequest(arg1);
	}

	@Then("^user receive HTTP response code (\\d+)$")
	public void user_receive_HTTP_response_code(int arg1) throws Throwable {
	    Assert.assertTrue(verifyResponseCode(arg1));
	    
	}

	@Then("^response should contains list of users from page (\\d+)$")
	public void response_should_contains_list_of_users_from_page(int arg1) throws Throwable {
	    Assert.assertTrue(fetchListOfUserFromPage(arg1));
	    
	}
	
	@When("^send a POST HTTP Request to register with email : \"([^\"]*)\" and password: \"([^\"]*)\"$")
	public void send_a_POST_HTTP_Request_with_email_and_password(String arg1, String arg2) throws Throwable {
		doSuccessfulPostRequest(arg1, arg2);
	}
	
	@When("^send a POST HTTP Request to register with email : \"([^\"]*)\"$")
	public void send_a_POST_HTTP_Request_with_email(String arg1) throws Throwable {
		doSuccessfulPostRequest(arg1, null);
	}
	
	@When("^user set Header param request  with \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_set_Header_param_request_with_as(String arg1, String arg2) throws Throwable {
		setHeader(arg1, arg2);
	}
	
	@Then("^user sends a DELETE HTTP Request to delete last created user$")
	public void user_sends_a_DELETE_HTTP_Request_to_delete_last_created_user() throws Throwable {
		deleteLastCreatedUser();
	}
	
	@When("^send a POST HTTP Request to create a user with name : \"([^\"]*)\" and job: \"([^\"]*)\"$")
	public void send_a_POST_HTTP_Request_to_create_a_user_with_name_and_job(String arg1, String arg2) throws Throwable {
		createUser(arg1, arg2);
	}


}
