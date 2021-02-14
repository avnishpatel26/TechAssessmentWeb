package com.cucumbertest.helper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "src//test//resources//config//environment.properties";

    public ConfigFileReader(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("environment.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if(driverPath!= null) return driverPath;
        else throw new RuntimeException("Driver Path not specified in the environment.properties file for the Key:driverPath");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) {
            try{
                return Long.parseLong(implicitlyWait);
            }catch(NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("baseURL");
        if(url != null) return url;
        else throw new RuntimeException("Application Url not specified in the environment.properties file for the Key:url");
    }

    public String getBrowser() {
        String browserName = properties.getProperty("browser");
        if(browserName == null || browserName.equals("chrome")) return "chrome";
        else if(browserName.equalsIgnoreCase("firefox")) return "firefox";
        else if(browserName.equals("iexplorer")) return "ie";
        else throw new RuntimeException("Browser Name Key value in environment.properties is not matched : " + browserName);
    }

}
