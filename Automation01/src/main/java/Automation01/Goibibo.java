package Automation01;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Goibibo {

    public static void main(String[] args) throws Exception{

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.goibibo.com/");

        Thread.sleep(2000);

        // Close login popup if it appears
        try {
            WebElement closePopup = driver.findElement(By.xpath("//span[@class='logSprite icClose']"));
            closePopup.click();
            Thread.sleep(1000);
            WebElement secondPopUp = driver.findElement(By.xpath("//div[@data-id=\"dweb_pip_id\"]/p"));
            secondPopUp.click();

            Thread.sleep(1000);

            WebElement thirdPopUp = driver.findElement(By.xpath("//div[@class='tooltipInfo']"));
            if(thirdPopUp.isDisplayed())
            {
               // System.out.println("Clicking outside");
                driver.findElement(By.xpath("//div[@id='root']")).click();
            }
        } catch (Exception ignored) {
            // popup not shown
        }



        // ---------------- FROM CITY ----------------
       // System.out.println("Selecting from city");
        Thread.sleep(1000);
        WebElement fromCity = driver.findElement(By.xpath("//input[@id='fromCity']"));
        fromCity.click();
        WebElement fromCityInput = driver.findElement(By.xpath("//input[@placeHolder='From']"));

        Thread.sleep(1000);
        fromCityInput.sendKeys("India");
        Thread.sleep(1000);
       // System.out.println(fromCityInput.getAttribute("value"));
        Thread.sleep(1000);

        selectCityFromSuggestion(driver, "CCU");

        // ---------------- TO CITY ----------------
        WebElement toCity = driver.findElement(By.xpath("//input[@id='toCity']"));
        toCity.click();
        toCity.sendKeys("India");
        Thread.sleep(1000);

        selectCityFromSuggestion(driver, "BOM");

        driver.quit();
    }

    // Reusable method to select city by city code
    public static void selectCityFromSuggestion(WebDriver driver, String enterCityCode) throws Exception {

        List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
        //System.out.println(suggestions.size());
        for (WebElement city : suggestions) {
            WebElement cityCode = city.findElement(By.tagName("span"));
           // System.out.println(cityCode.getText());
            if (cityCode.getText().equals(enterCityCode)) {
                city.click();
                Thread.sleep(1000);
                break;
            }
        }
    }
}
