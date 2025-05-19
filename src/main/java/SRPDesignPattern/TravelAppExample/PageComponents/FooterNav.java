package SRPDesignPattern.TravelAppExample.PageComponents;

import SRPDesignPattern.TravelAppExample.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterNav extends AbstractComponent {


    public WebDriver driver;
    By OptionFlights = By.cssSelector("[title='Flights']");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
        this.driver = driver;
    }

    // Uses the custom find element with nested search
    // inherit by the parent class to search for that element
    public void selectFlightsOption() {
        WebElement flightsOption = findElement(OptionFlights);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", flightsOption);
        System.out.println("Hi2");
    }
}
