package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class Page_Items {
    // Item
    // Title
    private By itemTitleBy = By.cssSelector(".inventory_details_name.large_size");
    // Description
    private By itemDescBy = By.cssSelector(".inventory_details_desc.large_size");
    // Image
    private By itemImgBy = By.className("inventory_details_img");
    // price
    private By itemPriceBy = By.className("inventory_details_price");


    // Button open cart
    protected By buttonOpenCartBy = By.className("shopping_cart_link");

    // Button Back to products
    protected By backToProductsBy = By.xpath("//*[@id='back-to-products']");

    // Add to cart
    private By item0AddToCartBy = By.id("add-to-cart-sauce-labs-bike-light");
    private By item1AddToCartBy = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By item2AddToCartBy = By.id("add-to-cart-sauce-labs-onesie");
    private By item3AddToCartBy = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");
    private By item4AddToCartBy = By.id("add-to-cart-sauce-labs-backpack");
    private By item5AddToCartBy = By.id("add-to-cart-sauce-labs-fleece-jacket");



    private String values[] = {"", "", "", ""};


    
    public String[] returnValues(WebDriver driver) {
        // values[0] = title.getText();
        values[0] = driver.findElement(itemTitleBy).getText();

        // values[1] = description.getText();
        values[1] = driver.findElement(itemDescBy).getText();

        // Image URL
        values[2] = driver.findElement(itemImgBy).getAttribute("src");

        // Item Price
        values[3] = driver.findElement(itemPriceBy).getText();

        return values;
    }

    public void addCartItem(WebDriver driver, int item){
        switch (item) {
            case 0:
                driver.findElement(item0AddToCartBy).click();
                break;
            case 1:
                driver.findElement(item1AddToCartBy).click();
                break;               
            case 2:
                driver.findElement(item2AddToCartBy).click();
                break;        
            case 3:
                driver.findElement(item3AddToCartBy).click();
                break;        
            case 4:
                driver.findElement(item4AddToCartBy).click();
                break;        
            case 5:
                driver.findElement(item5AddToCartBy).click();
                break;        
        }
    }

    public void backToProducts(WebDriver driver){
        driver.findElement(backToProductsBy).click();
    }
}