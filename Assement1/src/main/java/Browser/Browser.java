package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public static void openBroswer(String browser){
        try{
            if(browser.equalsIgnoreCase("Chrome"))
                driver = new ChromeDriver();
            else if(browser.equalsIgnoreCase("FireFox"))
                driver = new FirefoxDriver();
            else if(browser.equalsIgnoreCase("Edge"))
                driver = new EdgeDriver();
            else
                System.out.println("Wrong choice");
        } catch (Exception e) {
            System.out.println("Error while opening browser");
        }
    }

    public static void openUrl(String url){
        try{
            driver.get(url);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        catch (Exception e)
        {
            System.out.println("Error while opening url");
        }
    }
    public static void closeBrowser(){
        try{
            driver.close();
        } catch (Exception e) {
            System.out.println("Error while closing the browser");
        }
    }
}
