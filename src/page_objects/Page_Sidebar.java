package page_objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Sidebar {
    long timer_open_close_sidebar = 2;

    // Sidebar
    private By sideBarBy = By.className("bm-menu-wrap");
    // Open Sidebar
    private By openSidebarBtnBy = By.id("react-burger-menu-btn");

    // All Items
    private By allItemsBy = By.id("inventory_sidebar_link");

    // About
    private By aboutBy = By.id("about_sidebar_link");

    // Logout
    private By logoutBy = By.id("logout_sidebar_link");

    // Reset APP State
    private By resetAppStateBy = By.id("reset_sidebar_link");

    // Close Sidebar
    // private By closeSidebar = By.id("react-bm-cross-button");
    private By closeSidebarBtnBy = By.cssSelector("#react-burger-cross-btn");



    public void logout(WebDriver driver){
        driver.findElement(openSidebarBtnBy).click();
        driver.findElement(logoutBy).click();
    }

    public String closeSidebar(WebDriver driver){
        driver.findElement(openSidebarBtnBy).click();
        try {
            TimeUnit.SECONDS.sleep(timer_open_close_sidebar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(closeSidebarBtnBy).click();
        // wait for the sidebar to slide in
        try {
            TimeUnit.SECONDS.sleep(timer_open_close_sidebar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        return driver.findElement(sideBarBy).getDomProperty("hidden");
          
    }

    public String checkAbout(WebDriver driver){
        driver.findElement(openSidebarBtnBy).click();
        try {
            TimeUnit.SECONDS.sleep(timer_open_close_sidebar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(aboutBy).click();

        return driver.getCurrentUrl();
    }

    public void resetApp(WebDriver driver){
        driver.findElement(openSidebarBtnBy).click();
        try {
            TimeUnit.SECONDS.sleep(timer_open_close_sidebar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(resetAppStateBy).click();
    }
    
}