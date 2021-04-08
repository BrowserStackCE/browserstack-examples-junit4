package com.browserstack.utils;

public class ReadConfig {
//
//
//
//	public static DesiredCapabilities getCapabilities(DesiredCapabilities caps,String platformtemp) throws IOException, ParseException {
//
//
//		JSONParser jsonparser = new JSONParser();
//
//		FileReader reader = new FileReader("src/test/java/resources/test_caps.json");
//
//		Object obj;
//
//		obj = jsonparser.parse(reader);
//
//		JSONObject credentials = (JSONObject) obj;
//
//		//String Username = (String) credentials.get("user");
//
//		String Access_Key = (String) credentials.get("key");
//
//		String Application_Endpoint = (String) credentials.get("application_endpoint");
//
//		//System.out.println("Username Is:  "+Username);
//
//		System.out.println("AccessKey Is  "+ Access_Key);
//
//		System.out.println("Application Endpoint Is:" +Application_Endpoint);
//
//
//
//
//		if(platformtemp.equals("bstack-single")) {
//
//		JSONObject tests = (JSONObject)credentials.get("tests");
//
//		JSONObject single = (JSONObject) tests.get("single");
//
//		System.out.println("Single Is:" +single);
//
//		JSONArray array = (JSONArray) single.get("env_caps");
//
//		JSONObject config = (JSONObject) array.get(0);
//
//		System.out.println("Config is "+config);
//
//		String browser = (String) config.get("browser");
//
//		String os = (String) config.get("os");
//
//		String os_version = (String) config.get("os_version");
//
//		caps.setCapability("browser", browser);
//
//		System.out.println("Browser Is:" +browser);
//
//		caps.setCapability("os", os);
//
//		System.out.println("OS Is: " +os);
//
//		System.out.println("OS Version Is: " +os_version);
//
//		caps.setCapability("os_version", os_version);
//
//		caps.setCapability("resolution", "2048x1536");
//
//		JSONObject common_caps = (JSONObject) single.get("common_caps");
//
//		System.out.println(common_caps);
//
//
//		String bstack_single_Project = (String) common_caps.get("project");
//
//		String bstack_single_Build = (String) common_caps.get("build");
//
//		String bstack_single_Session = (String) common_caps.get("name");
//
//		caps.setCapability("project", bstack_single_Project);
//
//		caps.setCapability("build", bstack_single_Build);
//
//		caps.setCapability("name", bstack_single_Session);
//
//
//		}
//
//
//
//		if(platformtemp.equals("bstack-parallel")) {
//
//
//			JSONObject tests = (JSONObject)credentials.get("tests");
//
//			JSONObject single = (JSONObject) tests.get("single");
//
//			JSONArray array = (JSONArray) single.get("env_caps");
//
//			JSONObject config = (JSONObject) array.get(0);
//
//
//			String browser = (String) config.get("browser");
//
//			String os = (String) config.get("os");
//
//			String os_version = (String) config.get("os_version");
//
//			caps.setCapability("browser", browser);
//
//			caps.setCapability("os", os);
//
//			caps.setCapability("os_version", os_version);
//
//			caps.setCapability("resolution", "2048x1536");
//
//			JSONObject parallel = (JSONObject) tests.get("parallel");
//
//			JSONObject parallel_common_caps = (JSONObject) parallel.get("common_caps");
//
//			String bstack_parallel_Project = (String) parallel_common_caps.get("project");
//
//			String bstack_parallel_Build = (String) parallel_common_caps.get("build");
//
//			String bstack_parallel_Session = (String) parallel_common_caps.get("name");
//
//			caps.setCapability("project", bstack_parallel_Project);
//
//			caps.setCapability("build", bstack_parallel_Build);
//
//			caps.setCapability("name", bstack_parallel_Session);
//
//			String debug = (String) parallel_common_caps.get("browserstack_debug");
//
//			String networklogs = (String) parallel_common_caps.get("browserstack.networkLogs");
//
//			String console = (String) parallel_common_caps.get("browserstack.console");
//
//			caps.setCapability("browserstack.debug", debug);
//
//			caps.setCapability("browserstack.networkLogs", networklogs);
//
//			caps.setCapability("browserstack.console", console);
//
//
//		}
//
//
//		if(platformtemp.equals("bstack-local") || platformtemp.equals("bstack-local-parallel")) {
//
//
//			JSONObject tests = (JSONObject)credentials.get("tests");
//
//			JSONObject single = (JSONObject) tests.get("single");
//
//			JSONArray array = (JSONArray) single.get("env_caps");
//
//			JSONObject config = (JSONObject) array.get(0);
//
//
//			String browser = (String) config.get("browser");
//
//			String os = (String) config.get("os");
//
//			String os_version = (String) config.get("os_version");
//
//			System.out.println("Browser Is "+browser);
//
//			System.out.println("OS Is "+os);
//
//			System.out.println("OS Version Is: "+os_version);
//
//			caps.setCapability("browser", browser);
//
//			caps.setCapability("os", os);
//
//			caps.setCapability("os_version", os_version);
//
//			caps.setCapability("resolution", "2048x1536");
//
//			JSONObject local = (JSONObject) tests.get("local");
//
//			JSONObject local_common_caps = (JSONObject) local.get("common_caps");
//
//			System.out.println("Local Common Caps "+local_common_caps);
//
//			String bstack_local_Project = (String) local_common_caps.get("project");
//
//			String bstack_local_Build = (String) local_common_caps.get("build");
//
//			String bstack_local_Session = (String) local_common_caps.get("name");
//
//			String debug = (String) local_common_caps.get("browserstack_debug");
//
//			String networklogs = (String) local_common_caps.get("browserstack.networkLogs");
//
//			String console = (String) local_common_caps.get("browserstack.console");
//
//			caps.setCapability("project", bstack_local_Project);
//
//			caps.setCapability("build", bstack_local_Build);
//
//			caps.setCapability("name", bstack_local_Session);
//
//			caps.setCapability("browserstack.debug", debug);
//
//			caps.setCapability("browserstack.networkLogs", networklogs);
//
//			caps.setCapability("browserstack.console", console);
//
//
//		}
//
//		return caps;
//
//
//
//
//	//	System.out.println("OS Is" +(String) config.get("os"));
//
//	//	System.out.println("OS version Is" +(String) config.get("os_version"));
//
//
//
//
//	}
//
//
//
//	public static String ReadUserName() throws IOException, ParseException {
//
//		JSONParser jsonparser = new JSONParser();
//
//
//		Object obj;
//
//		obj = jsonparser.parse(reader);
//
//		JSONObject credentials = (JSONObject) obj;
//
//		String Username = (String) credentials.get("user");
//
//		return Username;
//
//	}
//
//	public static String ReadAccessKey() throws IOException, ParseException {
//
//
//		JSONParser jsonparser = new JSONParser();
//
//		FileReader reader = new FileReader("src/test/java/resources/test_caps.json");
//
//		Object obj;
//
//		obj = jsonparser.parse(reader);
//
//		JSONObject credentials = (JSONObject) obj;
//
//		String Access_Key = (String) credentials.get("key");
//
//		return Access_Key;
//
//
//	}
//
//
//
//	public static String GetEndPoint() throws IOException, ParseException {
//
//
//		JSONParser jsonparser = new JSONParser();
//
//		FileReader reader = new FileReader("src/test/java/resources/test_caps.json");
//
//		Object obj;
//
//		obj = jsonparser.parse(reader);
//
//		JSONObject credentials = (JSONObject) obj;
//
//		String Application_EndPoint = (String) credentials.get("application_endpoint");
//
//		return Application_EndPoint;
//
//
//	}
//
//
//	public static String GetLocalEndPoint() throws IOException, ParseException {
//
//		JSONParser jsonparser = new JSONParser();
//
//		FileReader reader = new FileReader("src/test/java/resources/test_caps.json");
//
//		Object obj;
//
//		obj = jsonparser.parse(reader);
//
//		JSONObject credentials = (JSONObject) obj;
//
//		JSONObject tests = (JSONObject)credentials.get("tests");
//
//		JSONObject local = (JSONObject) tests.get("local");
//
//		String Application_EndPoint = (String) local.get("application_endpoint");
//
//
//		return Application_EndPoint;
//
//	}
//
//
//
//
//
//	FileReader reader = new FileReader("src/test/java/resources/test_caps.json");


}
