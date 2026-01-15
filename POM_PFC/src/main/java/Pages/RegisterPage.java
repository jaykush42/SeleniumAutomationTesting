package Pages;

import Browser.browser;
import Locators.RegisterPageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

public class RegisterPage extends browser {
    RegisterPageObjects registerPageObjects;
    public RegisterPage(){
        this.registerPageObjects = new RegisterPageObjects();
    }

    public void input(String text, String value)
    {
        try {
        List<WebElement> inputs = registerPageObjects.getInputs();

        for(WebElement input: inputs)
        {
            if(Objects.requireNonNull(input.getAttribute("placeholder")).contains(text) || input.getText().contains(text) || Objects.requireNonNull(input.getAttribute("value")).contains(text))
                if (value.equalsIgnoreCase("click"))
                    input.click();
                else
                    input.sendKeys(value);

        }
    } catch (Exception e) {
            System.out.println("Error while giving Input" + e);
        }
    }

    public void printMessage(){
        wait.until(ExpectedConditions.visibilityOf(registerPageObjects.getMessageElement()));
        System.out.println(registerPageObjects.getMessageElement().getText());
    }

}
