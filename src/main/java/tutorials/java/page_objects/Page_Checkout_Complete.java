// Author:          Sebastian.Ahl@tewiz.de
// Description:     Page object for the Checkout Complete Page

package tutorials.java.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Checkout_Complete {
    // Button Back Home
    private By btnBackHomeBy = By.xpath("//*[@id=\"back-to-products\"]");

    // Out Thank you
    private By outThankYouBy = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");

    // Out Info Text
    private By outInfoTextBy = By.xpath("//*[@id=\"checkout_complete_container\"]/div");
    


    

    public void btnBackHome(WebDriver driver){
        driver.findElement(this.btnBackHomeBy).click();
    }

    public String getThankYou(WebDriver driver){
        return driver.findElement(this.outThankYouBy).getText();
    }

    public String getInfoText(WebDriver driver){
        return driver.findElement(this.outInfoTextBy).getText();
    }
}