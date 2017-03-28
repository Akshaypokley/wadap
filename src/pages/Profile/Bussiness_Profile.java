package pages.Profile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by AKSHAY on 28/03/2017.
 */
public class Bussiness_Profile {

    WebDriver driver;

    @FindBy(xpath = "")
    WebElement Logo;


    @FindBy(xpath = "//div[8]/a[@href='/Profile/BusinessProfile']")
    WebElement BusinessProfile;

    @FindBy(xpath = "//div[2]//div[3]/input")
    WebElement BusbnessName;

    @FindBy(xpath = "//div[2]//div[5]/input")
    WebElement Ownername;

    @FindBy(xpath = "//div[3]//div[3]/input")
    WebElement NOOf_Vachel;

    @FindBy(xpath = "//div[3]//div[5]/textarea ")
    WebElement AboutBusiness;

    @FindBy(xpath = "//div[4]//div[3]//option")
    WebElement State;

    @FindBy(xpath = "//div[4]//div[5]/div//input")
    WebElement city;

    @FindBy(xpath = "")
    WebElement Save;


    Bussiness_Profile(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
      if(!Logo.isDisplayed())
          throw new IllegalStateException("This is not bussiness Profile page");
    }

    public void ClickBusinessProfile()

    {
        BusinessProfile.click();
    }

    public void setBusbnessName(String Buss_Name)

    {
        BusbnessName.sendKeys(Buss_Name);
    }

    public void setOwnername(String Owner_name)

    {
        Ownername.sendKeys(Owner_name);
    }

    public void setNOOf_Vachel(String No_of_Va)

    {
        NOOf_Vachel.sendKeys(No_of_Va);
    }

    public void setAboutBusiness(String AboutBusin)

    {
            AboutBusiness.sendKeys(AboutBusin);

    }

    public void setState(String States)
    {
        Select combo = new Select(State);
        combo.selectByVisibleText(States);
    }

    public void setcity(String Cityy)
    {
        city.sendKeys(Cityy);
    }

    public void ClickonSave()
    {
        Save.click();
    }
}
