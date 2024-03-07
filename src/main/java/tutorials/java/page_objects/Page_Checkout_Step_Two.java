// Author:          Sebastian.Ahl@tewiz.de
// Description:     Page object for the Checkout Step Two Page

package tutorials.java.page_objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Checkout_Step_Two {
    // Button Finish
    private By btnFinishBy = By.id("finish");

    // Button Cancel
    private By btnCancelBy = By.id("cancel");

    // Out Payment Information
    private By selPaymentInfoBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[2]");

    // Out Shipping Information
    private By selShippingInformationBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[4]");

    // Out Item Total
    private By calcItemTotalBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[6]");
    
    // Out Tax
    private By calcTaxBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[7]");
    
    // Out Total
    private By calcTotalBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]");


    
    public void btnFinish(WebDriver driver){
        driver.findElement(this.btnFinishBy).click();
    }
    
    public void btnCancel(WebDriver driver){
        driver.findElement(this.btnCancelBy).click();
    }

    public String getPaymentInfo(WebDriver driver){
        return driver.findElement(this.selPaymentInfoBy).getText();
    }

    public String getShippingInfo(WebDriver driver){
        return driver.findElement(this.selShippingInformationBy).getText();
    }

    public String getItemTotal(WebDriver driver){
        return driver.findElement(this.calcItemTotalBy).getText();
    }

    public String getTax(WebDriver driver){
        return driver.findElement(this.calcTaxBy).getText();
    }

    public String getTotal(WebDriver driver){
        return driver.findElement(this.calcTotalBy).getText();
    }
}