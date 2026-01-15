package AlertHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandler {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(2000);

        WebElement alert1Button = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
        alert1Button.click();

        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());

        alert1.accept();

        Thread.sleep(1000);

        WebElement alert2Button = driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]"));
        alert2Button.click();

        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());

        alert2.dismiss();

        Thread.sleep(1000);

        WebElement alert3Button = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        alert3Button.click();

        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys("Jay");
        alert3.accept();

        Thread.sleep(2000);

        driver.close();
}
}
