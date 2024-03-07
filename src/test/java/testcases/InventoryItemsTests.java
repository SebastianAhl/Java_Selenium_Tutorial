// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests for the inventory site

package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InventoryItemsTests extends Tests{

    @Test
    public void checkItem0(){
        String title = "Sauce Labs Bike Light";
        String description = String.join(" ",
                         "A red light isn't the desired state in testing",
                         "but it sure helps when riding your bike at night.",
                         "Water-resistant with 3 lighting modes, 1 AAA battery included.");
        String urlImg = "https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg";
        String price = "$9.99";

        this.inventory_Page.openItemByTitle(this.driver, 0);
        
        String[] retValues = this.item_Page.returnValues(this.driver);

        assertEquals(title, retValues[0]);
        assertEquals(description, retValues[1]);
        assertEquals(urlImg, retValues[2]);
        assertEquals(price, retValues[3]);
        
    }

    @Test
    public void checkItem1(){
        String title = "Sauce Labs Bolt T-Shirt";
        String description = String.join(" ",
                         "Get your testing superhero on with the Sauce Labs bolt T-shirt.",
                         "From American Apparel, 100% ringspun combed cotton, heather",
                         "gray with red bolt.");
        String urlImg = "https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c2599ac5.jpg";
        String price = "$15.99";

        this.inventory_Page.openItemByTitle(this.driver, 1);
        
        String[] retValues = this.item_Page.returnValues(this.driver);

        assertEquals(title, retValues[0]);
        assertEquals(description, retValues[1]);
        assertEquals(urlImg, retValues[2]);
        assertEquals(price, retValues[3]);
        
    }

    @Test
    public void checkItem2(){
        String title = "Sauce Labs Onesie";
        String description = String.join(" ",
                         "Rib snap infant onesie for the junior automation engineer in",
                         "development. Reinforced 3-snap bottom closure, two-needle",
                         "hemmed sleeved and bottom won't unravel.");
        String urlImg = "https://www.saucedemo.com/static/media/red-onesie-1200x1500.2ec615b2.jpg";
        String price = "$7.99";

        this.inventory_Page.openItemByTitle(this.driver, 2);
        
        String[] retValues = this.item_Page.returnValues(this.driver);

        assertEquals(title, retValues[0]);
        assertEquals(description, retValues[1]);
        assertEquals(urlImg, retValues[2]);
        assertEquals(price, retValues[3]);
        
    }

    @Test
    public void checkItem3(){
        String title = "Test.allTheThings() T-Shirt (Red)";
        String description = String.join(" ",
                         "This classic Sauce Labs t-shirt is perfect to wear when cozying",
                         "up to your keyboard to automate a few tests. Super-soft and",
                         "comfy ringspun combed cotton.");
        String urlImg = "https://www.saucedemo.com/static/media/red-tatt-1200x1500.30dadef4.jpg";
        String price = "$15.99";

        this.inventory_Page.openItemByTitle(this.driver, 3);
        
        String[] retValues = this.item_Page.returnValues(this.driver);

        assertEquals(title, retValues[0]);
        assertEquals(description, retValues[1]);
        assertEquals(urlImg, retValues[2]);
        assertEquals(price, retValues[3]);
        
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
    public void checkItem5(){
        String title = "Sauce Labs Fleece Jacket";
        String description = String.join(" ",
                         "It's not every day that you come across a midweight quarter-zip",
                         "fleece jacket capable of handling everything from a relaxing day",
                         "outdoors to a busy day at the office.");
        String urlImg = "https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg";
        String price = "$49.99";

        this.inventory_Page.openItemByTitle(this.driver, 5);
        
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
