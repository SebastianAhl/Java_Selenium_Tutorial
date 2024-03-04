package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Sidebar {
    // Open Sidebar
    private By openSidebar = By.id("react-burger-menu-btn");

    // All Items
    private By allItems = By.id("inventory_sidebar_link");

    // About
    private By about = By.id("about_sidebar_link");

    // Logout
    private By logout = By.id("logout_sidebar_link");

    // Reset APP State
    private By resetAppState = By.id("reset_sidebar_link");

    // Close Sidebar
    private By closeSidebar = By.id("bm-cross-button");


    
    public void logout(WebDriver driver){
        driver.findElement(openSidebar).click();
        driver.findElement(logout).click();
    }
    
}