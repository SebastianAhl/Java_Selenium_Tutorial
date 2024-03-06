// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests for the inventory site

package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class InventoryItemsTests extends Tests{

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
}
