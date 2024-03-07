// Author:          Sebastian.Ahl@tewiz.de
// Description:     Page object for the Sidebar

package tutorials.java.page_objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Sidebar {
    private long timer_open_close_sidebar = 2;

    // Sidebar
    private By sideBarBy = By.className("bm-menu-wrap");
    // Open Sidebar
    private By btnOpenSidebarBy = By.id("react-burger-menu-btn");

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

    private void sideBarWait(){
        try {
            TimeUnit.SECONDS.sleep(this.timer_open_close_sidebar);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void logout(WebDriver driver){
        driver.findElement(this.btnOpenSidebarBy).click();
        sideBarWait();

        driver.findElement(this.logoutBy).click();
    }

    public String closeSidebar(WebDriver driver){
        driver.findElement(this.btnOpenSidebarBy).click();
        sideBarWait();

        driver.findElement(this.closeSidebarBtnBy).click();
        sideBarWait();
        
        return driver.findElement(this.sideBarBy).getDomProperty("hidden");
          
    }

    public String checkAbout(WebDriver driver){
        driver.findElement(this.btnOpenSidebarBy).click();
        sideBarWait();

        driver.findElement(this.aboutBy).click();

        return driver.getCurrentUrl();
    }

    public void resetApp(WebDriver driver){
        driver.findElement(this.btnOpenSidebarBy).click();
        sideBarWait();

        driver.findElement(this.resetAppStateBy).click();
    }

    public void allItems(WebDriver driver){
        driver.findElement(this.btnOpenSidebarBy).click();
        sideBarWait();

        driver.findElement(this.allItemsBy).click();
    }
    
}