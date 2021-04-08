package com.browserstack.suites.user;

import com.browserstack.utils.DriverFactory;

public class ImageNotLoading extends DriverFactory {
//	@Test
//	//@Description("ImageNotLoading")
//	public void imageNotLoading() {
//		// TODO Auto-generated method stub
//
//		WebElement signin = driver.findElement(By.id(Constants.ImageNotLoadingLocatorSignIn));
//
//		signin.click();
//
//		WebElement username = driver.findElement(By.id(Constants.ImageNotLoadingLocatorUserNameField));
//
//		username.sendKeys(Constants.ImageNotLoadingUserName);
//
//		username.sendKeys(Keys.ENTER);
//
//		WebDriverWait wait = new WebDriverWait(driver, 5);
//
//		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Constants.ImageNotLoadingLocatorPassword)));
//
//		password.sendKeys(Constants.ImageNotLoadingPassword);
//
//		password.sendKeys(Keys.ENTER);
//
//		WebElement Login = driver.findElement(By.id(Constants.ImageNotLoadingLocatorLogin));
//
//		Login.click();
//
//		Constants.ImageNotLoadingproductcount = CommonSteps.productCount(driver);
//
//		for(int i=1;i<=Constants.ImageNotLoadingproductcount;i++) {
//
//		WebElement image = driver.findElement(By.xpath("//*[@id=\"" +i+ "\"]/div[2]/img"));
//
//		Constants.src = image.getAttribute("src");
//
//			if(Constants.src.length() != 0) {
//
//				Constants.flag = 1;
//
//			}
//
//		}
//
//		MarkTest.MarkImageNotLoading(driver, Constants.flag);
//
//
//
//	}

}
