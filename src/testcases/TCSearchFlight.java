// Test the flight search feature

package testcases;

import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.FlightsPage;
import page_objects.SearchResults;


public class TCSearchFlight {
    // protected WebDriver driver;

    @Test
    public void tcSearchflight(){
        String origin = "Hanoi";
        String destination = "Frankfurt am Main";
        
        WebDriver driver = new EdgeDriver(); 
        driver.get("https://www.skyscanner.com.vn/flights");

        FlightsPage flightspage = new FlightsPage(driver);

        flightspage.searchForFlights(origin, destination);

        SearchResults searchResults = new SearchResults(driver, origin, destination);
        // assertThat(searchResults.getMessageText(), is("Cheap flights from " + origin + " to " + destination + " at Skyscanner"));
        assertEquals(searchResults.getMessageText(), "Cheap flights from " + origin + " to " + destination + " at Skyscanner");
    
        driver.quit();
    }
}
