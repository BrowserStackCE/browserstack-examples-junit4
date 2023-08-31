package com.browserstack.suites.user;

import com.browserstack.utils.BaseTest;
import com.browserstack.utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.Keys.ENTER;

public class ImageNotLoading extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageNotLoading.class);
    @Test
    public void imageNotLoading() throws Exception {
        /* =================== Prepare ================= */
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        /* =================== Execute ================= */
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("signin"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-2-input"))).sendKeys("image_not_loading_user", ENTER);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .id("react-select-3-input"))).sendKeys("testingisfun99", Keys.ENTER);
        webDriver.findElement(By
                       .id("login-btn")).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.urlContains("/?signin=true"));
        wait.until(waitWebDriver -> waitWebDriver.findElements(By.cssSelector(".spinner")).isEmpty());

        /* =================== Verify ================= */
        for(int i=1;i<=25;i++) {
            WebElement image = webDriver.findElement(By.xpath("//*[@id=\"" +i+ "\"]/div[2]/img"));
            Constants.src = image.getAttribute("src");
            if(Constants.src.length() != 0) {
                Constants.flag = 1;
            }
        }
        assertEquals(0, Constants.flag);

    }
}
