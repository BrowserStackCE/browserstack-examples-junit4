 package utils;

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

public class DriverFactory extends BuildThreads {

	// Need to remove static from here
	Local bsLocal = new Local();

	public WebDriver driver;

	String url = "https://bstackdemo.com";

	String localurl = "http://localhost:3000";

	private static WebDriver onPremiseWebDriver;

	private static AtomicInteger onPremiseConnectionCount = new AtomicInteger(0);
	
	private static final Semaphore BINARY_SEMAPHORE = new Semaphore(1);
	
	private static AtomicInteger loc = new AtomicInteger(0);

	public static int l = 0;
	
	public static String platformtemp = System.getProperty("profileId");

	List<WebDriver> list = new ArrayList<WebDriver>();

	final String ChromeDriverPath = "/Users/bhagyesh/Downloads/chromedriver";

	// Undo if code Does not work,set this method as
	// @Before
	// Need to name this method as Driver Factory from main
	@Before
	public void main2() throws Exception {

		final String AUTOMATE_USERNAME = "UserName";

		final String AUTOMATE_ACCESS_KEY = "AccessKey";

		final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
				+ "@hub-cloud.browserstack.com/wd/hub";

		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader("./resources/conf/runners/runners.json");

		Object obj;

		obj = jsonparser.parse(reader);

		JSONObject platformjsonobj = (JSONObject) obj;

		String platform = (String) platformjsonobj.get("platform");

		String run = (String) platformjsonobj.get("run");
		
		//String platformtemp = System.getProperty("profileId");
		
		//Running Code For on-prem Starts here

		//if (platform.equals("onprem") && run.equals("sequential")) {
		
		
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
		if(platformtemp.equals("bstack-single") || platformtemp.equals("bstack-parallel"))
		{

			JSONArray array = (JSONArray) platformjsonobj.get("browserstacksequential");

			JSONObject browsersstacksequential = (JSONObject) array.get(0);

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("browser", (String) browsersstacksequential.get("browser"));

			caps.setCapability("browser_version", (String) browsersstacksequential.get("browser_version"));

			caps.setCapability("os", (String) browsersstacksequential.get("os"));

			caps.setCapability("os_version", (String) browsersstacksequential.get("os_version"));
			
			caps.setCapability("resolution", "2048x1536");

			String local = (String) browsersstacksequential.get("local");

			if (local.equals("true")) {

				caps.setCapability("browserstack.local", "true");

				Local bsLocal = new Local();

				HashMap<String, String> bsLocalArgs = new HashMap<String, String>();

				bsLocalArgs.put("key", AccessKey);

				bsLocal.start(bsLocalArgs);

				url = localurl;

			}

			driver = new RemoteWebDriver(new URL(URL), caps);

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(url);

			System.out.println("On-Prem Remote Driver Created");

		}
		
		//Running Code For BrowserStack Ends Here
		
		//Running Code For BrowserStack Local Starts here
		
		
		if(platformtemp.equals("bstack-local"))
		{

			JSONArray array = (JSONArray) platformjsonobj.get("browserstacksequential");

			JSONObject browsersstacksequential = (JSONObject) array.get(0);

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("browser", (String) browsersstacksequential.get("browser"));

			caps.setCapability("browser_version", (String) browsersstacksequential.get("browser_version"));

			caps.setCapability("os", (String) browsersstacksequential.get("os"));

			caps.setCapability("os_version", (String) browsersstacksequential.get("os_version"));

			caps.setCapability("browserstack.local", "true");
			
			caps.setCapability("resolution", "2048x1536");
			
			caps.setCapability("browserstack.idleTimeout", "300");

			Local bsLocal = new Local();
			
			HashMap<String, String> bsLocalArgs = new HashMap<String, String>();

			bsLocalArgs.put("key", AccessKey);

			bsLocal.start(bsLocalArgs);

			driver = new RemoteWebDriver(new URL(URL), caps);

			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(localurl);

			System.out.println("On-Prem Remote Driver Created");

		}
		
		//Running Code For BrowserStack Local Ends Here
		
		
		if(platformtemp.equals("bstack-local-parallel")) {
			
			JSONArray array = (JSONArray) platformjsonobj.get("browserstacksequential");

			JSONObject browsersstacksequential = (JSONObject) array.get(0);

			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability("browser", (String) browsersstacksequential.get("browser"));

			caps.setCapability("browser_version", (String) browsersstacksequential.get("browser_version"));

			caps.setCapability("os", (String) browsersstacksequential.get("os"));

			caps.setCapability("os_version", (String) browsersstacksequential.get("os_version"));

			caps.setCapability("browserstack.local", "true");
			
			caps.setCapability("resolution", "2048x1536");
			
			caps.setCapability("browserstack.idleTimeout", "300");
			
			Random rand = new Random();
			
			int rand_int1 = rand.nextInt(100000);
			
			String str1 = Integer.toString(rand_int1);
			
			System.out.println("Unique String Is:"+str1);
			
			Local bsLocal = new Local();
			
			HashMap<String, String> bsLocalArgs = new HashMap<String, String>();

			bsLocalArgs.put("key", AccessKey);
			
			bsLocalArgs.put("localIdentifier", str1);

			bsLocal.start(bsLocalArgs);
			
			caps.setCapability("browserstack.localIdentifier", str1);

			driver = new RemoteWebDriver(new URL(URL), caps);

			driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

			driver.manage().window().maximize();

			driver.get(localurl);

			System.out.println("On-Prem Remote Driver Created");
			
			
		}
		
		
		
		
		
		
		//Running Code For Browserstack Local Ends here
		
		
		
		
		
		
		
		
		

		// Under Construction

		if (platform.equals("onprem") && run.equals("parallel")) {

			JSONArray array = (JSONArray) platformjsonobj.get("environments");

			for (int i = 0; i < array.size(); i++) {

				JSONObject environments = (JSONObject) array.get(i);

				String parallelbrowser = (String) environments.get("browser");

				switch (parallelbrowser) {

				case "chrome":

					CreateChromeDriver();
					break;

				}

			}

		}

		else if (platform.equals("browserstack") && run.equals("parallel")) {

			JSONArray array = (JSONArray) platformjsonobj.get("browsers");

			for (int i = 0; i < array.size(); i++) {

				JSONObject browsers = (JSONObject) array.get(i);

				String local = (String) browsers.get("local");

				DesiredCapabilities caps = new DesiredCapabilities();

				if (local.equals("true")) {

				    Local bsLocal = new Local();

					HashMap<String, String> bsLocalArgs = new HashMap<String, String>();

					bsLocalArgs.put("key", AUTOMATE_ACCESS_KEY);

					bsLocal.start(bsLocalArgs);

					System.out.println(bsLocal.isRunning());

					caps.setCapability("browserstack.local", "true");

				}

				caps.setCapability("browser", (String) browsers.get("browser"));

				caps.setCapability("browser_version", (String) browsers.get("browser_version"));

				caps.setCapability("os", (String) browsers.get("os"));

				caps.setCapability("os_version", (String) browsers.get("os_version"));

				list.add(new RemoteWebDriver(new URL(URL), caps));

			}

			BuildThreads p = new BuildThreads();

			p.parallel(list);

		}

	}

	// public void CreateChromeDriver() {

	public WebDriver CreateChromeDriver() {

		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("On-Prem Chrome Driver Created");

		driver.manage().window().maximize();

		driver.get(url);

		return driver;

	}

	// Under Construction

	public void runOnPremise() {
		onPremiseConnectionCount.incrementAndGet();
		synchronized (DriverFactory.class) {
			if (onPremiseWebDriver == null) {
				onPremiseWebDriver = new ChromeDriver();
			}

			if (onPremiseConnectionCount.decrementAndGet() == 0) {
				onPremiseWebDriver.quit();
				onPremiseWebDriver = null;
			}
		}
	}

	// UnderConstruction

	public void CreateDriver() throws IOException, ParseException {

		// System.out.println(driver.getCurrentUrl());

		JSONParser jsonparser = new JSONParser();

		FileReader reader = new FileReader("./resources/conf/runners/runners.json");

		Object obj;

		obj = jsonparser.parse(reader);

		JSONObject platformjsonobj = (JSONObject) obj;

		String platform = (String) platformjsonobj.get("platform");

		String run = (String) platformjsonobj.get("run");

		if (platform.equals("onprem") && l == 1) {

			CreateChromeDriver();

			l++;

			System.out.println("Value of l is: " + l);

		}

		// System.out.println(driver.getCurrentUrl());

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
		
		else {
		driver.close();
		driver.quit();
		}
	}

}

