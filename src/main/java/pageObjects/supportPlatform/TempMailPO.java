package pageObjects.supportPlatform;

import PageUIs.supportPlatform.TempMailPUI;
import commons.BaseAction;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.adminSite.LoginPO;
import pageObjects.adminSite.UserPO;

public class TempMailPO extends BaseAction {
    private WebDriver driver;

    public TempMailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getCurrentPageTitle() {
        return getPageTitle(driver);
    }

    public void waitForLoadingIconInvisible() {
        waitForElementInvisible(driver, TempMailPUI.LOADING_MAIL_ICON);
    }

    public String getGeneratedMailAddress() {
        waitForElementVisible(driver, TempMailPUI.GENERATED_EMAIL_ADDRESS);
        return getDefaultAttributeValue(driver, TempMailPUI.GENERATED_EMAIL_ADDRESS, "value");
    }

    public UserPO switchToCmsAdminPage(String siteTitle) {
        switchToWindowByTitle(driver, siteTitle);
        return PageGeneratorManager.getUserPage(driver);
    }

    public void openLatestMail() {
        waitForElementClickable(driver, TempMailPUI.LATEST_MAIL);
        clickToElement(driver, TempMailPUI.LATEST_MAIL);
    }

    public String getPasswordInfo() {
        waitForElementVisible(driver, TempMailPUI.PASSWORD_INFO);
        return getElementText(driver, TempMailPUI.PASSWORD_INFO);
    }

    public LoginPO switchToCmsLoginPage(String cmsTitle) {
        switchToWindowByTitle(driver, cmsTitle);
        return PageGeneratorManager.getLoginPage(driver);
    }
}
