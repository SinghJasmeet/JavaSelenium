package ProgWithDocker;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Category;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.xml.XmlSuite;

import java.awt.image.ColorConvertOp;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.time.Duration;

import static ProgWithDocker.ExtentReporting.*;
import static com.aventstack.extentreports.model.service.TestService.createTest;

public class Test2 {
//    ExtentSparkReporter htmlReport;
//    ExtentReports extent;/;p
    ;
    public ExtentTest test1;

   public static WebDriver driver = null;

@BeforeSuite
    public void setup(){

    reporting();
    driver = new FirefoxDriver();
    }
    @Test
    public void test1() throws IOException {
        driver.get("https://www.guru99.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String title = driver.getTitle();
        test1 = extent.createTest("Validating the title of the page after dynammic");
        test1.assignAuthor("Jasmeet Singh");
        test1.generateLog(Status.PASS,"Login successful");

        System.out.println(title);
        WebElement name = driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div/div[1]/div[1]/div[2]/div/div[2]/span[4]/a/img"));
        /**
         * Screenshot for particular elements
         */
        File srcFile = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
        File dest = new File("./target/" + "pic_"+System.currentTimeMillis()+".png");
        FileHandler.copy(srcFile, (dest));
        test1.addScreenCaptureFromPath(dest.getName());

    }
    @AfterSuite
    public void testClosure(){
    test1.info("Test complete");
    extent.flush();
    driver.quit();
    }
}
