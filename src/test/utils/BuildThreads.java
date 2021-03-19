package utils;

import java.util.List;

import org.openqa.selenium.WebDriver;

public class BuildThreads {

	public void parallel(List<WebDriver> list) {

		// TODO Auto-generated method stub

		for (int j = 0; j < list.size(); j++) {

			Parallel p = new Parallel();

			p.start();

		}

		// TODO Auto-generated method stub

	}

}
