package Locators;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePageObjects extends Browser {
    WebElement loginButtonElement = driver.findElement(By.xpath("//button[@type='submit']"));
    WebElement forgotButtonElement = driver.findElement(By.xpath("//a[text()=\"Forgot password?\"]"));
    public WebElement getLoginButton(){
        return loginButtonElement;
    }

    public WebElement getForgotButtonElement(){
        return forgotButtonElement;
    }
}
