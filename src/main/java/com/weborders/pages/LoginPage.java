package com.weborders.pages;

import com.weborders.common.Driver;
import com.weborders.common.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {

    private String pageUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx";
    private By userNameLocator = By.id("ctl00_MainContent_username");
    private By passwordLocator = By.id("ctl00_MainContent_password");
    private By loginButtonLocator = By.id("ctl00_MainContent_login_button");
    private By statusTextLocator = By.xpath("//span[@id='ctl00_MainContent_status']");

    public void goToPage() {
        Driver.getDriver().get(pageUrl);
    }

    public void enterUserName(String userName) {
        //Driver.getDriver().findElement(userNameLocator).sendKeys(userName);
        seleniumUtil.sendKeys(userNameLocator,userName);
    }

    public void enterPassword(String password) {
        seleniumUtil.sendKeys(passwordLocator,password);
    }

    private void clickLoginButton() {
        seleniumUtil.click(loginButtonLocator);
    }

    public String getErrorMessageText() {
        return seleniumUtil.getText(statusTextLocator);
    }

    public void login(String userName, String password) {
        goToPage();
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean isLoginButtonDisplayed() {
        return seleniumUtil.isDisplayed(loginButtonLocator);
    }

    public void waitForPageToLoad() {

    }
}
