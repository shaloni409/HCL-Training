package Hackthon.com.Myntra.utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}