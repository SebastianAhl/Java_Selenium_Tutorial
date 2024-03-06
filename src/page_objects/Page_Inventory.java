package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class Page_Inventory {
    

    // Sauce Labs Backpack 
    // title
    private By item4TitleBy = By.id("item_4_title_link");
    // image
    private By item4ImgBy = By.id("item_4_img_link");
    // Add to cart
    private By item4AddToCartBy = By.id("add-to-cart-sauce-labs-backpack");

 
    // Sauce Labs Bike Light 
    // title
    private By item0TitleBy = By.id("item_0_title_link");
    // image
    private By item0ImgBy = By.id("item_0_img_link");
    // Add to cart
    private By item0AddToCartBy = By.id("add-to-cart-sauce-labs-bike-light");


    // Sauce Labs Bolt T-Shirt 
    // title
    private By item1TitleBy = By.id("item_1_title_link");
    // image
    private By item1ImgBy = By.id("item_1_img_link");
    // Add to cart
    private By item1AddToCartBy = By.id("add-to-cart-sauce-labs-bolt-t-shirt");


    // Sauce Labs Labs Fleece Jacket 
    // title
    private By item5TitleBy = By.id("item_5_title_link");
    // image
    private By item5ImgBy = By.id("item_5_img_link");
    // Add to cart
    private By item5AddToCartBy = By.id("add-to-cart-sauce-labs-fleece-jacket");


    // Sauce Labs Onesie 
    // title
    private By item2TitleBy = By.id("item_2_title_link");
    // image
    private By item2ImgBy = By.id("item_2_img_link");
    // Add to cart
    private By item2AddToCartBy = By.id("add-to-cart-sauce-labs-onesie");


    // Sauce Labs Test T-Shirt 
    // title
    private By item3TitleBy = By.id("item_3_title_link");
    // image
    private By item3ImgBy = By.id("item_3_img_link");
    // Add to cart
    private By item3AddToCartBy = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");


    // Button open cart
    private By buttonOpenCartBy = By.className("shopping_cart_link");


    // menu Sort Items
    // open
    private By sortItemsBy = By.className("product_sort_container");
    //active option
    private By activeOptionBy = By.className("active_option");



    public String sortItems(WebDriver driver, int index){

        WebElement selectOption = driver.findElement(this.sortItemsBy);
        Select select = new Select(selectOption);

        select.selectByIndex(index);

        return driver.findElement(this.activeOptionBy).getText();
    }

    public void addalltocart(WebDriver driver) {
        driver.findElement(this.item4AddToCartBy).click();
        driver.findElement(this.item0AddToCartBy).click();
        driver.findElement(this.item1AddToCartBy).click();
        driver.findElement(this.item5AddToCartBy).click();
        driver.findElement(this.item2AddToCartBy).click();
        driver.findElement(this.item3AddToCartBy).click();
    }

    public void openCart(WebDriver driver) {
        driver.findElement(this.buttonOpenCartBy).click();
    }

    public void openItemByTitle(WebDriver driver, int ItemNo){
        switch (ItemNo) {
            case 0:
                driver.findElement(this.item0TitleBy).click();           
                break;
            case 1:
                driver.findElement(this.item1TitleBy).click();
                break;
            case 2:
                driver.findElement(this.item2TitleBy).click();
                break;
            case 3:
                driver.findElement(this.item3TitleBy).click();
                break;
            case 4:
                driver.findElement(this.item4TitleBy).click();
                break;
            case 5:
                driver.findElement(this.item5TitleBy).click();
                break;
        }

    }

    public void openItemByImg(WebDriver driver, int ItemNo){
        switch (ItemNo) {
            case 0:
                driver.findElement(this.item0ImgBy).click();           
                break;
            case 1:
                driver.findElement(this.item1ImgBy).click();
                break;
            case 2:
                driver.findElement(this.item2ImgBy).click();
                break;
            case 3:
                driver.findElement(this.item3ImgBy).click();
                break;
            case 4:
                driver.findElement(this.item4ImgBy).click();
                break;
            case 5:
                driver.findElement(this.item5ImgBy).click();
                break;
        }
    }


}
