package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverHelper {

    private static WebDriver driver;

    public synchronized static WebDriver getCurrentDriver() {
        if (driver != null) return driver;
        try {
            System.setProperty("webdriver.chrome.driver", "ChromeDriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return driver;

        } finally {
            Runtime.getRuntime().addShutdownHook(
                    new Thread(new BrowserClose()));
        }
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
