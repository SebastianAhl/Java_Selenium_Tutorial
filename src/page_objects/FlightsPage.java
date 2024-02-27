package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Object Encapsulation of the Flights Page

public class FlightsPage {
    protected WebDriver driver;

    // search origin
    // input type="text" id=fsc-origin-search
    private By searchoriginBy = By.name("fsc-origin-search");

    // search destination
    // input type="text" id=fsc-destination-search
    private By searchdestinationBy = By.name("fsc-destination-search");

    // search flights button
    // button type="submit" id=fsc-destination-search
    private By flightsbuttonBy = By.cssSelector(".BpkButtonBase_bpk-button__M2VlO");


    public FlightsPage(WebDriver driver){
        this.driver = driver;
        if (!driver.getTitle().equals("Find the Best Flight Deals & Flight Booking Offers | Skyscanner")) {
            throw new IllegalStateException("This is not Flights Page," +
                  " current page is: " + driver.getCurrentUrl());
        }
    }


    public SearchResults searchForFlights(String origin, String destination) {
        driver.findElement(searchoriginBy).sendKeys(origin);
        driver.findElement(searchdestinationBy).sendKeys(destination);
        driver.findElement(flightsbuttonBy).click();

        return new SearchResults(driver, origin, destination);
    }
}
