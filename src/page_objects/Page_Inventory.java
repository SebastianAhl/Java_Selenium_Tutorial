package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Inventory {
    String address = "https://www.saucedemo.com/inventory.html";

    // Sauce Labs Backpack title
    // link product information
    private By backpacktitleBy = By.id("item_4_title_link");

    // Sauce Labs Backpack image
    // link product information
    private By backpackimgBy = By.id("item_4_img_link");

    // Sauce Labs Backpack Add to cart
    private By backpackaddcartBy = By.id("add-to-cart-sauce-labs-backpack");

 
    // Sauce Labs Bike Light title
    // link product information
    private By bikelighttitleBy = By.id("item_0_title_link");

    // Sauce Labs Bike Light image
    // link product information
    private By bikelightimgBy = By.id("item_0_img_link");

    // Sauce Labs Bike Light Add to cart
    private By bikelightaddcartBy = By.id("add-to-cart-sauce-labs-bike-light");


    // Sauce Labs Bolt T-Shirt title
    // link product information
    private By bolttshirttitleBy = By.id("item_1_title_link");

    // Sauce Labs Bolt T-Shirt image
    // link product information
    private By bolttshirtimgBy = By.id("item_1_img_link");

    // Sauce Labs Bolt T-Shirt Add to cart
    private By bolttshirtaddcartBy = By.id("add-to-cart-sauce-labs-bolt-t-shirt");


    // Sauce Labs Labs Fleece Jacket title
    // link product information
    private By fleecejackettitleBy = By.id("item_5_title_link");

    // Sauce Labs Labs Fleece Jacket image
    // link product information
    private By fleecejacketimgBy = By.id("item_5_img_link");

    // Sauce Labs Labs Fleece Jacket Add to cart
    private By fleecejacketaddcartBy = By.id("add-to-cart-sauce-labs-fleece-jacket");


    // Sauce Labs Onesie title
    // link product information
    private By onesietitleBy = By.id("item_2_title_link");

    // Sauce Labs Onesie image
    // link product information
    private By onesieimgBy = By.id("item_2_img_link");

    // Sauce Labs Onesie Add to cart
    private By onesieaddcartBy = By.id("add-to-cart-sauce-labs-onesie");


    // Sauce Labs Test T-Shirt title
    // link product information
    private By testtshirttitleBy = By.id("item_3_title_link");

    // Sauce Labs Test T-Shirt image
    // link product information
    private By testtshirtimgBy = By.id("item_3_img_link");

    // Sauce Labs Test T-Shirt Add to cart
    private By testtshirtaddcartBy = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    public void check_url(WebDriver driver){
        driver.get(address);

        if (!driver.getCurrentUrl().equals(address)) {
            throw new IllegalStateException("This is not the Inventory Page," +
                  " current page is: " + driver.getCurrentUrl());
        }
    } 

    public void addalltocart(WebDriver driver) {
        driver.findElement(backpackaddcartBy).click();
        driver.findElement(bikelightaddcartBy).click();
        driver.findElement(bolttshirtaddcartBy).click();
        driver.findElement(fleecejacketaddcartBy).click();
        driver.findElement(onesieaddcartBy).click();
        driver.findElement(testtshirtaddcartBy).click();
        // driver.findElement(usernameBy).sendKeys(username);
        // driver.findElement(passwordBy).sendKeys(password);
        // driver.findElement(loginbtnBy).click();

        // return new Page_SearchResults(driver, origin, destination);
    }
}
