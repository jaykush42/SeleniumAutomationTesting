package Pages;

import Browser.browser;
import Locators.HomePageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends browser {
    HomePageObjects homePageObjects;
    public HomePage(){
        this.homePageObjects = new HomePageObjects();
    }
    public void click(String text){

        try {
            wait.until(ExpectedConditions.visibilityOf(homePageObjects.logo));
            List<WebElement>  links = homePageObjects.links;
            for(WebElement link: links)
            {
               if(link.getText().equalsIgnoreCase(text))
               {link.click();
               break;
               }

            }
        }
        catch (Exception e)
        {
            System.out.println("Error while clicking"+ e);
        }
    }


}
