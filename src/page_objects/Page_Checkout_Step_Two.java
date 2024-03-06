package page_objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Checkout_Step_Two {
    // Button Finish
    private By btnFinishBy = By.id("finish");

    // Button Cancel
    private By btnCancelBy = By.id("cancel");

    // Out Payment Information
    private By selPaymentInfoBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[2]");
    // private By selPaymentInfoBy = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[2]null");

    // Out Shipping Information
    private By selShippingInformationBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[4]");
    // private By selShippingInformationBy = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[4]");

    // Out Item Total
    private By calcItemTotalBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[6]");
    // private By calcItemTotalBy = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[6]");
    
    // Out Tax
    private By calcTaxBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[7]");
    // private By calcTaxBy = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[7]");
    
    // Out Total
    private By calcTotalBy = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[8]");
    // private By calcTotalBy = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]");


    
    public void btnFinish(WebDriver driver){
        driver.findElement(btnFinishBy).click();
    }
    
    public void btnCancel(WebDriver driver){
        driver.findElement(btnCancelBy).click();
    }

    public String getPaymentInfo(WebDriver driver){
        return driver.findElement(selPaymentInfoBy).getText();
    }

    public String getShippingInfo(WebDriver driver){
        return driver.findElement(selShippingInformationBy).getText();
    }

    public String getItemTotal(WebDriver driver){
        return driver.findElement(calcItemTotalBy).getText();
    }

    public String getTax(WebDriver driver){
        return driver.findElement(calcTaxBy).getText();
    }

    public String getTotal(WebDriver driver){
        return driver.findElement(calcTotalBy).getText();
    }
}