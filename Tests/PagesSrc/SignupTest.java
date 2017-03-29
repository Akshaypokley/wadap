package PagesSrc;

import PagesSrc.Utilites.initExtentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pages.Signup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static PagesSrc.Utilites.TakeScreenshot.takeScreenshot;

/**
 * Created by AKSHAY on 3/16/2017.
 */
public class SignupTest {

    WebDriver driver;
    ExtentReports extent ;
    @BeforeMethod
    public void signup() {
        extent = initExtentReport.init();
        System.setProperty("webdriver.chrome.driver", "d/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.0.57:8018/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "SignUp_Input")
    public void Signupdata(String First_Name, String LastName, String ContactNo, String EmailId, String
            Password, String Re_Password, String Expeted, String Xpath) throws IOException {

        ExtentTest test = extent.startTest("Signup Test", "To Test Signup Button Fuctionality");

        try {
            Signup signup = new Signup(driver);

            test.log(LogStatus.INFO, "Signup Driver initialised");

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            signup.clicksignumlink();
            test.log(LogStatus.INFO, "Click On signup Link");
            signup.setFirst_NM(First_Name);
            test.log(LogStatus.INFO, "Provide Full Name");
            signup.setLastNM(LastName);
            test.log(LogStatus.INFO, "Provid user name");
            signup.setCont_No(ContactNo);
            test.log(LogStatus.INFO, "Provide Contact No");
            signup.setEmaild(EmailId);
            test.log(LogStatus.INFO, "Provide Email Id");
            signup.setPassword(Password);
            test.log(LogStatus.INFO, "Provide Password");
            signup.setConfir_Password(Re_Password);
            test.log(LogStatus.INFO, "Provide Re-Password");
            signup.CheckBox_terms();
            test.log(LogStatus.INFO, "Accept Terms And Condition");
            signup.clcikRegistrationBtn();
            test.log(LogStatus.INFO, "Click On Registration Button");
           /* Alert alert = driver.switchTo().alert();
            alert.accept();*/
            try
            {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                String Actual=driver.findElement(By.xpath(Xpath)).getText();

                Assert.assertEquals(Actual,Expeted,"TestPass");
                test.log(LogStatus.PASS, "Test Pass");

                test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));
            }catch(AssertionError e)
            {
               // System.out.println(e);
                test.log(LogStatus.FAIL, e);
                test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));
            }

        } catch (Throwable e) {
           // System.out.println(e);
            test.log(LogStatus.FAIL, e);
            test.log(LogStatus.INFO, "Snapshot below: " + test.addScreenCapture("./screenshots/"+takeScreenshot(driver)));

        }
        extent.endTest(test);
        extent.flush();
        driver.close();

    }

    @DataProvider

    public Object[][] SignUp_Input() throws IOException

    {
        FileInputStream fis = new FileInputStream("ExcelSheet/Signup.xls");

        HSSFWorkbook Workbook = new HSSFWorkbook(fis);
        HSSFSheet WorkSheet = Workbook.getSheet("Signup");

        int rowCount = WorkSheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][8];
        for (int i = 1; i < rowCount; i++)

        {
            HSSFRow row=WorkSheet.getRow(i);
            HSSFCell FirstNameCell=row.getCell(0);
            if(FirstNameCell==null)
            {
                data[i-1][0]="";
            }else{
                FirstNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][0]=FirstNameCell.getStringCellValue();
            }

            HSSFCell LastNameCell=row.getCell(1);
            if(LastNameCell==null)
            {
                data[i-1][1]="";
            }else {
                LastNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][1]=LastNameCell.getStringCellValue();
            }

            HSSFCell ContactNoCell =row.getCell(2);
            if(ContactNoCell==null)
            {
                data[i-1][2]="";
            }else
            {
                ContactNoCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][2]=ContactNoCell.getStringCellValue();
            }

            HSSFCell EmailIdCell=row.getCell(3);
            if(EmailIdCell==null)
            {
                data[i-1][3]="";
            }else
            {
                EmailIdCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][3]=EmailIdCell.getStringCellValue();
            }

            HSSFCell PasswordCell= row.getCell(4);
            if(PasswordCell==null)
            {
                data[i-1][4]="";
            }else
            {
                PasswordCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][4]=PasswordCell.getStringCellValue();
            }

            HSSFCell RePasswordCell= row.getCell(5);
            if(RePasswordCell==null)
            {
                data[i-1][5]="";
            }else
            {
                RePasswordCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][5]=RePasswordCell.getStringCellValue();
            }
            HSSFCell ExpaetedCell=row.getCell(6);
            if(ExpaetedCell==null)
            {
                data[i-1][6]="";
            }
            else
            {
                ExpaetedCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][6]=ExpaetedCell.getStringCellValue();
            }

            HSSFCell XpathCEll =row.getCell(7);
            if (XpathCEll==null)
            {
                data[i-1][7]="";
            }
            else
                {
                XpathCEll.setCellType(Cell.CELL_TYPE_STRING);
                data[i-1][7]=XpathCEll.getStringCellValue();
            }
        }


        return data;
    }


}
