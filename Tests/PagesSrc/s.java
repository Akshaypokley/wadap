package PagesSrc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Signup;

import java.util.concurrent.TimeUnit;

/**
 * Created by AKSHAY on 3/17/2017.
 */
public class s {


    WebDriver driver;

    @BeforeClass
    public void signup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.0.55:8006");

    }
    @Test
    public void Signupdata()
    {
        Signup signup = new Signup(driver);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        signup.clicksignumlink();

        signup.setFirst_NM("ds");
        signup.setLastNM("dsd");
        signup.setCont_No("888888");
        signup.setEmaild("sd@d.d");
        signup.setPassword("99");
        signup.setConfir_Password("99");
        signup.CheckBox_terms();
        signup.clcikRegistrationBtn();
    }
}
