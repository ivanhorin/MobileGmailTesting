package com.epam.lab5.driver;

import com.epam.lab5.consts.Configs;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverHandler{
    private static AppiumDriver appiumDriver;

    public static WebElement waitToBeClickable(WebElement element) {
        return new WebDriverWait(appiumDriver, Configs.UNTIL_CLICKABLE_WAIT_TIME_VALUE).until(
                ExpectedConditions.elementToBeClickable(element));
    }

    public static void setUpDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Configs.MOB_PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, Configs.MOB_PLATFORM_VERSION);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, Configs.MOB_BROWSER_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Configs.MOB_DEVICE_NAME);
        URL url = new URL(Configs.APPIUM_HOST_URL);
        appiumDriver = new AppiumDriver(url, capabilities);
        appiumDriver.manage().timeouts().implicitlyWait(Configs.IMPLICITLY_WAIT_TIME_VALUE, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver( ) {
        if (appiumDriver == null) {
            try {
                setUpDriver();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return appiumDriver;
    }

    public static void quitDriver() {
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
    }
}
