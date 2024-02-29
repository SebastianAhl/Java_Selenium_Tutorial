// Test the flight search feature

package testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Flights;


public class TCSearchFlight {

    @Test
    public void tcSearchflight(){
        String origin = "Ho Chi Minh City";
        String destination = "Frankfurt am Main";
        String departure_month = "April";
        String returen_month = "April";
      
        WebDriver driver_edge = new EdgeDriver(); 

        Page_Flights search_flights = new Page_Flights();

        // go to URL and check if it is the right website
        search_flights.check_Page_Flights(driver_edge);

        // test the flight search
        search_flights.searchForFlights(driver_edge, origin, destination);

        // check the result

        driver_edge.quit();
    }
}


// @Test
// public void tcSearchflight(){
//     String skyscannerurl = "https://www.skyscanner.com/flights?locale=en-US";
//     String origin = "Ho Chi Minh City";
//     String destination = "Frankfurt am Main";
    
//     WebDriver driver = new EdgeDriver(); 

//     driver.get(skyscannerurl);
    

//     FlightsPage flightspage = new FlightsPage(driver);

//     flightspage.searchForFlights(origin, destination);

//     SearchResults searchResults = new SearchResults(driver, origin, destination);
//     // assertThat(searchResults.getMessageText(), is("Cheap flights from " + origin + " to " + destination + " at Skyscanner"));
//     assertEquals(searchResults.getMessageText(), "Cheap flights from " + origin + " to " + destination + " at Skyscanner");

//     driver.quit();
// }
