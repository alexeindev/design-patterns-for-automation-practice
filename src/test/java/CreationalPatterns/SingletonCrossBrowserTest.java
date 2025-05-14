package CreationalPatterns;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SingletonCrossBrowserTest {

    @BeforeMethod
    // Get the parameter from a data provider or testng.xml
    @Parameters("browser")
    public void setup(String browser) {
        WebDriverManager.setBrowser(browser);
    }
    @Test
    public void testLogin() {
        WebDriver driver = WebDriverManager.getDriver();
        driver.get("https://example.com");
    }

    @AfterMethod
    public void teardown() {
        WebDriverManager.quitDriver();
    }


}
