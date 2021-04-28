package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FavUserHomePage {

    WebDriver driver;
    public final static String OrderButtonLocator = "orders";

    public FavUserHomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        ClickOrderButton(wait);
    }

    @FindBy(id = OrderButtonLocator)
    static WebElement OrderButton;

    public void ClickOrderButton(WebDriverWait wait) {
        wait.until(ExpectedConditions.urlToBe("https://bstackdemo.com/"));
        OrderButton.click();
    }
}
