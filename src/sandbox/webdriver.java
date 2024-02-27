package sandbox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class webdriver {
    public static void connect(String browser) {
        // Webdriver driver = new webdriver();      
        
        // switch (browser) {
        //     case "chrome":
        //         WebDriver driver = new ChromeDriver();
        //         break;
        //     case "edge":
        //         WebDriver driver = new EdgeDriver();
        //     default:
        //         break;
        // }
        
        
        
        // driver.get("https://selenium.dev");



        WebDriver driveredge = new EdgeDriver();
        driveredge.get("https://selenium.dev");

        // driver.quit();
        driveredge.quit();

        // return driver;
    }
}
