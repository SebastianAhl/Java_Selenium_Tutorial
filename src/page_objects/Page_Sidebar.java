package page_objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Sidebar {
    // Sidebar
    private By sideBar = By.className("bm-menu-wrap");
    // Open Sidebar
    private By openSidebarBtn = By.id("react-burger-menu-btn");

    // All Items
    private By allItems = By.id("inventory_sidebar_link");

    // About
    private By about = By.id("about_sidebar_link");

    // Logout
    private By logout = By.id("logout_sidebar_link");

    // Reset APP State
    private By resetAppState = By.id("reset_sidebar_link");

    // Close Sidebar
    // private By closeSidebar = By.id("react-bm-cross-button");
    private By closeSidebarBtn = By.cssSelector("#react-burger-cross-btn");



    public void logout(WebDriver driver){
        driver.findElement(openSidebarBtn).click();
        driver.findElement(logout).click();
    }

    public String closeSidebar(WebDriver driver){
        driver.findElement(openSidebarBtn).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElement(closeSidebarBtn).click();
        // wait for the sidebar to slide in
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return driver.findElement(sideBar).getDomProperty("hidden");
          
    }

    public String checkAbout(WebDriver driver){
        driver.findElement(openSidebarBtn).click();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElement(about).click();

        return driver.getCurrentUrl();
    }


    
}