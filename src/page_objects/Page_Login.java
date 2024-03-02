package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Login {
    String address = "https://www.saucedemo.com/";

    // username input
    private By usernameBy = By.id("user-name");

    // password input
    private By passwordBy = By.id("password");

    // login button
    private By loginbtnBy = By.id("login-button");



    public void check_url(WebDriver driver){
        driver.get(address);

        if (!driver.getCurrentUrl().equals(address)) {
            throw new IllegalStateException("This is not the Login Page," +
                  " current page is: " + driver.getCurrentUrl());
        }
    } 

    public void login(WebDriver driver, String username, String password) {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginbtnBy).click();

        // Page_Inventory Page_Inventory = new Page_Inventory();
        // return Page_Inventory;
        // return new Page_SearchResults(driver, origin, destination);
        // return new Page_Inventory();
    }
}
