package Locators;

import Browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageObjects extends Browser {
   WebElement nextButton = driver.findElement(By.tagName("button"));

   public WebElement getNextButton()
   {
       return nextButton;
   }

}
