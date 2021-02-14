package com.cucumbertest.stepdef;

import com.cucumbertest.helper.Browser;

import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {
	
	@Before("@WebAutomation")
	public void beforeScenario()
	{
		//initialize Browser
		new Browser().createDriver();
	}
	
	@After("@WebAutomation")
    public void afterScenario(){
		new Browser().closeDriver();
	}
}
