package SRPDesignPattern.TravelAppExample.PageObjects;

import SRPDesignPattern.TravelAppExample.PageComponents.FooterNav;
import SRPDesignPattern.TravelAppExample.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {

    WebDriver driver;
    //The complete section locator (We will use it as our scope and the elements will only be searched there)
    //this is called NESTED SEARCH
    By sectionFooterNav = By.id("traveller-home");

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to get to the page
    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    //Encapsulates the responsibility of getting that component
    public NavigationBar getNavigationBar () {
        return new NavigationBar();
    }

    //Encapsulates the responsibility of getting that component
    // Passing the driver and the respective section
    public FooterNav getFooterNav () {
        return new FooterNav(driver, sectionFooterNav);
    }
}
