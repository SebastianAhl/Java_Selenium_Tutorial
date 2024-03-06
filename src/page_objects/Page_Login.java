package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Login {
    

    // username input
    private By userNameBy = By.id("user-name");

    // password input
    private By passwordBy = By.id("password");

    // login button
    private By btnLoginBy = By.id("login-button");

    // error message
    private By btnError = By.cssSelector("h3[data-test='error']");



    public void login(WebDriver driver, String username, String password) {
        driver.findElement(this.userNameBy).sendKeys(username);
        driver.findElement(this.passwordBy).sendKeys(password);
        driver.findElement(this.btnLoginBy).click();

    }

    public String returnError(WebDriver driver){
        return  driver.findElement(this.btnError).getText();
    }

    public void deleteInput(WebDriver driver){
        driver.findElement(this.userNameBy).clear();
        driver.findElement(this.passwordBy).clear();
    }
}