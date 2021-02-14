package com.cucumbertest.helper;

import com.vimalselvam.cucumber.listener.Reporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIHelper {

	public static final String baseURI = "https://reqres.in/";
	public static RequestSpecification httpRequest;
	public static Response response;

	public void setAPIURI() {
			RestAssured.baseURI = baseURI;
			httpRequest = RestAssured.given();
	}

	public static Response getListOfUsersOnPage(String pageNumber) {

		try {
			httpRequest.header("Content-Type", "application/json");
			response = httpRequest.get("/api/users?page=" + pageNumber);
		} catch (Exception e) {
			Reporter.addStepLog("Unable to get list of users");
		}
		return response;
	}

}
