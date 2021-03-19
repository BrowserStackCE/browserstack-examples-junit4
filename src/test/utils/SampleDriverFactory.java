package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SampleDriverFactory {

	public static WebDriver getDriver(String env, DesiredCapabilities capabilities) {

		switch (env) {
		case "on-premise":
			return new ChromeDriver();

		case "docker":
			return getDockerDriver(capabilities);

		default:
			return getBrowserStackDriver(capabilities);

		}

	}

	private static WebDriver getBrowserStackDriver(DesiredCapabilities capabilities) {
		

		// TODO Auto-generated method stub
		return null;
	}

	private static WebDriver getDockerDriver(DesiredCapabilities capabilities) {
		
		// TODO Auto-generated method stub
		return null;
	}

}
