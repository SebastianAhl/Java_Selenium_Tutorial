// Test the flight search feature

package testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Inventory;
import page_objects.Page_Login;



public class TCCart {

    @Test
    public void addalltocart(){
// 
// 
        String username = "standard_user";
        String password = "secret_sauce";
//
// 
        WebDriver driver_edge = new EdgeDriver(); 
// 
// 
        Page_Login test_standard_user = new Page_Login();
        
        // go to URL and check if it is the right website
        test_standard_user.check_url(driver_edge);

        // login
        test_standard_user.login(driver_edge, username, password);

        // check the result
        Page_Inventory check_login = new Page_Inventory();
        check_login.check_url(driver_edge);
// 
// 
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