package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Login;
import page_objects.Page_Sidebar;

public class SidebarTests {
String login_address = "https://www.saucedemo.com/";
    String inventory_address = "https://www.saucedemo.com/inventory.html";
    WebDriver driver_edge = new EdgeDriver(); 
    Page_Login loginPage = new Page_Login();
    Page_Sidebar sideBar = new Page_Sidebar();
    Page_Sidebar sidebarPage = new Page_Sidebar();
    
    @Before
    public void openStartUrl(){
        //Webdriver        
        this.driver_edge.get(this.login_address);

        // Check URL
        assertEquals(this.login_address, this.driver_edge.getCurrentUrl());

        // Login standard_user
        String username = "standard_user";
        String password = "secret_sauce";

        // Login
        loginPage.login(this.driver_edge, username, password);
        
        // Check URL Inventory
        assertEquals(this.inventory_address, this.driver_edge.getCurrentUrl());
   
    }

    @Test
    public void CloseSideBar(){
        // Open and close the Sidebar
        String Result = sideBar.closeSidebar(driver_edge);

        assertEquals("true", Result);
    }

    @Test
    public void LinkAbout(){
        String aboutUrl = "https://saucelabs.com/";

        // Check the link function
        String Result = sideBar.checkAbout(driver_edge);

        assertEquals(aboutUrl, Result);
    }


    @After
    public void teardown(){
        // end webdriver
        this.driver_edge.quit();
    }
}
