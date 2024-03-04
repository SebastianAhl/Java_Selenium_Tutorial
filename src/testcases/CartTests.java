// Test the flight search feature

package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Inventory;
import page_objects.Page_Login;



public class CartTests {
    WebDriver driver_edge = new EdgeDriver(); 
    String start_address = "https://www.saucedemo.com/";
    String dest_address = "https://www.saucedemo.com/inventory.html";
    Page_Login login_user = new Page_Login();
    String username = "standard_user";
    String password = "secret_sauce";

    @Before
    public void openStartUrl(){
        //Webdriver        
        this.driver_edge.get(this.start_address);

        // Check URL
        assertEquals(this.start_address, this.driver_edge.getCurrentUrl());

        // login
        // Login
        login_user.login(this.driver_edge, this.username, this.password);
        
        // Check URL
        assertEquals(this.dest_address, this.driver_edge.getCurrentUrl());
    }


    @Test
    @DisplayName("Test abc")
    public void addalltocartStandardUser(){
        // add all to the inventory
        Page_Inventory addall = new Page_Inventory();
        addall.addalltocart(driver_edge);

        

        // open cart 

        // check url of cart
        
        // check the prize
        
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver_edge.quit();
    }
}

