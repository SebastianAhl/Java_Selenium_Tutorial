// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests for the cart object on the website

package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;




public class CartTests extends Tests{

    @Test
    @Tag("Test")
    public void addremovealltoCartStandardUser(){
        // add all to the cart
        this.inventory_Page.addalltocart(this.driver);

        // open cart
        this.inventory_Page.openCart(this.driver);

        assertEquals("Elements in cart: 0", this.cart_Page.removeAllItems(this.driver));
        
    }

    @Test
    @Tag("Test")
    public void selectSort(){
        String text;

        for( int i = 0; i < 4; i++){
            // index A-Z=0 ; Z-A=1 ; Price low-high=2 ; Price high-low=3
            text = this.inventory_Page.sortItems(this.driver, i);

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
    @Tag("Test")
    public void checkFullOrderProcess(){
        // Page_Inventory
        // add all to cart
        this.inventory_Page.addalltocart(this.driver);

        // press open cart button
        this.inventory_Page.openCart(this.driver);

        // Page_Cart
        // check if there are 6 items inside
        assertEquals(6, this.cart_Page.countItemsInCart(this.driver));

        // press checkout button
        this.cart_Page.btnCheckout(this.driver);

        // Page_Checkout_Step_One
        // add first name, last name, Zip/Postal Code
        this.checkout_One_Page.addFirstName(this.driver, "FIRST");
        this.checkout_One_Page.addLastName(this.driver, "LAST");
        this.checkout_One_Page.addZipPostalCode(this.driver, "0123456789");

        // press continue button
        this.checkout_One_Page.btnContinue(this.driver);

        // Page_Checkout_Step_Two
        // check Payment Information = SauceCard #31337
        assertEquals("SauceCard #31337", this.checkout_Two_Page.getPaymentInfo(this.driver));

        // check Shipping Information = Free Pony Express Delivery!
        assertEquals("Free Pony Express Delivery!", this.checkout_Two_Page.getShippingInfo(this.driver));

        // check Price Total
        // Item total: $129.94
        assertEquals("Item total: $129.94", this.checkout_Two_Page.getItemTotal(this.driver));

        // Tax: $10.40
        assertEquals("Tax: $10.40", this.checkout_Two_Page.getTax(this.driver));

        // check Total = Total: $140.34
        assertEquals("Total: $140.34", this.checkout_Two_Page.getTotal(this.driver));

        // press Finish button
        this.checkout_Two_Page.btnFinish(this.driver);

        // Page_Checkout_Complete
        // check "Thank you for your order!"
        assertEquals("Thank you for your order!", this.checkout_Complete_Page.getThankYou(this.driver));

        // check "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",
        this.checkout_Complete_Page.getInfoText(this.driver));

        // press Back Home button
        this.checkout_Complete_Page.btnBackHome(this.driver);

        // Page_Invetory
        // check url
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }
}

