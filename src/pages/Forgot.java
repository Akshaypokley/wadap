package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by AKSHAY on 3/21/2017.
 */
public class Forgot {

    WebDriver driver;

    @FindBy(xpath = "")
    WebElement Logo;

    @FindBy(xpath = "")
    WebElement forgotlink;

    @FindBy(xpath ="" )
    WebElement EmailBox;

    @FindBy(xpath = "")
    WebElement sendButtonl;


Forgot (WebDriver driver)
{
    this.driver=driver;
    PageFactory.initElements(driver,this);
    if(!Logo.isDisplayed())
        throw new IllegalStateException("This not Forgot page");
}


}
