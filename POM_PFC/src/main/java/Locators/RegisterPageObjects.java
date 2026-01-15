package Locators;

import Browser.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPageObjects extends browser {

    @FindAll(@FindBy(tagName = "Input"))
    List<WebElement> inputElement;

    @FindBy(xpath = "//div[@class=\"suggs-container\"]")
    WebElement messageElement;

    public RegisterPageObjects(){
        PageFactory.initElements(driver,this);
    }

    public  List<WebElement> getInputs(){
        return inputElement;
    }

    public WebElement getMessageElement() {
        return messageElement;
    }
}
