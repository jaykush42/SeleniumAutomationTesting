package Pages;

import Browser.browser;
import Locators.RegisterPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class RegisterPage extends browser {
    
    public static void input(String text, String value)
    {
        try {
        List<WebElement> inputs = RegisterPageObjects.getInputs();
        
        for(WebElement input: inputs)
        {
            if(Objects.requireNonNull(input.getAttribute("placeholder")).contains(text) || input.getText().contains(text) || Objects.requireNonNull(input.getAttribute("value")).contains(text))
                if (value.equalsIgnoreCase("click"))
                { input.click();
//                    wait.until(ExpectedConditions.visibilityOf(RegisterPageObjects.getEligibilityMsg()));
//                    System.out.println(RegisterPageObjects.getEligibilityMsg().getText());

                }
                else
                input.sendKeys(value);

                
        }
    } catch (Exception e) {
            System.out.println("Error while giving Input" + e);
        }
    }

    public static void printEligibilityMsg(){
        System.out.println(RegisterPageObjects.getEligibilityMsg().getText());
    }
    
}
