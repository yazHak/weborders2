package com.weborders.tests;

import com.weborders.common.Driver;
import com.weborders.common.TestBase;
import com.weborders.pages.DashboardPage;
import com.weborders.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void verifyUserCanLoginWithCorrectCredentials() {

        String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx";
        new LoginPage().login("Tester", "test");
        new DashboardPage().waitForPageToLoad();
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), url);
    }

    @Test
    public void verifyUserWithIncorrectPasswordIsShownErrorMessage() {

        LoginPage loginPage = new LoginPage();
        loginPage.login("Tester","fsadfsadfsad");
        String errorMessageText = loginPage.getErrorMessageText();
        Assert.assertEquals(errorMessageText,"Invalid Login or Password.");
    }
}
