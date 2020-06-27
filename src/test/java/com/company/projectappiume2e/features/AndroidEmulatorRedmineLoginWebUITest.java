package com.company.projectappiume2e.features;

import com.company.projectappiume2e.base.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidEmulatorRedmineLoginWebUITest extends BaseTest {


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

    }

}
