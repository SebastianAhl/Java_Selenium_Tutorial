package page_objects;

// import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
    protected WebDriver driver;
    String origin;
    String destination;

    public SearchResults(WebDriver driver, String origin, String destination){
        this.driver = driver;
        this.destination = destination;
        this.origin = origin;

        if (!driver.getTitle().equals("Cheap flights from " + origin + " to " + destination + " at Skyscanner")) {
        throw new IllegalStateException("This is not the search results page," +
                " current page is: " + driver.getCurrentUrl());
        }
    }

    /**
        * Get message (h1 tag)
        *
        * @return String message text
        */
    public String getMessageText() {
        return driver.getTitle();
    }

    // public SearchResults manageProfile() {
    //     // Page encapsulation to manage profile functionality
    //     return new SearchResults(driver);
    // }
    // /* More methods offering the services represented by Home Page
    // of Logged User. These methods in turn might return more Page Objects
    // for example click on Compose mail button could return ComposeMail class object */
}
