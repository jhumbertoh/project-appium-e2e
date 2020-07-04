package com.company.projectappiume2e.features;

import com.company.projectappiume2e.base.BaseTest;
import com.company.projectappiume2e.pages.RedmineHomePage;
import com.company.projectappiume2e.pages.RedmineLoginPage;
import com.company.projectappiume2e.util.Urls;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndroidRealDeviceRedmineLoginWebUITest extends BaseTest {

    private static RedmineLoginPage redmineLoginPage;

    @Test
    public void testLoginRedmineRealDeviceLGXMaxAndroid6(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "6.0.1");
        cap.setCapability("deviceName", "LG X max");
        cap.setCapability("udid", "LGK240IN9HSGHA");
        cap.setCapability("browserName", "Chrome");
        cap.setCapability("chromedriverExecutableDir", "/Users/jhumbertoh/Proyectos/Publicos/project-appium-e2e/resources/drivers/chrome/mac");

        cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        cap.setCapability("avdArgs", "-port 5557");

        configAppiumDriver(cap);

        driver.get(Urls.REDMINE_LOGIN);
        redmineLoginPage = new RedmineLoginPage(driver);
        RedmineHomePage redmineHomePage = redmineLoginPage.login("jhurtado", "passw0rd");

        redmineHomePage.clickOnMobileMenu();

        assertEquals("jhurtado", redmineHomePage.getUserLoggedMobileEmulation());
    }


}
