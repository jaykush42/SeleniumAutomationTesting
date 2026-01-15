package Locators;


import Browser.browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageObjects extends browser {

    static By logo = By.className("logo");
    static By links = By.xpath("//a");

    public static WebElement getLogo(){
        return driver.findElement(logo);
    }

    public static List<WebElement> links()
    {
        return driver.findElements(links);
    }

}
