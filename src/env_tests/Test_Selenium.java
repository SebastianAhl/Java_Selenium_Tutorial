package env_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test_Selenium {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://selenium.dev");



        WebDriver driveredge = new EdgeDriver();
        driveredge.get("https://selenium.dev");

        driver.quit();
        driveredge.quit();
    }
}