package SRPDesignPattern.TravelAppExample.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractComponent {

    WebElement sectionElement;

    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.sectionElement = driver.findElement(sectionElement);
    }


    // With this method that will be inherited from all the component classes
    // We will perform that nested search by making our own find element method
    public WebElement findElement(By elementLocator) {
        return sectionElement.findElement(elementLocator);
    }
}
