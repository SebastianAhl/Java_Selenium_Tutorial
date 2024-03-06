// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests for the sidebar object on the website

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
    private String login_Address = "https://www.saucedemo.com/";
    private String inventory_Url = "https://www.saucedemo.com/inventory.html";
    private String cart_Url = "https://www.saucedemo.com/cart.html";
    private String item_0_Url = "https://www.saucedemo.com/inventory-item.html?id=0";
    private WebDriver driver = new EdgeDriver(); 


    private Page_Login login_Page = new Page_Login();
    private Page_Sidebar sideBar_Page = new Page_Sidebar();
    private Page_Cart cart_Page = new Page_Cart();
    private Page_Inventory inventory_Page = new Page_Inventory();
    




    @Before
    public void openStartUrl(){
        //Webdriver        
        this.driver.get(this.login_Address);

        // Check URL
        assertEquals(this.login_Address, this.driver.getCurrentUrl());

        // Login standard_user
        String username = "standard_user";
        String password = "secret_sauce";

        // Login
        login_Page.login(this.driver, username, password);
        
        // Check URL Inventory
        assertEquals(this.inventory_Url, this.driver.getCurrentUrl());
   
    }

    @Test
    public void CloseSideBar(){
        // Open and close the Sidebar
        assertEquals("true", this.sideBar_Page.closeSidebar(this.driver));
    }

    @Test
    public void LinkAbout(){
        String aboutUrl = "https://saucelabs.com/";

        // Check the link function
        assertEquals(aboutUrl, this.sideBar_Page.checkAbout(this.driver));
    }

    @Test
    public void resetApp(){
        int expected_items_before_res = 6;
        int expected_items_after_res = 0;
        // Add all to cart
        this.inventory_Page.addalltocart(this.driver);

        // open cart
        this.inventory_Page.openCart(this.driver);

        // check if all is in cart
        assertEquals(expected_items_before_res, this.cart_Page.countItemsInCart(this.driver));

        // open sidebar and click reset app state
        this.sideBar_Page.resetApp(this.driver);

        // refresh site https://www.saucedemo.com/cart.html
        this.driver.navigate().refresh();

        // check cart is empty
        assertEquals(expected_items_after_res, this.cart_Page.countItemsInCart(this.driver));

    }

    @Test
    public void showAllItems(){
        // open cart
        this.inventory_Page.openCart(this.driver);

        // check url (cart)
        assertEquals(this.driver.getCurrentUrl(), this.cart_Url);

        // open sidebar and click All Items
        this.sideBar_Page.allItems(this.driver);

        // check url (inventory)
        assertEquals(this.driver.getCurrentUrl(), this.inventory_Url);

        // open item_0 Titel in inventory
        this.inventory_Page.openItemByTitle(this.driver, 0);

        // check url (item_0)
        assertEquals(this.driver.getCurrentUrl(), this.item_0_Url);

        // open sidebar and click All Items
        this.sideBar_Page.allItems(this.driver);

        // check url (inventory)
        assertEquals(this.driver.getCurrentUrl(), this.inventory_Url);
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver.quit();
    }
}
