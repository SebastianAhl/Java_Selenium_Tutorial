import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test_skyscanner {
    
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.skyscanner.com");

        driver.quit();


        
        // Change the language to English
        // As a user, I want to change the language of the website, so I it will be viewed in English


        // Search for a flight
        // As a user, I want to search for flights, so I can travel from SGN to FRA.

    }

}
