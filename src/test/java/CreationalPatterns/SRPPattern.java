package CreationalPatterns;

import SRPDesignPattern.TravelAppExample.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SRPPattern {
    @Test
    public void flightFooterTest(){
        WebDriver driver = new ChromeDriver();
        TravelHomePage TravelHomePage = new TravelHomePage(driver);
        TravelHomePage.goTo();
        TravelHomePage.getFooterNav().selectFlightsOption();
        driver.quit();
    }
}
