package com.cucumbertest.po;

import java.util.List;
import java.util.Random;

import org.json.simple.JSONObject;

import com.cucumbertest.helper.APIHelper;
import com.vimalselvam.cucumber.listener.Reporter;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class APIUtility extends APIHelper {

	private static Response response;
	private static ResponseBody responseBody;
	private static JsonPath jsonPath;
	private static String userid; 
	
	public void sendGetRequest(String Pagenumber)
	{
		response = getListOfUsersOnPage(Pagenumber);
	}
	
	public boolean verifyResponseCode(int Expectedresponse)
	{
		int statusCode = response.getStatusCode();
		if(statusCode == Expectedresponse)
		{
			Reporter.addStepLog("Status Code received : " + statusCode);
			return true;
		}
		Reporter.addStepLog("Actual Status Code :" + statusCode + " is not matched with expected Status code: " + statusCode);
		return false;
	}
	
	public boolean fetchListOfUserFromPage(int pageNumber)
	{
		jsonPath = response.jsonPath();
		int page = jsonPath.get("page");
		if(!(page == pageNumber)) {
			Reporter.addStepLog("Incorrect Page data is displayed : Actual Page : " + jsonPath.get("page") + " Expected Page: " + pageNumber);
			return false;
		}
		List<Object> map = jsonPath.getList("data");
		for(int i = 0; i <jsonPath.getList("data").size(); i++)
		{
			Reporter.addStepLog("User id on page are : " + jsonPath.getMap("data["+i+"]").get("id").toString());
		}
		return true;
	}
	
	public void setHeader(String headerName, String headerValue)
	{
		httpRequest.header(headerName, headerValue, null);
	}
	
	public boolean doSuccessfulPostRequest(String email, String password)
	{
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("email", email);
		if(password!=null) {
		jsonObj.put("password", password);}
		httpRequest.body(jsonObj.toJSONString());
		response = httpRequest.post("/api/register");
		return true;
	}
	
	public void deleteLastCreatedUser()
	{
		userid = response.jsonPath().getString("id");
		response = httpRequest.delete("/api/users/"+userid);
	}
	
	public boolean createUser(String name, String job)
	{
		Random rand = new Random();
		int x = rand.nextInt(10000);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", name+x);
		jsonObj.put("job", job);
		httpRequest.body(jsonObj.toJSONString());
		response = httpRequest.post("/api/users");
		return true;
	}

}
