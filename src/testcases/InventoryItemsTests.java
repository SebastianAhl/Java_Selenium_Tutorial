// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests for the inventory site

package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Cart;
import page_objects.Page_Inventory;
import page_objects.Page_Items;
import page_objects.Page_Login;

public class InventoryItemsTests {
    private WebDriver driver = new EdgeDriver(); 
    private String start_Address = "https://www.saucedemo.com/";
    private String dest_Address = "https://www.saucedemo.com/inventory.html";
    private String username = "standard_user";
    private String password = "secret_sauce";

    private Page_Login login_Page = new Page_Login();
    private Page_Inventory inventory_Page = new Page_Inventory();
    private Page_Items item_Page = new Page_Items();
    private Page_Cart cart_Page = new Page_Cart();





    @Before
    public void openStartUrl(){
        //Webdriver        
        this.driver.get(this.start_Address);

        // Check URL
        assertEquals(this.start_Address, this.driver.getCurrentUrl());

        // login
        // Login
        login_Page.login(this.driver, this.username, this.password);
        
        // Check URL
        assertEquals(this.dest_Address, this.driver.getCurrentUrl());
    }


    @Test
    public void checkItem4(){
        String title = "Sauce Labs Backpack";
        String description = String.join(" ",
                         "carry.allTheThings() with the sleek,",
                         "streamlined Sly Pack that melds uncompromising style with",
                         "unequaled laptop and tablet protection.");
        String urlImg = "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg";
        String price = "$29.99";

        this.inventory_Page.openItemByTitle(this.driver, 4);
        
        String[] retValues = this.item_Page.returnValues(this.driver);

        assertEquals(title, retValues[0]);
        assertEquals(description, retValues[1]);
        assertEquals(urlImg, retValues[2]);
        assertEquals(price, retValues[3]);
        
    }

    @Test
    public void addAllItemsToCart(){
        for(int i = 0; i <=5; i++){
            // open each item
            this.inventory_Page.openItemByTitle(this.driver, i);
            // add each item to cart
            this.item_Page.addCartItem(this.driver, i);
            // go back to product each time
            this.item_Page.backToProducts(this.driver);
        }

        // open cart      
        this.inventory_Page.openCart(this.driver);

        // check cart
        assertEquals(6, this.cart_Page.countItemsInCart(this.driver));
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver.quit();
    }

}
