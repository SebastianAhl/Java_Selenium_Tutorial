// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests of the Login/Logout function on the website

package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoginLogoutTests extends Tests{

    @BeforeEach
    public void openStartUrl(){
        //Webdriver        
        this.driver.get(this.login_Url);

        // Check URL
        assertEquals(this.login_Url, this.driver.getCurrentUrl());
   
    }

    @Test
    public void StandardUserLoginLogout(){
        String username = "standard_user";
        String password = "secret_sauce";

        // Login
        this.login_Page.login(this.driver, username, password);
        
        // Check URL Inventory
        assertEquals(this.inventory_Url, this.driver.getCurrentUrl());

        // Logout
        this.sidebar_Page.logout(driver);

        // Check URL Startpage
        assertEquals(this.login_Url, this.driver.getCurrentUrl());    
        
        
    }

    @Test
    public void LockedOutUser(){
        String username = "locked_out_user";
        String password = "secret_sauce";
        String OrigErrorMsg = "Epic sadface: Sorry, this user has been locked out.";

        // Login
        this.login_Page.login(this.driver, username, password);
        
        // Check URL Startpage
        assertEquals(this.login_Url, this.driver.getCurrentUrl());        

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
            assertEquals(this.login_Url, this.driver.getCurrentUrl());        

            // Check Error Message
            assertEquals(OrigErrorMsg, this.login_Page.returnError(driver));  
        }
        
    }
}