package Pages;

import Locators.HomePageObjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static Browser.Browser.driver;
import static Browser.Browser.wait;

public class HomePage {
    HomePageObjects homePageObjects = new HomePageObjects();
   public HomePage(){
       homePageObjects = new HomePageObjects();
   }
    public String clickLoginButton() {

        wait.until(ExpectedConditions.elementToBeClickable(
                homePageObjects.getLoginButton()));
        homePageObjects.getLoginButton().click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String text = alert.getText();
       // System.out.println(text);
        alert.accept();

        return text;
    }


    public void clickForgortButton(){
       wait.until(ExpectedConditions.elementToBeClickable(homePageObjects.getForgotButtonElement()));
       homePageObjects.getForgotButtonElement().click();
    }


}
