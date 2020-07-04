package com.company.projectappiume2e.features;

import com.company.projectappiume2e.base.BaseTest;
import com.company.projectappiume2e.pages.AndroidCalculatorPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AndroidEmulatorNativeUITest extends BaseTest {

    private AndroidCalculatorPage androidCalculatorPage;

    @Test
    public void testCalculatorPlusTwoNumbersNexus6API30() {

        configCapabilitiesNexus6API30();

        androidCalculatorPage = new AndroidCalculatorPage(driver);

        androidCalculatorPage.calculate("9990", "457", "PLUS");

        assertEquals("10447", androidCalculatorPage.getResult());
    }

    @Test
    public void testCalculatorSubtractionTwoNumbersNexus6API30() {

        configCapabilitiesNexus6API30();

        androidCalculatorPage = new AndroidCalculatorPage(driver);

        androidCalculatorPage.calculate("1570", "750", "SUBTRACTION");

        assertEquals("820", androidCalculatorPage.getResult());
    }

    @Test
    public void testCalculatorMultiplicationTwoNumbersNexus6API30() {

        configCapabilitiesNexus6API30();

        androidCalculatorPage = new AndroidCalculatorPage(driver);

        androidCalculatorPage.calculate("2500", "5", "MULTIPLICATION");

        assertEquals("12500", androidCalculatorPage.getResult());
    }

    @Test
    public void testCalculatorDivisionTwoNumbersNexus6API30() {

        configCapabilitiesNexus6API30();

        androidCalculatorPage = new AndroidCalculatorPage(driver);

        androidCalculatorPage.calculate("120000", "16", "DIVISION");

        assertEquals("7500", androidCalculatorPage.getResult());
    }

    private void configCapabilitiesNexus6API30() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "11.0");
        cap.setCapability("deviceName", "Nexus6API30");
        cap.setCapability("newCommandTimeout", 180);
        cap.setCapability("appWaitDuration", 30000);
        cap.setCapability("avd", "Nexus6API30");
        cap.setCapability("avdArgs", "-port 5557");

        cap.setCapability("appPackage", "com.google.android.calculator");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("appWaitActivity", "com.android.calculator2.Calculator");

        configAppiumDriver(cap);
    }
}