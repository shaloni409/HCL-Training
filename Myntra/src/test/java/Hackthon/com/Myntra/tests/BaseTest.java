package Hackthon.com.Myntra.tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;
import org.testng.annotations.*;
import java.lang.reflect.Method;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Hackthon.com.Myntra.utils.ConfigReader;
import Hackthon.com.Myntra.utils.ExtentManager;
import Hackthon.com.Myntra.utils.DriverFactory;   // ⭐ Added

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    private static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    // ================== EXTENT SETUP ==================

    @BeforeSuite
    public void setupReport() {

        extent = ExtentManager.getInstance();
        logger.info("========== Test Suite Started ==========");
    }

    @AfterSuite
    public void tearDownReport() {

        extent.flush();
        logger.info("========== Test Suite Finished ==========");
    }

    // ================== DRIVER SETUP ==================

    @BeforeMethod
    public void setUp(Method method) {

        test = extent.createTest(method.getName());

        logger.info("Launching browser");

        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);

            // ⭐ DriverFactory me driver store
            DriverFactory.setDriver(driver);
        }

        int waitTime =
                Integer.parseInt(ConfigReader.get("implicitWait"));

        DriverFactory.getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(waitTime));

        DriverFactory.getDriver().manage().window().maximize();

        String url = ConfigReader.get("baseUrl");
        DriverFactory.getDriver().get(url);

        logger.info("Navigated to: " + url);
    }

    // ================== RESULT HANDLING ==================

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            logger.error("Test Failed: " + result.getName());
            test.fail(result.getThrowable());

            String screenshotPath =
                    captureScreenshot(result.getName());

            test.addScreenCaptureFromPath(screenshotPath);
        }

        if (result.getStatus() == ITestResult.SUCCESS) {

            logger.info("Test Passed: " + result.getName());
            test.pass("Test Passed");
        }

        if (DriverFactory.getDriver() != null) {

            logger.info("Browser closed");
            DriverFactory.removeDriver();   // ⭐ close driver
        }
    }

    // ================== SCREENSHOT METHOD ==================

    public String captureScreenshot(String testName) {

        TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = "target/screenshots/" + testName + ".png";
        File dest = new File(path);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}