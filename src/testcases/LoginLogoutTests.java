// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests of the Login/Logout function on the website

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

    private String login_Address = "https://www.saucedemo.com/";
    private String inventory_Address = "https://www.saucedemo.com/inventory.html";
    private WebDriver driver = new EdgeDriver(); 

    private Page_Login login_Page = new Page_Login();
    private Page_Sidebar sidebar_Page = new Page_Sidebar();
    




    @Before
    public void openStartUrl(){
        //Webdriver        
        this.driver.get(this.login_Address);

        // Check URL
        assertEquals(this.login_Address, this.driver.getCurrentUrl());
   
    }

    @Test
    public void StandardUserLoginLogout(){
        String username = "standard_user";
        String password = "secret_sauce";

        // Login
        this.login_Page.login(this.driver, username, password);
        
        // Check URL Inventory
        assertEquals(this.inventory_Address, this.driver.getCurrentUrl());

        // Logout
        this.sidebar_Page.logout(driver);

        // Check URL Startpage
        assertEquals(this.login_Address, this.driver.getCurrentUrl());    
        
        
    }

    @Test
    public void LockedOutUser(){
        String username = "locked_out_user";
        String password = "secret_sauce";
        String OrigErrorMsg = "Epic sadface: Sorry, this user has been locked out.";

        // Login
        this.login_Page.login(this.driver, username, password);
        
        // Check URL Startpage
        assertEquals(this.login_Address, this.driver.getCurrentUrl());        

        // Check Error Message
        assertEquals(OrigErrorMsg, this.login_Page.returnError(this.driver));
    }

    @Test
    public void UserPwdNotMatch(){
        String username = "USER";
        String password = "PASSWORD";
        String OrigErrorMsg = "Epic sadface: Username and password do not match any user in this service";
        
        for(int i = 0; i<=1; i++){
            this.login_Page.deleteInput(this.driver);

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
            this.login_Page.login(this.driver, username, password);
            
            // Check URL Startpage
            assertEquals(this.login_Address, this.driver.getCurrentUrl());        

            // Check Error Message
            assertEquals(OrigErrorMsg, this.login_Page.returnError(driver));  
        }
        
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver.quit();
    }
}