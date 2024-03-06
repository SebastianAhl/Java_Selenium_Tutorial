package page_objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Checkout_Step_One {
    // Input First Name
    private By firstNameBy = By.id("first-name");

    // Input Last Name
    private By lastNameBy = By.id("last-name");

    // Input Zip/Postal Code
    private By zipPostalCodeBy = By.id("postal-code");

    // Button Continue
    private By btnContinueBy = By.id("continue");

    // Button Cancel
    private By btnCancelBy = By.id("cancel");

    // Output Error
    private By outErrorBy = By.id("cancel");



    

    public void addFirstName(WebDriver driver, String fName){
        driver.findElement(this.firstNameBy).sendKeys(fName);
    }

    public void addLastName(WebDriver driver, String lName){
        driver.findElement(this.lastNameBy).sendKeys(lName);
    }

    public void addZipPostalCode(WebDriver driver, String zipPostal){
        driver.findElement(this.zipPostalCodeBy).sendKeys(zipPostal); 
    }

    public String getErrorMsg(WebDriver driver){
        // Error: First Name is required
        // Error: Last Name is required
        // Error: Postal Code is required
        return driver.findElement(this.outErrorBy).getText();
    }

    public void btnContinue(WebDriver driver){
        driver.findElement(this.btnContinueBy).click();
    }

    public void btnCancel(WebDriver driver){
        driver.findElement(this.btnCancelBy).click();
    }

}