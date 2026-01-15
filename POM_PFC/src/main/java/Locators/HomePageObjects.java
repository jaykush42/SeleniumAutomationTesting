package Locators;


import Browser.browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageObjects extends browser {

    public HomePageObjects(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "logo")
    public WebElement logo;

    @FindAll(@FindBy(xpath = "//a"))
   public List<WebElement> links;

}
