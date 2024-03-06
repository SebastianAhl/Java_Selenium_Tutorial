package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_Cart {

    // Sauce Labs Backpack title
    // link product information
    private By backpacktitleBy = By.id("item_4_title_link");
    // remove
    private By backpackremoveBy = By.id("remove-sauce-labs-backpack");
 
    // Sauce Labs Bike Light title
    // link product information
    private By bikelighttitleBy = By.id("item_0_title_link");
    // remove
    private By bikelightremoveBy = By.id("remove-sauce-labs-bike-light");


    // Sauce Labs Bolt T-Shirt title
    // link product information
    private By bolttshirttitleBy = By.id("item_1_title_link");
    // remove
    private By bolttshirtremoveBy = By.id("remove-sauce-labs-bolt-t-shirt");


    // Sauce Labs Labs Fleece Jacket title
    // link product information
    private By fleecejackettitleBy = By.id("item_5_title_link");
    // remove
    private By fleecejacketremoveBy = By.id("remove-sauce-labs-fleece-jacket");


    // Sauce Labs Onesie title
    // link product information
    private By onesietitleBy = By.id("item_2_title_link");
    // remove
    private By onesieremoveBy = By.id("remove-sauce-labs-onesie");

    // Sauce Labs Test T-Shirt title
    // link product information
    private By testtshirttitleBy = By.id("item_3_title_link");
    // remove
    private By testtshirtremoveBy = By.id("remove-test.allthethings()-t-shirt-(red)");

    // Cart items
    private By cartItemsBy = By.className("cart_item");

    // Button Checkout
    private By btnCheckoutBy = By.id("checkout");





    public String removeAllItems(WebDriver driver){
        // count Cart Items
        List<WebElement> listCartItems;
        listCartItems = driver.findElements(cartItemsBy);
        if (listCartItems.size() == 0){
            return "No Elements in the basket!";
        }


        driver.findElement(backpackremoveBy).click();
        driver.findElement(bikelightremoveBy).click();
        driver.findElement(bolttshirtremoveBy).click();
        driver.findElement(fleecejacketremoveBy).click();
        driver.findElement(onesieremoveBy).click();
        driver.findElement(testtshirtremoveBy).click();

        // check if cart is empty
        List<WebElement> listCartItemsDel;
        listCartItemsDel = driver.findElements(cartItemsBy);
        return ("Elements in cart: " + listCartItemsDel.size());
    }

    public int countItemsInCart(WebDriver driver){
        // count Cart Items
        List<WebElement> listCartItems;
        listCartItems = driver.findElements(cartItemsBy);
        return listCartItems.size();
    }

    public void btnCheckout(WebDriver driver){
        driver.findElement(btnCheckoutBy).click();
    }
}