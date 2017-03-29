package PagesSrc.Utilites;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * Created by AKSHAY on 3/18/2017.
 */
public class initExtentReport{

        static ExtentReports extent;
        public static ExtentReports init()
        {
            extent = new ExtentReports("D:\\PROJECT\\wadap\\Extent_Report\\reports.html",false/*, NetworkMode.OFFLINE*/);

            return extent;
        }
}
