package com.company.projectappiume2e.features;

import com.company.projectappiume2e.base.BaseTest;
import com.company.projectappiume2e.pages.RedmineHomePage;
import com.company.projectappiume2e.pages.RedmineLoginPage;
import com.company.projectappiume2e.util.Urls;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndroidEmulatorRedmineLoginWebUITest extends BaseTest {

    private static RedmineLoginPage redmineLoginPage;


    @Test
    public void testLoginRedmineEmulatorNexus5Android7(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("deviceName", "Nexus5Android7");
        cap.setCapability("browserName", "Chrome");
        cap.setCapability("chromedriverExecutableDir", "/Users/jhumbertoh/Proyectos/Publicos/project-appium-e2e/resources/drivers/chrome/mac");

        cap.setCapability("avd", "Nexus5Android7");
        cap.setCapability("avdArgs", "-port 5557");

        configAppiumDriver(cap);

        driver.get(Urls.REDMINE_LOGIN);
        redmineLoginPage = new RedmineLoginPage(driver);
        RedmineHomePage redmineHomePage = redmineLoginPage.login("jhurtado", "passw0rd");

        redmineHomePage.clickOnMobileMenu();

        assertEquals("jhurtado", redmineHomePage.getUserLoggedMobileEmulation());
    }

    @Test
    public void testLoginRedmineEmulatorNexus6API30(){

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11.0");
        cap.setCapability("deviceName", "Nexus6API30");
        cap.setCapability("browserName", "Chrome");
        cap.setCapability("chromedriverExecutableDir", "/Users/jhumbertoh/Proyectos/Publicos/project-appium-e2e/resources/drivers/chrome/mac");

        cap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        cap.setCapability("avd", "Nexus6API30");
        cap.setCapability("avdArgs", "-port 5557");

        configAppiumDriver(cap);

        driver.get(Urls.REDMINE_LOGIN);
        redmineLoginPage = new RedmineLoginPage(driver);
        RedmineHomePage redmineHomePage = redmineLoginPage.login("jhurtado", "passw0rd");

        redmineHomePage.clickOnMobileMenu();

        assertEquals("jhurtado", redmineHomePage.getUserLoggedMobileEmulation());
    }
}