package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Cart;
import page_objects.Page_Inventory;
import page_objects.Page_Login;
import page_objects.Page_Sidebar;

public class SidebarTests {
String login_address = "https://www.saucedemo.com/";
    String inventory_url = "https://www.saucedemo.com/inventory.html";
    String cart_url = "https://www.saucedemo.com/cart.html";
    String item_0_url = "https://www.saucedemo.com/inventory-item.html?id=0";
    WebDriver driver_edge = new EdgeDriver(); 
    Page_Login loginPage = new Page_Login();
    Page_Sidebar sideBar = new Page_Sidebar();
    Page_Cart cart = new Page_Cart();
    Page_Inventory inventory = new Page_Inventory();
    
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
        assertEquals(this.inventory_url, this.driver_edge.getCurrentUrl());
   
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

    @Test
    public void resetApp(){
        int items;
        int expected_items_before_res = 6;
        int expected_items_after_res = 0;
        // Add all to cart
        inventory.addalltocart(driver_edge);

        // open cart
        inventory.openCart(driver_edge);

        // check if all is in cart
        items = cart.countItemsInCart(driver_edge);
        assertEquals(items, expected_items_before_res);

        // open sidebar and click reset app state
        sideBar.resetApp(driver_edge);

        // refresh site https://www.saucedemo.com/cart.html
        driver_edge.navigate().refresh();

        // check cart is empty
        items = cart.countItemsInCart(driver_edge);
        assertEquals(items, expected_items_after_res);

    }

    @Test
    public void allItems(){
        // open cart
        inventory.openCart(driver_edge);

        // check url (cart)
        assertEquals(driver_edge.getCurrentUrl(), this.cart_url);

        // open sidebar and click All Items
        sideBar.allItems(driver_edge);

        // check url (inventory)
        assertEquals(driver_edge.getCurrentUrl(), this.inventory_url);

        // open item_0 Titel in inventory
        inventory.openItemByTitle(driver_edge, 0);

        // check url (item_0)
        assertEquals(driver_edge.getCurrentUrl(), this.item_0_url);

        // open sidebar and click All Items
        sideBar.allItems(driver_edge);

        // check url (inventory)
        assertEquals(driver_edge.getCurrentUrl(), this.inventory_url);
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver_edge.quit();
    }
}
