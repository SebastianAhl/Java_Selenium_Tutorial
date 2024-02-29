package page_objects;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

// Page Object Encapsulation of the Flights Page


public class Page_Flights {
    String skyscannerurl = "https://www.skyscanner.com/flights?locale=en-US";
    
    // search input origin
    // id=originInput-input
    private By originBy = By.id("fsc-origin-search");

    // search input destination
    // id=destinationInput-input
    private By destinationBy = By.id("fsc-destination-search");

    // departure date input
    // css=.DateSearchControlsGroup_datesContainer__ZmEzY:nth-child(1) .SearchControlButton_value__NTAyZ
    private By departuredateBy = By.cssSelector(".DateSearchControlsGroup_datesContainer__ZmEzY:nth-child(1) .SearchControlButton_value__NTAyZ");

    // flexible dates
    // type="button" title="Flexible dates"
    // css=.BpkSelectableChip_bpk-chip--default-selected__MzE4Y > .BpkText_bpk-text__MjhhY > .BpkText_bpk-text__MjhhY
    private By flexibledatesBy = By.name("Flexible dates");

    // Depart April 2024
    // type="button" id="April-price"
    // css=.MonthSelectionItem_isSameMonthSelection__MWY0Y .BpkText_bpk-text--label-2__NzNlM
    // css=.MonthSelectionItem_isSameMonthSelection__MWY0Y > .MonthSelectionItem_monthYear__MGU4N > .BpkText_bpk-text--caption__ZTY0N
    private By aprilBy = By.id("April-price");

    // Return April 2024
    // css=.MonthSelectionItem_selected__ZjE5N .BpkText_bpk-text--label-2__NzNlM
    // css=.MonthSelectionItem_selected__ZjE5N > .MonthSelectionItem_monthYear__MGU4N > .BpkText_bpk-text--caption__ZTY0N

    // Search for flights, "Apply" Button
    // css=.DatePickerCTAContainer_searchButton__MTU3N
    private By applyBy = By.cssSelector(".DatePickerCTAContainer_searchButton__MTU3N");


    // Check if it is the right Website
    public void check_Page_Flights(WebDriver driver){
        // this.driver = driver;
        driver.get(skyscannerurl);

        if (!driver.getCurrentUrl().equals(skyscannerurl)) {
            throw new IllegalStateException("This is not Flights Page," +
                  " current page is: " + driver.getCurrentUrl());
        }
    }


    public void searchForFlights(WebDriver driver, String origin, String destination) {
        driver.findElement(originBy).click();
        driver.findElement(originBy).sendKeys(Keys.DELETE);
        driver.findElement(originBy).sendKeys(origin);
        driver.findElement(destinationBy).sendKeys(destination);
        // driver.findElement(flightsbuttonBy).click();

        // return new Page_SearchResults(driver, origin, destination);
    }
}
