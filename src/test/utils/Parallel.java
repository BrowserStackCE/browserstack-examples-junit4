package utils;

import org.openqa.selenium.WebDriver;

import product.LowestToHighest;

public class Parallel extends Thread {
	int i = 0;

	@Override
	public void run() {

		DriverFactory d = new DriverFactory();

		for (int k = 0; k < d.list.size(); k++) {
			System.out.println(d.list.get(k));

		}

		long threadId = Thread.currentThread().getId();

		System.out.print("Thread ID " + threadId);

		try {

			LowestToHighest t1 = new LowestToHighest();

			WebDriver driver = d.list.get(i);

			// t1.test(driver);

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		System.out.print("Value of i is : " + i);

	}

}
