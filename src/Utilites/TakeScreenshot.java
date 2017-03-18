package Utilites;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AKSHAY on 3/18/2017.
 */
public class TakeScreenshot {

    public static String takeScreenshot(WebDriver driver) throws IOException {
        String imageName="";
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            SimpleDateFormat sd = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
            String DateStr = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
             imageName = "Login" + DateStr + ".png";
            String imagePath = "Extent_Report/Signup/" + imageName;
            FileUtils.copyFile(scrFile, new File(imagePath));
        }catch(Throwable t)
            {
                System.out.println(t);
            }

        return imageName;

    }
}
