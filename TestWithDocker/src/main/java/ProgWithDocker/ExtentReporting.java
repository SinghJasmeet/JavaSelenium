package ProgWithDocker;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
    public static ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
//    public  ExtentTest test1,test2;

    public static void reporting() {

        htmlReporter = new ExtentSparkReporter("./target/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

    }

}
