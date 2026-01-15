package Pages;

import Browser.browser;
import Locators.HomePageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends browser {

    public static void click(String text){

        try {
            wait.until(ExpectedConditions.visibilityOf(HomePageObjects.getLogo()));
            List<WebElement>  links = HomePageObjects.links();
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
