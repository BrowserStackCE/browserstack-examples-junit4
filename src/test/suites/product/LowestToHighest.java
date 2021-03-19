package product;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonSteps;
import utils.DriverFactory;
import utils.MarkTest;

public class LowestToHighest extends DriverFactory {

	public String initialurl = "https://bstackdemo.com/";

	public String LocatorOrderButton = "#__next > div > div > main > div.shelf-container > div.shelf-container-header > div.sort > select";

	public String LocatorLowesttoHighest = "#__next > div > div > main > div.shelf-container > div.shelf-container-header > div.sort > select > option:nth-child(2)";

	@Test

	public void main() {
		// TODO Auto-generated method stub

		// driver.get(initialurl);

		WebElement order = driver.findElement(By.cssSelector(LocatorOrderButton));

		order.click();

		WebElement LowesttoHighest = driver.findElement(By.cssSelector(LocatorLowesttoHighest));

		LowesttoHighest.click();

		int productCount = CommonSteps.productCount(driver);
		
		System.out.println("Product Count is : "+productCount);
		
		int currentCost;
		
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		int lastCost = CommonSteps.findCostByIndex(driver, 0);
		
		int flag = 0;
		
		for (int i = 1; i < productCount; i++) {
			
            currentCost = CommonSteps.findCostByIndex(driver, i);
            
            System.out.println("CurrentCost :" +currentCost);
            
            System.out.println("LastCost :" +lastCost);
		
            if(currentCost < lastCost) {
            	
            	flag = 1;
            	
            }
            
            lastCost = currentCost;
            
		}
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
			
			MarkTest.LowestToHighest(driver, flag);
		
		}
		
		
	}
	 
	

}
