package user;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonSteps;
import utils.DriverFactory;
import utils.MarkTest;

public class ImageNotLoading extends DriverFactory {

	public String initialurl = "https://bstackdemo.com/";
	public String LocatorSignIn = "signin";
	public String LocatorUserNameField = "react-select-2-input";
	public String UserName = "image_not_loading_user";
	public String LocatorPassword = "react-select-3-input";
	public String Password = "testingisfun99";
	public String LocatorLogin = "login-btn";
	public String FailReason = "Image Loaded";
	public String PassReason = "Image Not Loading";
	

	@Test
	public void main() {
		// TODO Auto-generated method stub

		WebElement signin = driver.findElement(By.id(LocatorSignIn));

		signin.click();
		
		WebElement username = driver.findElement(By.id(LocatorUserNameField));

		username.sendKeys(UserName);

		username.sendKeys(Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(LocatorPassword)));

		password.sendKeys(Password);

		password.sendKeys(Keys.ENTER);

		WebElement Login = driver.findElement(By.id(LocatorLogin));

		Login.click();
		
		//abcd
		
		int flag=0;
		
		String src;
		
		int productcount = CommonSteps.productCount(driver);
		
		for(int i=1;i<=productcount;i++) {
		
		WebElement image = driver.findElement(By.xpath("//*[@id=\"" +i+ "\"]/div[2]/img"));
		
		src = image.getAttribute("src");
		
			if(src.length() != 0) {
			
				flag = 1;
		
			}
		}	
		
		if(CommonSteps.platformtemp.contains("bstack"))
		{
			
			MarkTest.MarkImageNotLoading(driver, flag);
		
		}
		
	
	}

}
