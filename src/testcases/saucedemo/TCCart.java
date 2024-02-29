// Test the flight search feature

package testcases.saucedemo;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.saucedemo.Page_Inventory;



public class TCCart {

    @Test
    public void addalltocart(){
        
        WebDriver driver_edge = new EdgeDriver(); 

        Page_Inventory addall = new Page_Inventory();

        // go to URL and check if it is the right website
        addall.check_url(driver_edge);

        // login
        addall.addalltocart(driver_edge);

        // check the result
        // open cart and check the prize
        
        driver_edge.quit();
    }
}