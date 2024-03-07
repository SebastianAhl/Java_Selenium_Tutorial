// Author:          Sebastian.Ahl@tewiz.de
// Description:     Tests for the sidebar object on the website

package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class SidebarTests extends Tests{
    private String item_0_Url = "https://www.saucedemo.com/inventory-item.html?id=0";

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
}
