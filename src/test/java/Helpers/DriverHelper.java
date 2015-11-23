package Helpers;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class DriverHelper {

    private static RemoteWebDriver driver;

    public synchronized static RemoteWebDriver getCurrentDriver() {
        if (driver != null) return driver;
        try {
            System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");

            driver = new RemoteWebDriver(new java.net.URL("http://localhost:4723/wd/hub"), DesiredCapabilities.android());

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            Runtime.getRuntime().addShutdownHook(
                    new Thread(new BrowserClose()));
        }
        return driver;
    }

    public static void close() {
        getCurrentDriver().quit();
        driver = null;
    }

    private static class BrowserClose implements Runnable {
        public void run() {
            close();
        }
    }
}
