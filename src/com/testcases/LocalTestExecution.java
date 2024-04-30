package com.testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocalTestExecution {

	public static RemoteWebDriver driver;
	
@Test
	
	//public static void main(String[] args) throws MalformedURLException {
		
public void OpenChromeBrowser() throws MalformedURLException
{
		WebDriverManager.chromedriver().setup();
		
		//Step 1 set up the URL for the Selenium Grid   ...
		
		String url = "http://10.0.0.3:4444";
		
		//Step 2 is to set up the chrome options for launching Chrome browser
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		//Step 3 - Create a Map interface and define the build and name of the test
		
	/*	Map<String,Object> cloudOption = new HashMap();
		
		cloudOption.put("build", "Smoke Test");
		cloudOption.put("name", "Chrome Smoke Test");
		
		options.setCapability("cloud-options", cloudOption);*/
		
		driver = new RemoteWebDriver(new URL(url), options);
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		String URL = driver.getCurrentUrl();
		String title = driver.getTitle();
		
		System.out.println(URL);
		System.out.println(title);
		
		driver.quit();
		
		
	}
	

}
