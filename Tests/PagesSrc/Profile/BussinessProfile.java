package PagesSrc.Profile;

import PagesSrc.LoginTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Profile.Bussiness_Profile;

import java.io.IOException;

/**
 * Created by AKSHAY on 28/03/2017.
 */
public class BussinessProfile

{
    WebDriver driver;
    @BeforeClass
    public void loadDriver()
    {
        System.setProperty("webdriver.chrome.driver","d/chromedriver.exe");
        driver=new ChromeDriver();

    }



    @Test
    public void businessTest()
        {


            Bussiness_Profile bp=new Bussiness_Profile(driver);

            bp.ClickBusinessProfile();
            bp.setBusbnessName("fdg");
            bp.setOwnername("usj");
            bp.setNOOf_Vachel("12");
            bp.setAboutBusiness("hfashg");
            bp.setState("Maharachtra");
            bp.setcity("pune");
            bp.ClickonSave();

        }




}
