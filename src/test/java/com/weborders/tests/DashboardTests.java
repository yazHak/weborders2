package com.weborders.tests;

import com.weborders.common.TestBase;
import com.weborders.pages.DashboardPage;
import com.weborders.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends TestBase {
    @Test
    public void verifyUsersNameOnDashboardMatches() {
        new LoginPage().login("Tester", "test");
        String usersNameOnDashBoard = new DashboardPage().getUsersNameFromDashboard();
        Assert.assertTrue(usersNameOnDashBoard.contains("Tester"));
    }

    @Test
    public void verifyUserCanLogut() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("Tester","test");
        new DashboardPage().logout();
        //boolean isLoginButtonDisplayed = loginPage.isLoginButtonDisplayed();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @Test
    public void verifyDeleteRowFunctionality() {
        new LoginPage().login("Tester", "test");
        DashboardPage dashboardPage = new DashboardPage();
        int initialNumberOfRows = dashboardPage.getNumberOfRowsOnTable();
        dashboardPage.deleteFirstRow();
        int finalNumberOfRows = dashboardPage.getNumberOfRowsOnTable();
        Assert.assertEquals(finalNumberOfRows, initialNumberOfRows-1);
    }
}
