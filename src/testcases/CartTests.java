// Test the flight search feature

package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Cart;
import page_objects.Page_Inventory;
import page_objects.Page_Login;



public class CartTests {
    WebDriver driver_edge = new EdgeDriver(); 
    String start_address = "https://www.saucedemo.com/";
    String dest_address = "https://www.saucedemo.com/inventory.html";
    Page_Login login_user = new Page_Login();
    Page_Inventory inventory_page = new Page_Inventory();
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
    public void addremovealltoCartStandardUser(){
        String Result;
        
        Page_Inventory pageInventory = new Page_Inventory();
        Page_Cart removeAll = new Page_Cart();

        // add all to the cart
        pageInventory.addalltocart(driver_edge);

        // open cart
        pageInventory.openCart(driver_edge);

        // remove all from cart
        Result = removeAll.removeAllItems(driver_edge);
        
        assertEquals(Result, "Elements in cart: 0");
        
    }

    @Test
    public void selectSort(){
        String text;

        for( int i = 0; i < 4; i++){
            // index A-Z=0 ; Z-A=1 ; Price low-high=2 ; Price high-low=3
            text = inventory_page.sortItems(driver_edge, i);

            switch (i) {
                case 0:
                    // text Name (A to Z)
                    assertEquals(text, "Name (A to Z)");
                    break;
                case 1:
                    // text Name (Z to A)
                    assertEquals(text, "Name (Z to A)");  
                    break;
                case 2:
                    // text Price (low to high)
                    assertEquals(text, "Price (low to high)");
                    break;
                case 3:
                    // text Price (high to low)
                    assertEquals(text, "Price (high to low)");
                    break;    
            }
        }
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver_edge.quit();
    }
}

