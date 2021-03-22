package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReadConfig {

	public static String AUTOMATE_USERNAME;
	
	public static String AUTOMATE_ACCESS_KEY;
	
	public static String Application_EndPoint;
	
	public static String browser;
	
	public static String os;
	
	public static String os_version;
	
	

	
	
	
	public static void Credentials() throws IOException, ParseException{
		
		
		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader("./resources/conf/runners/test_caps.json");

		Object obj;

		obj = jsonparser.parse(reader);

		JSONObject credentials = (JSONObject) obj;

	    AUTOMATE_USERNAME = (String) credentials.get("user");

	    AUTOMATE_ACCESS_KEY = (String) credentials.get("key");
		
	   Application_EndPoint = (String) credentials.get("application_endpoint");
	   
	   String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
				+ "@hub-cloud.browserstack.com/wd/hub";
		
		
	}
	
	
	public static String singlegetBrowser(WebDriver driver) throws IOException, ParseException {
		
		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader("./resources/conf/runners/test_caps.json");

		Object obj;

		obj = jsonparser.parse(reader);
		
		JSONObject credentials = (JSONObject) obj;
		
		JSONObject tests = (JSONObject)credentials.get("tests");
		
		JSONObject single = (JSONObject) tests.get("single");
		
		System.out.println("Single Is:" +single);
		
		JSONArray array = (JSONArray) single.get("env_caps");
		
		JSONObject config = (JSONObject) array.get(0);
		
		System.out.println("Config is "+config);
		
		String browser = (String) config.get("browser");
		
		System.out.println("Browser Is "+browser);
	
		
		String os = (String) config.get("os");
		
		System.out.println("OS Is" +os);
		
		String os_version = (String) config.get("os_version");
		
		System.out.println("OS version Is :" +os_version);
		
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browser", browser);

		caps.setCapability("browser_version", "latest");

		caps.setCapability("os", os);

		caps.setCapability("os_version", os_version);
		
		caps.setCapability("resolution", "2048x1536");

		driver = new RemoteWebDriver(new URL(URL), caps);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get(url);
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
