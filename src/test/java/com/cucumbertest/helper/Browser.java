package com.cucumbertest.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser extends ConfigFileReader{

    public static WebDriver driver;

    public WebDriver getDriver(){
        if(driver == null) driver = createDriver();
        return driver;
    }

    public WebDriver createDriver() {
        switch (getBrowser()) {
            case "firefox" :
                System.setProperty(Constants.FIREFOX_DRIVER_PROPERTY,System.getProperty("user.dir")+"/src/test/resources/browsers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome" :
                System.setProperty(Constants.CHROME_DRIVER_PROPERTY, System.getProperty("user.dir")+"/src/test/resources/browsers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }
}
