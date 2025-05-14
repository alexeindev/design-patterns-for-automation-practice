package CreationalPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverManager {

    // Gives an independent copy of this variable to each thread
    // This can help us with cross browser testing
    // E.g Thread 1 Can execute Firefox - Thread 2 Can execute Chrome
    private static final ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();
    // An independent browser name per thread
    private static final ThreadLocal<String> browserName = new ThreadLocal<>();

    //Create a private constructor
    private WebDriverManager() {
    }

    //Allows to set the browser name
    public static void setBrowser(String browser) {
        browserName.set(browser);
    }

    public static WebDriver getDriver() {
        //Gets the driver instance of the thread
        if (driverInstance.get() == null) {
            if (browserName.get() == null) {
                throw new IllegalStateException("Browser not set");
            }
            //Sets the instance for that thread once
            driverInstance.set(createDriver(browserName.get()));
        }
        return driverInstance.get();
    }

    private static WebDriver createDriver(String browserName) {
        //Sets a Driver depend on the browser name
        return switch (browserName.toLowerCase()) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "safari" -> new SafariDriver();
            default -> throw new IllegalArgumentException("Unsupported Browser: " + browserName);
        };
    }

    public static void quitDriver() {
        if (driverInstance.get() != null) {
            driverInstance.get().quit();
            //Remove the associated value of the driverInstance and browserName from the thread
            driverInstance.remove();
            browserName.remove();
        }
    }
}
