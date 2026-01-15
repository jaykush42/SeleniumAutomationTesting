package WindowsHandle;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowsHandle {

    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.rediff.com/");

        Thread.sleep(2000);

        WebElement createAccount = driver.findElement(By.xpath("//a[text()=\"Create Account\"]"));

        createAccount.click();

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()='terms and conditions']")).click();

        Thread.sleep(1000);

        String parentWindow = driver.getWindowHandle();

        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            if (!parentWindow.equals(window)) {
                driver.switchTo().window(window);
                driver.findElement(By.xpath("//input[@value=\"OK\"]")).click();
                break;
            }
        }

        Thread.sleep(1000);

        driver.switchTo().window(parentWindow);

        Thread.sleep(1000);

        js.executeScript("window.scrollTo(0,0)");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[text()='Rediff Home']")).click();

        driver.close();

    }
}
