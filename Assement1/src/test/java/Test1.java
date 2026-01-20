import Browser.Browser;
import Pages.ForgotPasswordPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 {

    @Test
    public void text() {
            String url = "https://mail.rediff.com/cgi-bin/login.cgi";
            Browser.openBroswer("Chrome");
            Browser.openUrl(url);
            HomePage homePage = new HomePage();

        String LoginText = homePage.clickLoginButton();
        String expectedText1 = "Please enter a valid user name";

         Assert.assertEquals(LoginText,expectedText1);

         homePage.clickForgortButton();

         ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
            String forgotText = forgotPasswordPage.clickNextButton();
            String expectedText2 = "Please enter your email ID";
            Assert.assertEquals(forgotText,expectedText2);
            Browser.closeBrowser();
        }

}
