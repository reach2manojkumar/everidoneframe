package com.everi.Test;




import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import io.cucumber.java.Scenario;

public class ProjectGlobalVariables {
	public static Properties loyaltyProperties = new Properties();
    public static Map<String, Properties> propertyFileMap = new HashMap<String, Properties>();
    public static Connection sqlConnection;
    public static String refernce;
//    public static WiniumDriver winiumDriver;
//    public static WebDriver webDriver;
    public static Scenario scenario;
	
}
