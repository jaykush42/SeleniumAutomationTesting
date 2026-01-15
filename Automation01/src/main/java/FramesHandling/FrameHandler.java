package FramesHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandler {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.demo.guru99.com/selenium/deprecated.html");

        Thread.sleep(5000);

        WebElement packagesFrame = driver.findElement(By.xpath("//frame[@name=\"packageListFrame\"]"));

        driver.switchTo().frame(packagesFrame);

        Thread.sleep(1000);

        WebElement firstLink = driver.findElement(By.xpath("//a[text()=\"com.thoughtworks.selenium\"]"));

        if(firstLink.isDisplayed())
            System.out.println(firstLink.getText());

        firstLink.click();

        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        driver.close();
    }
}
