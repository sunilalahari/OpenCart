package com.qa.opencart.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	
	WebDriver driver;
	ChromeOptions co;
	FirefoxOptions fo;
	EdgeOptions eo;
	Properties prop;
	//String browser;
	private static ThreadLocal<WebDriver> tlDriver= new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser) {
		
		/**
		 * Browser Name provided from properties files
		 */
		if(browser.equalsIgnoreCase("chrome")) {
			co= new ChromeOptions();
			//co.addArguments("--headless");
			co.addArguments("--incognito");
			//driver = new ChromeDriver(co);
			tlDriver.set(new ChromeDriver(co));
		}
		else if (browser.equalsIgnoreCase("edge")) {
			//driver = new EdgeDriver();
			tlDriver.set(new EdgeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			//driver = new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("safari")) {
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		}		
		return getDriver();
	}
	public static WebDriver getDriver() {
	
				return tlDriver.get();
			
		}
		
	
	
	public Properties initProperties() {
		prop = new Properties();
		String environemnt= System.getProperty("env");
		if(environemnt==null) {
			
		}
		else {
			switch(environemnt.toLowerCase().trim()) {
			
			case "qa":
				break;
			case "stage":
				break;
				
			case "prod":
				break;
			case "dev":
				break;
			default:
				break;
			
			}
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\properties\\prop.properties");
			try {
				prop.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return prop;
	}
	
	
	public static String getScreenshot() {
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File srcFile=	((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		File destFile= new File(path);
		
		System.out.println("File copying.................");
		try {
			FileHandler.copy(srcFile, destFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
	
}
