package Rediff;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Username {

    public static void main(String[] args) throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.rediff.com/");

        Thread.sleep(2000);

        WebElement createAccount = driver.findElement(By.xpath("//a[text()=\"Create Account\"]"));

        createAccount.click();

        Thread.sleep(2000);

        WebElement fullNameInput = driver.findElement(By.xpath("//input[@placeholder=\"Enter your full name\"]"));

        fullNameInput.sendKeys("Jay Prakash Kushwaha");

        WebElement id = driver.findElement(By.xpath("//input[@placeholder=\"Enter Rediffmail ID\"]"));

        id.sendKeys("jay675667");

        WebElement checkButton = driver.findElement(By.xpath("//input[@value=\"Check availability\"]"));

        checkButton.click();

        Thread.sleep(1000);

        WebElement message = driver.findElement(By.xpath("//div[@class=\"suggs-container\"]/div"));

        System.out.println(message.getText());

        driver.close();

    }
}
