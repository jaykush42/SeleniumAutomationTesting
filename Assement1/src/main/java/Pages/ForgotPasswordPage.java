package Pages;

import Locators.ForgotPasswordPageObjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Browser.Browser.driver;
import static Browser.Browser.wait;

public class ForgotPasswordPage {
    ForgotPasswordPageObjects forgotPasswordPageObjects;
    public ForgotPasswordPage(){
        forgotPasswordPageObjects = new ForgotPasswordPageObjects();

    }

    public String clickNextButton(){
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordPageObjects.getNextButton()));
        forgotPasswordPageObjects.getNextButton().click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();

        String text = alert.getText();

        alert.accept();

        return text;
    }
}
