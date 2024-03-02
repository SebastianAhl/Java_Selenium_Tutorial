package classes;

import org.openqa.selenium.WebDriver;

public class Test_Classes {
    public void check_url(WebDriver driver, String address){
        // address = this.address;

        if (!driver.getCurrentUrl().equals(address)) {
            throw new IllegalStateException("This is not the Login Page," +
                  " current page is: " + driver.getCurrentUrl());
        }
    } 
}
