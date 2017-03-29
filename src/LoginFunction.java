import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Login;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by AKSHAY on 29/03/2017.
 */
public class LoginFunction {

    public boolean isAlreadyLogIn = false;
    WebDriver driver;

    /*@BeforeClass
    public void loadDriver()
    {
        System.setProperty("webdriver.chrome.driver","d/chromedriver.exe");
        driver=new ChromeDriver();
    }

    */
   /* @Test(dataProvider = "UserInput")*/
    public void logIn(String userID, String password)

    {
        if (!isAlreadyLogIn) {

            Login login = new Login(driver);
            login.setUserName(userID);
            login.setPassword(password);
            login.ClickLogin_Button();
            isAlreadyLogIn = true;
        }
    }

 /*   @DataProvider*/
    public Object[][] UserInput() throws IOException {
        FileInputStream fis = new FileInputStream("ExcelSheet/LoginFunction.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(fis);

        HSSFSheet sheet = workbook.getSheet("LoginFunction");
        int rowCount = sheet.getPhysicalNumberOfRows();

        String[][] data = new String[rowCount - 1][2];

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
        }
        return data;
    }

}
