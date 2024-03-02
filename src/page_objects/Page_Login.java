package page_objects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import classes.Test_Classes;

public class Page_Login {
    

    // username input
    private By usernameBy = By.id("user-name");

    // password input
    private By passwordBy = By.id("password");

    // login button
    private By loginbtnBy = By.id("login-button");


    public void login(WebDriver driver, String username, String password, String start_address, String dest_address) {
        driver.get(start_address);
        
        Test_Classes test_class = new Test_Classes();

        test_class.check_url(driver, start_address);

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginbtnBy).click();

        // check destination url
        test_class.check_url(driver, dest_address);

        // Page_Inventory page_Inventory = new Page_Inventory();
        // page_Inventory.check_url(driver, dest_address);

    }
}
