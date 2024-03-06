package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Cart;
import page_objects.Page_Checkout_Complete;
import page_objects.Page_Checkout_Step_One;
import page_objects.Page_Checkout_Step_Two;
import page_objects.Page_Inventory;
import page_objects.Page_Login;



public class CartTests {
    WebDriver driver_edge = new EdgeDriver(); 
    String start_address = "https://www.saucedemo.com/";
    String dest_address = "https://www.saucedemo.com/inventory.html";
    Page_Login login_user = new Page_Login();
    Page_Inventory inventory_page = new Page_Inventory();
    Page_Cart cart_page = new Page_Cart();
    Page_Checkout_Step_One checkout_one_page = new Page_Checkout_Step_One();
    Page_Checkout_Step_Two checkout_two_page = new Page_Checkout_Step_Two();
    Page_Checkout_Complete checkout_complete_page = new Page_Checkout_Complete();
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

    @Test
    public void checkFullOrderProcess(){
        // Page_Inventory
        // add all to cart
        inventory_page.addalltocart(driver_edge);

        // press open cart button
        inventory_page.openCart(driver_edge);

        // Page_Cart
        // check if there are 6 items inside
        assertEquals(6, cart_page.countItemsInCart(driver_edge));

        // press checkout button
        cart_page.btnCheckout(driver_edge);

        // Page_Checkout_Step_One
        // add first name, last name, Zip/Postal Code
        checkout_one_page.addFirstName(driver_edge, "FIRST");
        checkout_one_page.addLastName(driver_edge, "LAST");
        checkout_one_page.addZipPostalCode(driver_edge, "0123456789");

        // press continue button
        checkout_one_page.btnContinue(driver_edge);

        // Page_Checkout_Step_Two
        // check Payment Information = SauceCard #31337
        assertEquals("SauceCard #31337", checkout_two_page.getPaymentInfo(driver_edge));

        // check Shipping Information = Free Pony Express Delivery!
        assertEquals("Free Pony Express Delivery!", checkout_two_page.getShippingInfo(driver_edge));

        // check Price Total
        // Item total: $129.94
        assertEquals("Item total: $129.94", checkout_two_page.getItemTotal(driver_edge));

        // Tax: $10.40
        assertEquals("Tax: $10.40", checkout_two_page.getTax(driver_edge));

        // check Total = Total: $140.34
        assertEquals("Total: $140.34", checkout_two_page.getTotal(driver_edge));

        // press Finish button
        checkout_two_page.btnFinish(driver_edge);

        // Page_Checkout_Complete
        // check "Thank you for your order!"
        assertEquals("Thank you for your order!", checkout_complete_page.getThankYou(driver_edge));

        // check "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                    checkout_complete_page.getInfoText(driver_edge));

        // press Back Home button
        checkout_complete_page.btnBackHome(driver_edge);

        // Page_Invetory
        // check url
        assertEquals("https://www.saucedemo.com/inventory.html", driver_edge.getCurrentUrl());
    }

    @After
    public void teardown(){
        // end webdriver
        this.driver_edge.quit();
    }
}

