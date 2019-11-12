package com.weborders.pages;

import com.weborders.common.Driver;
import com.weborders.common.PageBase;
import org.openqa.selenium.By;

public class DashboardPage extends PageBase {

    private By usersNameLocator = By.cssSelector(".login_info");
    private By logoutLinkLocator = By.linkText("Logout");
    private By firstCheckboxLocator = By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector");
    private By deleteButtonLocator = By.id("ctl00_MainContent_btnDelete");
    private By tableRowLocator = By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td/..");

    public String getUsersNameFromDashboard() {
        return Driver.getDriver().findElement(usersNameLocator).getText();
    }

    public void logout() {
        seleniumUtil.click(logoutLinkLocator);
    }

    public void checkFirstCheckbox() {
        seleniumUtil.click(firstCheckboxLocator);
    }

    public void clickDeleteButton() {
        seleniumUtil.click(deleteButtonLocator);
    }

    public int getNumberOfRowsOnTable() {
        return seleniumUtil.findElements(tableRowLocator).size();
    }

    public void deleteFirstRow() {
        checkFirstCheckbox();
        clickDeleteButton();
    }

    public void waitForPageToLoad() {
        seleniumUtil.waitForVisibility(logoutLinkLocator);
    }
}
