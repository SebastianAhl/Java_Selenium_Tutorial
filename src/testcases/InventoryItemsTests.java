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
    WebDriver driver_edge = new EdgeDriver(); 
    String start_address = "https://www.saucedemo.com/";
    String dest_address = "https://www.saucedemo.com/inventory.html";
    Page_Login login_page = new Page_Login();
    Page_Inventory inventory_page = new Page_Inventory();
    Page_Items item_page = new Page_Items();
    Page_Cart cart_page = new Page_Cart();
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
        login_page.login(this.driver_edge, this.username, this.password);
        
        // Check URL
        assertEquals(this.dest_address, this.driver_edge.getCurrentUrl());
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

        inventory_page.openItemByTitle(driver_edge, 4);
        
        String[] retValues = item_page.returnValues(driver_edge);

        assertEquals(title, retValues[0]);
        assertEquals(description, retValues[1]);
        assertEquals(urlImg, retValues[2]);
        assertEquals(price, retValues[3]);
        
    }

    @Test
    public void addAllItemsToCart(){
        for(int i = 0; i <=5; i++){
            // open each item
            inventory_page.openItemByTitle(driver_edge, i);
            // add each item to cart
            item_page.addCartItem(driver_edge, i);
            // go back to product each time
            item_page.backToProducts(driver_edge);
        }

        // open cart      
        inventory_page.openCart(driver_edge);

        // check cart
        int itemsInCart = cart_page.countItemsInCart(driver_edge);

        assertEquals(itemsInCart, 6);
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver_edge.quit();
    }

}
