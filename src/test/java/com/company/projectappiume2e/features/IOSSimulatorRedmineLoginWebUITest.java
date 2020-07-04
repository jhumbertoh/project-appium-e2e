package com.company.projectappiume2e.features;

import com.company.projectappiume2e.base.BaseTest;
import com.company.projectappiume2e.pages.RedmineHomePage;
import com.company.projectappiume2e.pages.RedmineLoginPage;
import com.company.projectappiume2e.util.Urls;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IOSSimulatorRedmineLoginWebUITest extends BaseTest {

    private static RedmineLoginPage redmineLoginPage;

    @Test
    public void testLoginRedmineSimulatorIphoneXS(){

        //Requisitos:
        //XCode ; ruby con gema cocoapods ; Tener configurado un simulator  y si quisiera ejecutar
        //en un dispositivo real debo tener una membresia para ios developer

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "XCuiTest");
        cap.setCapability("platformName", "IOS");
        cap.setCapability("platformVersion", "13.5");
        cap.setCapability("deviceName", "iPhone Xs");
        cap.setCapability("webkitDebugProxyPort", 27753);
        cap.setCapability("wdaLocalPort", 8101);
        cap.setCapability("noReset", true);
        cap.setCapability("userNewWDA", true);
        cap.setCapability("fullReset", false);
        cap.setCapability("startIWDP", true);
        cap.setCapability("newCommandTimeout", 180);

        cap.setCapability("app","");
        cap.setCapability("browserName", "Safari");

        configAppiumDriver(cap);

        driver.get(Urls.REDMINE_LOGIN);
        redmineLoginPage = new RedmineLoginPage(driver);
        RedmineHomePage redmineHomePage = redmineLoginPage.login("jhurtado", "passw0rd");

        redmineHomePage.clickOnMobileMenu();

        assertEquals("jhurtado", redmineHomePage.getUserLoggedMobileEmulation());
    }
}
