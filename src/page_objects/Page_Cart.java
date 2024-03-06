// Author:          Sebastian.Ahl@tewiz.de
// Description:     Page object for the Cart

package page_objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_Cart {

    // Sauce Labs Backpack title
    // link product information
    private By backPackTitleBy = By.id("item_4_title_link");
    // remove
    private By backPackRemoveBy = By.id("remove-sauce-labs-backpack");

    // Sauce Labs Bike Light title
    // link product information
    private By bikeLightTitleBy = By.id("item_0_title_link");
    // remove
    private By bikeLightRemoveBy = By.id("remove-sauce-labs-bike-light");

    // Sauce Labs Bolt T-Shirt title
    // link product information
    private By boltTshirtTitleBy = By.id("item_1_title_link");
    // remove
    private By boltTshirtRemoveBy = By.id("remove-sauce-labs-bolt-t-shirt");

    // Sauce Labs Labs Fleece Jacket title
    // link product information
    private By fleeceJacketTitleBy = By.id("item_5_title_link");
    // remove
    private By fleeceJacketRemoveBy = By.id("remove-sauce-labs-fleece-jacket");

    // Sauce Labs Onesie title
    // link product information
    private By onesieTitleBy = By.id("item_2_title_link");
    // remove
    private By onesieRemoveBy = By.id("remove-sauce-labs-onesie");

    // Sauce Labs Test T-Shirt title
    // link product information
    private By testTshirtTitleBy = By.id("item_3_title_link");
    // remove
    private By testTshirtRemoveBy = By.id("remove-test.allthethings()-t-shirt-(red)");

    // Cart items
    private By cartItemsBy = By.className("cart_item");

    // Button Checkout
    private By btnCheckoutBy = By.id("checkout");

    public String removeAllItems(WebDriver driver) {
        // count Cart Items
        List<WebElement> listCartItems;
        listCartItems = driver.findElements(cartItemsBy);
        if (listCartItems.size() == 0) {
            return "No Elements in the basket!";
        }

        driver.findElement(this.backPackRemoveBy).click();
        driver.findElement(this.bikeLightRemoveBy).click();
        driver.findElement(this.boltTshirtRemoveBy).click();
        driver.findElement(this.fleeceJacketRemoveBy).click();
        driver.findElement(this.onesieRemoveBy).click();
        driver.findElement(this.testTshirtRemoveBy).click();

        // check if cart is empty
        List<WebElement> listCartItemsDel;
        listCartItemsDel = driver.findElements(cartItemsBy);
        return ("Elements in cart: " + listCartItemsDel.size());
    }

    public int countItemsInCart(WebDriver driver) {
        // count Cart Items
        List<WebElement> listCartItems;
        listCartItems = driver.findElements(cartItemsBy);
        return listCartItems.size();
    }

    public void btnCheckout(WebDriver driver) {
        driver.findElement(btnCheckoutBy).click();
    }

    public void openItemByTitle(WebDriver driver, int ItemNo) {
        switch (ItemNo) {
            case 0:
                driver.findElement(this.bikeLightTitleBy).click();
                break;
            case 1:
                driver.findElement(this.boltTshirtTitleBy).click();
                break;
            case 2:
                driver.findElement(this.onesieTitleBy).click();
                break;
            case 3:
                driver.findElement(this.testTshirtTitleBy).click();
                break;
            case 4:
                driver.findElement(this.backPackTitleBy).click();
                break;
            case 5:
                driver.findElement(this.fleeceJacketTitleBy).click();
                break;
        }
    }
}