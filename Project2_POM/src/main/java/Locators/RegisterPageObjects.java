package Locators;

import Browser.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPageObjects extends browser {
    static By inputElement = By.tagName("Input");
    static By eligibilityMsg = By.id("check_availability");
    public static List<WebElement> getInputs(){
        return driver.findElements(inputElement);
    }

    public static WebElement getEligibilityMsg(){
        return driver.findElement(eligibilityMsg);
    }


}
