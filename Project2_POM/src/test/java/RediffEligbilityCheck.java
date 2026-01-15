import Browser.browser;
import Browser.utility;
import Pages.HomePage;
import Pages.RegisterPage;
import Screenshots.Capture;

public class RediffEligbilityCheck {
    public static void main(String[] args) throws Exception{
        String browserData = utility.properties("browser");
        browser.openBrowser(browserData);
        browser.navigate(utility.properties("title"));
        Capture.screenShot("HomePage");
        HomePage.click("Create Account");

        Capture.screenShot("BeforeFillingDetails");
        RegisterPage.input("full name", "Jay Prakash Kushwaha");
        RegisterPage.input("Rediffmail", "jay123");
        RegisterPage.input("Check availability", "click");
        Capture.screenShot("AfterEnteringDetails");
       RegisterPage.printEligibilityMsg();
       Thread.sleep(2000);
        browser.closeBrowser();
   }
}
