// Test the flight search feature

package testcases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import page_objects.Page_Inventory;
import page_objects.Page_Login;



public class TCLogin {

    @Test
    public void tcLoginUser(){
        String username = "standard_user";
        String password = "secret_sauce";
        String start_address = "https://www.saucedemo.com/";
        String dest_address = "https://www.saucedemo.com/inventory.html";
        
        WebDriver driver_edge = new EdgeDriver(); 

        Page_Login test_login_user = new Page_Login();

        // go to URL and check if it is the right website
        // test_standard_user.check_url(driver_edge);

        // login
        // test_standard_user.login(driver_edge, username, password);
        test_login_user.login(driver_edge, username, password, start_address, dest_address);

        // logout


        // next user
        
        driver_edge.quit();
    }
}