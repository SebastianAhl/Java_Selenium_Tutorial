// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests the installation of selenium

package env_tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Test_Selenium {
    @Test
    @Tag("Env")
    public void main() {
        WebDriver driver = new ChromeDriver();
        
        driver.get("https://selenium.dev");



        WebDriver driveredge = new EdgeDriver();
        driveredge.get("https://selenium.dev");

        driver.quit();
        driveredge.quit();
    }
}