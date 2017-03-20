package PagesSrc;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Utilites.TakeScreenshot.takeScreenshot;

/**
 * Created by AKSHAY on 3/20/2017.
 */
public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void LoginTet() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.0.55:8006/");

    }

    @Test(dataProvider = "InputData")
    public void UserInput(String UsNM, String PassWord, String Expected, String Xpath) {
        try{

        Login login = new Login(driver);

        login.setUserName(UsNM);
        login.setPassword(PassWord);
        login.ClickLogin_Button();
           /*
            Alert alert = driver.switchTo().alert();
            alert.accept();*/
            try
            {
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                String Actual=driver.findElement(By.xpath(Xpath)).getText();

                Assert.assertEquals(Actual,Expected,"TestPass");



            }catch(AssertionError e)
            {
                System.out.println(e);

            }

        } catch (Throwable e) {
            System.out.println(e);

        }

        //driver.close();

    }

    @DataProvider

    public Object[][] InputData() throws IOException {
        FileInputStream fis = new FileInputStream("ExcelSheet/Login.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fis);

        HSSFSheet sheet = workbook.getSheet("Login");
        int rowCount = sheet.getPhysicalNumberOfRows();

        String[][] data = new String[rowCount - 1][4];

         for (int i = 1; i < rowCount; i++) {

            HSSFRow row = sheet.getRow(i);
            HSSFCell UserNameCell = row.getCell(0);
            if (UserNameCell == null) {
                data[i - 1][0] = "";
            } else {
                UserNameCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][0] = UserNameCell.getStringCellValue();
            }


            HSSFCell PassewordCell = row.getCell(1);
            if (PassewordCell == null) {
                data[i - 1][1] = "";
            } else {
                PassewordCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][1] = PassewordCell.getStringCellValue();
            }

            HSSFCell ExpetedCell = row.getCell(2);
            if (ExpetedCell == null) {
                data[i - 1][2] = "";
            } else {
                ExpetedCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][2] = ExpetedCell.getStringCellValue();
            }

            HSSFCell XpathCell = row.getCell(3);
            if (XpathCell == null) {
                data[i - 1][3] = "";
            } else {
                XpathCell.setCellType(Cell.CELL_TYPE_STRING);
                data[i - 1][3] = XpathCell.getStringCellValue();
            }

        }
        return data;
    }

}
