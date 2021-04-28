package com.browserstack.examples.tests;

import com.browserstack.utils.CommonSteps;
import com.browserstack.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import com.browserstack.pages.*;

import java.util.List;

import static org.junit.Assert.*;
import static org.openqa.selenium.Keys.ENTER;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Anirudha Khanna
 */
@RunWith(Parameterized.class)
public class FilterTests extends AbstractWebDriverTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FilterTests.class);

//    @Test
//    public void testSelectingAppleFilterDisplaysNoSamsungDevices() throws Exception {
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .cssSelector(".filters-available-size:nth-child(2) .checkmark"))).click();
//        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
//        List<WebElement> appleDeviceName = webDriver.findElements(By.cssSelector(".shelf-item__title"));
//
//        /* =================== Verify ================= */
//        long samsungDeviceCount = appleDeviceName.stream().filter(e -> e.getText().contains("Galaxy")).count();
//        assertEquals(0, samsungDeviceCount);
//    }
//
//
//    @Test
//    public void testSelectingSamsungFilterDisplaysNoAppleDevices() throws Exception {
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .cssSelector(".filters-available-size:nth-child(3) .checkmark"))).click();
//        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
//        List<WebElement> samsungDeviceName = webDriver.findElements(By.cssSelector(".shelf-item__title"));
//
//        /* =================== Verify ================= */
//        long appleDeviceCount = samsungDeviceName.stream().filter(e -> e.getText().contains("iPhone")).count();
//        assertEquals(0, appleDeviceCount);
//    }


//    @Test
//    public void imageNotLoading() throws Exception {
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("signin"))).click();
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-2-input"))).sendKeys("image_not_loading_user", ENTER);
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-3-input"))).sendKeys("testingisfun99", Keys.ENTER);
//       // WebElement loginButton
//        webDriver.findElement(By
//                       .id("login-btn")).sendKeys(Keys.RETURN);
//        wait.until(ExpectedConditions.urlToBe("https://bstackdemo.com/?signin=true"));
//        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
//
//        /* =================== Verify ================= */
//        for(int i=1;i<=25;i++) {
//            WebElement image = webDriver.findElement(By.xpath("//*[@id=\"" +i+ "\"]/div[2]/img"));
//            Constants.src = image.getAttribute("src");
//            if(Constants.src.length() != 0) {
//                Constants.flag = 1;
//            }
//        }
//        assertEquals(0, Constants.flag);
//    }

//
//
//    @Test
//    public void checkExistingOrders() throws Exception {
//
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("signin"))).click();
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-2-input"))).sendKeys("existing_orders_user", ENTER);
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-3-input"))).sendKeys("testingisfun99", Keys.ENTER);
//        webDriver.findElement(By.id("login-btn")).click();
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("orders"))).click();
//
//        /* =================== Verify ================= */
//        int ordercount = webDriver.findElements(By.className("a-box-group")).size();
//        assert ordercount <= 0 || (true);
//
//    }
//
//    @Test
//    public void ApplyingAppleAndSamsungFilters() throws Exception {
//
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        int initialProductCount = webDriver.findElements(By.className("shelf-item")).size();
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .cssSelector(".filters-available-size:nth-child(2) .checkmark"))).click();
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .cssSelector(".filters-available-size:nth-child(3) .checkmark"))).click();
//
//        /* =================== Verify ================= */
//        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
//        int finalProductCount = webDriver.findElements(By.className("shelf-item")).size();
//        assert initialProductCount == finalProductCount || (true);
//
//    }

//    @Test
//    public void lockedUserTest() throws Exception {
//
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 10);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//
//        /* =================== Execute ================= */
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("signin"))).click();
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-2-input"))).sendKeys("locked_user", ENTER);
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-3-input"))).sendKeys("testingisfun99\n");
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("login-btn"))).sendKeys(Keys.RETURN);
//
//
//
//        /* =================== Verify ================= */
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .className("api-error")));
//        boolean CheckIfDisplayed = webDriver.findElement(By.className("api-error")).isDisplayed();
//        assertTrue(CheckIfDisplayed == true);
//
//    }

//    @Test
//    public void checkFavourites() throws Exception {
//
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("signin"))).click();
//        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-2-input"))).sendKeys("existing_orders_user", ENTER);
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-3-input"))).sendKeys("testingisfun99", Keys.ENTER);
//        webDriver.findElement(By.id("login-btn")).click();
//        wait.until(ExpectedConditions.urlToBe("https://bstackdemo.com/?signin=true"));
//        for(int index=0;index<3;index++) {
//            webDriver.findElements(By.className(Constants.SelectFavouriteLocator)).get(index).click();
//        }
//
//        /* =================== Verify ================= */
//        webDriver.findElement(By.id("favourites")).click();
//        long favouriteCount = webDriver.findElements(By.className("shelf-item")).size();
//        assertTrue(favouriteCount>0);
//
//    }

//    @Test
//    public void lowestToHighest() throws Exception {
//
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .cssSelector("#__next > div > div > main > div.shelf-container > div.shelf-container-header > div.sort > select")))
//                            .click();
//        wait.until(ExpectedConditions.elementToBeClickable(By
//                .cssSelector("#__next > div > div > main > div.shelf-container > div.shelf-container-header > div.sort > select > option:nth-child(2)")))
//                    .click();
//        wait.until(waitWebDriver -> waitWebDriver.findElements(By.
//                cssSelector(".spinner"))
//                    .isEmpty());
//        int productCount = webDriver.findElements(By.className("shelf-item")).size();
//        int lastCost = CommonSteps.findCostByIndex(webDriver, 0);
//
//        /* =================== Verify ================= */
//        int currentCost,Flag=0;
//        for (int index = 1; index < productCount; index++) {
//            currentCost = CommonSteps.findCostByIndex(webDriver, index);
//            if (currentCost < lastCost) {
//                Flag = 1;
//            }
//            lastCost = currentCost;
//        }
//        assertTrue(Flag!=1);
//    }

//
//    @Test
//    public void navigateToLoginPage() throws Exception {
//
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        wait.until(ExpectedConditions.elementToBeClickable(By
//                .id("favourites"))).click();
//
//        /* =================== Verify ================= */
//        wait.until(ExpectedConditions.urlToBe(Constants.FavouriteEnforcesLoginTestassertUrl));
//        String CurrentUrl = webDriver.getCurrentUrl();
//        assertTrue(CurrentUrl.equals("https://bstackdemo.com/signin?favourites=true"));
//
//    }
//
//    @Test
//    public void checkOffers() throws Exception {
//
//        /* =================== Prepare ================= */
//        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
//        WebDriverWait wait = new WebDriverWait(webDriver, 5);
//        webDriver.get(webDriverConfiguration.getTestEndpoint());
//
//        /* =================== Execute ================= */
//        String locationScript = String.format(Constants.LOCATION_SCRIPT_FORMAT, Constants.OFFER_LATITUDE, Constants.OFFER_LONGITUDE);
//        ((JavascriptExecutor) webDriver).executeScript(locationScript);
//
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("signin"))).click();
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-2-input"))).sendKeys("fav_user", ENTER);
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("react-select-3-input"))).sendKeys("testingisfun99", Keys.ENTER);
//        webDriver.findElement(By.id("login-btn")).click();
//        wait.until(ExpectedConditions.urlToBe("https://bstackdemo.com/?signin=true"));
//        wait.until(ExpectedConditions
//                .visibilityOfElementLocated(By
//                        .id("offers"))).click();
//
//        /* =================== Verify ================= */
//        assertTrue(webDriver.getPageSource().contains("We've promotional offers in your location."));
//
//
//    }

    @Test
    public void endToEndTest() throws Exception {

        /* =================== Prepare ================= */
        WebDriver webDriver = this.webDriverProviderRule.getWebDriver(webDriverConfiguration, platform);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        webDriver.get(webDriverConfiguration.getTestEndpoint());

        /* =================== Execute ================= */
       HomePage homepage = new HomePage(webDriver, wait);
       Login login = new Login(webDriver);
       Bag bag = new Bag(webDriver, wait);
       Checkout checkout = new Checkout(webDriver, wait);
       Confirmation confirmation = new Confirmation(webDriver, wait);
       FavUserHomePage favUserHomePage = new FavUserHomePage(webDriver ,wait);

        /* =================== Verify ================= */
        wait.until(ExpectedConditions.urlToBe("https://bstackdemo.com/orders"));
        wait.until(ExpectedConditions
               .visibilityOfElementLocated(By
                       .className("item-view-left-col-inner")));
        int count = webDriver.findElements(By.className("item-view-left-col-inner")).size();
        System.out.println("<<<<<<<<<"+count+">>>>>>>>>");
        assertTrue(count == 3);

    }



}
