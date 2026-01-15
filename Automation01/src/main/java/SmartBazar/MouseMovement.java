package SmartBazar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class MouseMovement {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.smartbazaar.co.uk/");

        driver.findElement(By.xpath("(//div[@class='brave_popup__close__button'])[1]")).click();

        Thread.sleep(4000);

        WebElement loginButton = driver.findElement(By.xpath("//a[@class='account-icon dropdown-toggle']"));

        Actions actions = new Actions(driver);

       // loginButton.click();
        actions.moveToElement(loginButton).click().build().perform();

        Thread.sleep(2000);

        WebElement subMenu = driver.findElement(By.xpath("//a[text()='Login / Register']"));

        actions.moveByOffset(0, 60).click().perform(); // Moves 90px downward and clicks

      //  subMenu.click();

        Thread.sleep(5000);

       driver.quit();
    }
}
