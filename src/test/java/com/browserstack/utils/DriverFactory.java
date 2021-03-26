 package com.browserstack.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.exec.util.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.browserstack.local.Local;

public class DriverFactory {

	// Need to remove static from here
	Local bsLocal = new Local();

	public WebDriver driver;

	//String url = "https://bstackdemo.com";

	//String localurl = "http://localhost:3000";
	
	private static final Semaphore BINARY_SEMAPHORE = new Semaphore(1);
	
	private static final Semaphore PARALLEL_SEMAPHORE = new Semaphore(5);

	public static int l = 0;
	
	public static String platformtemp = System.getProperty("profileId");

	List<WebDriver> list = new ArrayList<WebDriver>();

	final String ChromeDriverPath = "/Users/bhagyesh/Downloads/chromedriver";

	// Undo if code Does not work,set this method as
	// @Before
	// Need to name this method as Driver Factory from main
	@Before
	public void main2() throws Exception {

		//final String AUTOMATE_USERNAME = "bhagyeshnanwani4";
		
		final String AUTOMATE_USERNAME = ReadConfig.ReadUserName();
	
		final String AUTOMATE_ACCESS_KEY = ReadConfig.ReadAccessKey();
		
		final String url = ReadConfig.GetEndPoint();
		
		final String localurl = ReadConfig.GetLocalEndPoint();

		//final String AUTOMATE_ACCESS_KEY = "bQc9V5scoYwsAqxRnUvc";

		final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
				+ "@hub-cloud.browserstack.com/wd/hub";

		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader("src/test/java/resources/runners.json");

		Object obj;

		obj = jsonparser.parse(reader);

		JSONObject platformjsonobj = (JSONObject) obj;

		//Being Read From Profile
		String platformtemp = System.getProperty("profileId");
		
		//Running Code For on-prem Starts here
		
			if(platformtemp.equals("on-prem")) {
				
			driver = CreateChromeDriver();
			
			}
		
		//}
		
		//Running Code for on-prem Ends here
		
		
		//Running Code For On-Prem Suite Starts Here
			
			if(platformtemp.equals("on-prem-suite"))
				
			{
				
				BINARY_SEMAPHORE.acquire();
				
				driver = CreateChromeDriver();
				
			}
			
			
			
			
			
			
			
			
			
		//Running Code For Docker Starts Here

		//if (platform.equals("docker")) {
			
		if(platformtemp.equals("docker")) {

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setBrowserName(BrowserType.CHROME);

			driver = new RemoteWebDriver(new URL("http://localhost:4545/wd/hub"), caps);

			System.out.println("On-Docker Chrome Driver Created");

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(url);

		}
		
		//Running Code For Docker Ends Here

		// Running Code For Browserstack Starts Here

		//if (platform.equals("browserstack") && run.equals("sequential"))
		if(platformtemp.equals("bstack-single"))
		{
			//Experimental
			
			DesiredCapabilities caps = new DesiredCapabilities();
			
			caps = ReadConfig.getCapabilities(caps, platformtemp);
			
			//
			
			
			/*Working
			JSONArray array = (JSONArray) platformjsonobj.get("browserstacksequential");

			JSONObject browsersstacksequential = (JSONObject) array.get(0);
			
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("browser", (String) browsersstacksequential.get("browser"));

			caps.setCapability("browser_version", (String) browsersstacksequential.get("browser_version"));

			caps.setCapability("os", (String) browsersstacksequential.get("os"));

			caps.setCapability("os_version", (String) browsersstacksequential.get("os_version"));
			
			caps.setCapability("resolution", "2048x1536");
			*/

			driver = new RemoteWebDriver(new URL(URL), caps);

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(url);

			System.out.println("On-Prem Remote Driver Created");

		}
		
		//Running Code For BrowserStack Ends Here
		
		
		//Running Code For BrowserStack 
		
		
		if(platformtemp.equals("bstack-parallel"))
		{

			PARALLEL_SEMAPHORE.acquire();
			
			DesiredCapabilities caps = new DesiredCapabilities();
			
			caps = ReadConfig.getCapabilities(caps, platformtemp);
			
			//caps.setCapability("build", "bstack-parallel");
			
			/*
			JSONArray array = (JSONArray) platformjsonobj.get("browserstacksequential");

			JSONObject browsersstacksequential = (JSONObject) array.get(0);

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("browser", (String) browsersstacksequential.get("browser"));

			caps.setCapability("browser_version", (String) browsersstacksequential.get("browser_version"));

			caps.setCapability("os", (String) browsersstacksequential.get("os"));

			caps.setCapability("os_version", (String) browsersstacksequential.get("os_version"));
			
			caps.setCapability("resolution", "2048x1536");
			
			caps.setCapability("build", "bstack-parallel");
			*/

			driver = new RemoteWebDriver(new URL(URL), caps);

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(url);

			System.out.println("On-Prem Remote Driver Created");

		}
		
		
		
		
		
		
		
		
		
		
		
		
		//Running Code For BrowserStack Local Starts here
		
		
		if(platformtemp.equals("bstack-local"))
		{

			DesiredCapabilities caps = new DesiredCapabilities();
			
			caps = ReadConfig.getCapabilities(caps, platformtemp);
			
			
			/*
			JSONArray array = (JSONArray) platformjsonobj.get("browserstacksequential");

			JSONObject browsersstacksequential = (JSONObject) array.get(0);

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("browser", (String) browsersstacksequential.get("browser"));

			caps.setCapability("browser_version", (String) browsersstacksequential.get("browser_version"));

			caps.setCapability("os", (String) browsersstacksequential.get("os"));

			caps.setCapability("os_version", (String) browsersstacksequential.get("os_version"));
			
			*/

			caps.setCapability("browserstack.local", "true");
			
			caps.setCapability("browserstack.idleTimeout", "300");

			Local bsLocal = new Local();
			
			HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
			
			bsLocalArgs.put("key", AUTOMATE_ACCESS_KEY);

			//bsLocalArgs.put("key", "bQc9V5scoYwsAqxRnUvc");

			bsLocal.start(bsLocalArgs);

			driver = new RemoteWebDriver(new URL(URL), caps);

			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(localurl);

			System.out.println("On-Prem Remote Driver Created");

		}
		
		//Running Code For BrowserStack Local Ends Here
		
		
		if(platformtemp.equals("bstack-local-parallel")) {
			
			PARALLEL_SEMAPHORE.acquire();
			
			DesiredCapabilities caps = new DesiredCapabilities();
			
			caps = ReadConfig.getCapabilities(caps, platformtemp);
			
			/*
			
			caps.setCapability("build", "bstack-local-parallel");
			
			JSONArray array = (JSONArray) platformjsonobj.get("browserstacksequential");

			JSONObject browsersstacksequential = (JSONObject) array.get(0);

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("browser", (String) browsersstacksequential.get("browser"));

			caps.setCapability("browser_version", (String) browsersstacksequential.get("browser_version"));

			caps.setCapability("os", (String) browsersstacksequential.get("os"));

			caps.setCapability("os_version", (String) browsersstacksequential.get("os_version"));
			
			caps.setCapability("resolution", "2048x1536");
			
			*/

			caps.setCapability("browserstack.local", "true");
			
			caps.setCapability("browserstack.idleTimeout", "300");
			
			Random rand = new Random();
			
			int rand_int1 = rand.nextInt(100000);
			
			String str1 = Integer.toString(rand_int1);
			
			System.out.println("Unique String Is:"+str1);
			
			Local bsLocal = new Local();
			
			HashMap<String, String> bsLocalArgs = new HashMap<String, String>();
			
			bsLocalArgs.put("key", AUTOMATE_ACCESS_KEY);

			//bsLocalArgs.put("key", "bQc9V5scoYwsAqxRnUvc");
			
			bsLocalArgs.put("localIdentifier", str1);

			bsLocal.start(bsLocalArgs);
			
			caps.setCapability("browserstack.localIdentifier", str1);

			driver = new RemoteWebDriver(new URL(URL), caps);

			driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(localurl);

			System.out.println("On-Prem Remote Driver Created");
			
			
		
		}
		
		
	}
		
		//Running Code For Browserstack Local Ends here
		
		
		
		
		
		
		
		
		

		

		

	// public void CreateChromeDriver() {

	public WebDriver CreateChromeDriver() throws IOException, ParseException {
		
		final String url = ReadConfig.GetEndPoint();

		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("On-Prem Chrome Driver Created");

		driver.manage().window().maximize();

		driver.get(url);

		return driver;

	}

	
	

	@After
	public synchronized void StopTest() throws Exception {

		if (platformtemp.contains("local")) {
				
				bsLocal.stop();
				driver.quit();
				
			}
		
		if(platformtemp.equals("on-prem-suite"))
			
		{
			driver.quit();
			BINARY_SEMAPHORE.release();
			
		}
		
		if(platformtemp.equals("bstack-parallel"))
		{
			driver.quit();
			PARALLEL_SEMAPHORE.release();
		}
		
		if(platformtemp.equals("bstack-local-parallel")) {
			
			PARALLEL_SEMAPHORE.release();
		}
		
		
		else {
		driver.quit();
		}
	}

}

