package PagesSrc;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pages.Signup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by AKSHAY on 3/16/2017.
 */
public class SignupTest {

    WebDriver driver;

    @BeforeClass
    public void signup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.0.55:8006");

    }

    @Test(dataProvider = "SignUp_Input")
    public void Signupdata(String First_Name, String LastName, String ContactNo, String EmailId, String
            Password, String Re_Password/*, String Expeted, String Xpath*/) {

        try {
            Signup signup = new Signup(driver);
            signup.clicksignumlink();
            signup.setFirst_NM(First_Name);
            signup.setLastNM(LastName);
            signup.setCont_No(ContactNo);
            signup.setEmaild(EmailId);
            signup.setPassword(Password);
            signup.setConfir_Password(Re_Password);
            signup.CheckBox_terms();
            signup.clcikRegistrationBtn();

        } catch (Throwable e) {
            System.out.println(e);
        }


    }

    @DataProvider

    public Object[][] SignUp_Input() throws IOException

    {
        FileInputStream fis = new FileInputStream("D:\\PROJECT\\wadap\\ExcelSheet\\Signup.xls");

        HSSFWorkbook Workbook = new HSSFWorkbook(fis);
        HSSFSheet WorkSheet = Workbook.getSheet("Signup");

        int rowCount = WorkSheet.getPhysicalNumberOfRows();
        String[][] data = new String[rowCount - 1][5];
        for (int i = 1; i < rowCount; i++)

        {
            HSSFRow row=WorkSheet.getRow(0);
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
/*
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
            }*/
        }


        return data;
    }


}
