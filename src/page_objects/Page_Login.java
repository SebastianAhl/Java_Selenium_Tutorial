package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page_Login {
    

    // username input
    private By usernameBy = By.id("user-name");

    // password input
    private By passwordBy = By.id("password");

    // login button
    private By loginbtnBy = By.id("login-button");

    // error message
    private By errorBtn = By.cssSelector("h3[data-test='error']");



    public void login(WebDriver driver, String username, String password) {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginbtnBy).click();

    }

    public String returnError(WebDriver driver){
        String ErrorMsg;
        ErrorMsg = driver.findElement(errorBtn).getText();

        return ErrorMsg;
    }

    public void deleteInput(WebDriver driver){
        driver.findElement(usernameBy).clear();
        driver.findElement(passwordBy).clear();
    }
}