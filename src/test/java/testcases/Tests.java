// Author:          Sebastian.Ahl@tewiz.de
// Description:     Parent class containing variables globally used and @Befor and @After

package testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import tutorials.java.page_objects.Page_Cart;
import tutorials.java.page_objects.Page_Checkout_Complete;
import tutorials.java.page_objects.Page_Checkout_Step_One;
import tutorials.java.page_objects.Page_Checkout_Step_Two;
import tutorials.java.page_objects.Page_Inventory;
import tutorials.java.page_objects.Page_Items;
import tutorials.java.page_objects.Page_Login;
import tutorials.java.page_objects.Page_Sidebar;

public class Tests {
    protected String login_Url = "https://www.saucedemo.com/";
    protected String inventory_Url = "https://www.saucedemo.com/inventory.html";
    protected String cart_Url = "https://www.saucedemo.com/cart.html";

    // protected WebDriver driver = new FirefoxDriver();
    // protected WebDriver driver = new ChromeDriver(); 
    protected WebDriver driver = new EdgeDriver();

    protected Page_Login login_Page = new Page_Login();
    protected Page_Sidebar sidebar_Page = new Page_Sidebar();
    protected Page_Sidebar sideBar_Page = new Page_Sidebar();
    protected Page_Cart cart_Page = new Page_Cart();
    protected Page_Inventory inventory_Page = new Page_Inventory();
    protected Page_Items item_Page = new Page_Items();
    protected Page_Checkout_Step_One checkout_One_Page = new Page_Checkout_Step_One();
    protected Page_Checkout_Step_Two checkout_Two_Page = new Page_Checkout_Step_Two();
    protected Page_Checkout_Complete checkout_Complete_Page = new Page_Checkout_Complete();

    @BeforeEach
    public void openStartUrl(){
        //Webdriver        
        this.driver.get(this.login_Url);

        // Check URL
        assertEquals(this.login_Url, this.driver.getCurrentUrl());

        // Login standard_user
        String username = "standard_user";
        String password = "secret_sauce";

        // Login
        login_Page.login(this.driver, username, password);
        
        // Check URL Inventory
        assertEquals(this.inventory_Url, this.driver.getCurrentUrl());
    }

    @AfterEach
    public void teardown(){
        // end webdriver
        this.driver.quit();
    }

}
