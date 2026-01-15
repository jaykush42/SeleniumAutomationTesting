package Screenshots;

import Browser.browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class Capture extends browser {

    public static void screenShot(String name) throws Exception {

        try {
            TakesScreenshot shot = (TakesScreenshot)driver;
            File source = shot.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir") + "//target//ScreenShots//"+ name + ".png";
            File destination = new File(path);
            FileUtils.copyFile(source,destination);
        }
        catch (Exception e){
            System.out.println("Error while Taking Screenshot");
        }
    }
}
