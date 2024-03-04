// Test the flight search feature

package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Login;
import page_objects.Page_Sidebar;



public class LoginLogoutTests {

    String login_address = "https://www.saucedemo.com/";
    String inventory_address = "https://www.saucedemo.com/inventory.html";
    WebDriver driver_edge = new EdgeDriver(); 
    Page_Login loginPage = new Page_Login();
    Page_Sidebar sidebarPage = new Page_Sidebar();
    
    @Before
    public void openStartUrl(){
        //Webdriver        
        this.driver_edge.get(this.login_address);

        // Check URL
        assertEquals(this.login_address, this.driver_edge.getCurrentUrl());
   
    }

    @Test
    public void StandardUserLoginLogout(){
        String username = "standard_user";
        String password = "secret_sauce";

        // Login
        loginPage.login(this.driver_edge, username, password);
        
        // Check URL Inventory
        assertEquals(this.inventory_address, this.driver_edge.getCurrentUrl());

        // Logout
        sidebarPage.logout(driver_edge);

        // Check URL Startpage
        assertEquals(this.login_address, this.driver_edge.getCurrentUrl());    
        
        
    }

    @Test
    public void LockedOutUser(){
        String username = "locked_out_user";
        String password = "secret_sauce";
        String OrigErrorMsg = "Epic sadface: Sorry, this user has been locked out.";
        String RecErrorMsg;

        // Login
        loginPage.login(this.driver_edge, username, password);
        
        // Check URL Startpage
        assertEquals(this.login_address, this.driver_edge.getCurrentUrl());        

        // Get Error Message
        RecErrorMsg = loginPage.returnError(driver_edge);

        // Check Error Message
        assertEquals(OrigErrorMsg, RecErrorMsg);

    }

    @Test
    public void UserPwdNotMatch(){
        String username = "USER";
        String password = "PASSWORD";
        String OrigErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        String RecErrorMsg;
        
        for(int i = 0; i<=1; i++){
            loginPage.deleteInput(driver_edge);

            switch (i) {
                case 0:
                    username = "USER";
                    password = "secret_sauce";
                    break;
                case 1:
                    username = "standard_user";
                    password = "PASSWORD";
                    break;
            }

            // Login
            loginPage.login(this.driver_edge, username, password);
            
            // Check URL Startpage
            assertEquals(this.login_address, this.driver_edge.getCurrentUrl());        

            // Get Error Message
            RecErrorMsg = loginPage.returnError(driver_edge);

            // Check Error Message
            assertEquals(OrigErrorMsg, RecErrorMsg);  
        }
        
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver_edge.quit();
    }
}