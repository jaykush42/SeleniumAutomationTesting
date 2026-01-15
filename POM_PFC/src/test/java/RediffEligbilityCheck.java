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

        HomePage homePage = new HomePage();
        homePage.click("Create Account");

        Capture.screenShot("BeforeFillingDetails");

        RegisterPage registerPage = new RegisterPage();
        registerPage.input("full name", "Jay Prakash Kushwaha");
        registerPage.input("Rediffmail", "jay");
        registerPage.input("Check availability", "click");
        registerPage.printMessage();
        Capture.screenShot("AfterEnteringDetails");

       Thread.sleep(2000);
        browser.closeBrowser();
   }
}
