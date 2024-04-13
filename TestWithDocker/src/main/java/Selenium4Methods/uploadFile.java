package Selenium4Methods;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;

import static ProgWithDocker.ExtentReporting.extent;
import static ProgWithDocker.ExtentReporting.reporting;

public class uploadFile {
    public static WebDriver driver= null;
    @BeforeSuite
    public void setup(){

        reporting();
        driver = new ChromeDriver();
    }
    public ExtentTest test1;
    @Test
    public void fileUploadTest(){
        test1 = extent.createTest("Starting the File upload test");
        test1.getExtent();
        test1.assignAuthor("Jasmeet Singh");
        test1.info("Entering the URL");
        driver.get("https://the-internet.herokuapp.com/upload");

        test1.info("Created the path for the file to be upload");
        File uploadFile = new File("src/main/resources/screenshots/nature.jpg");

        test1.info("Find the input file button");
        WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
        test1.info("Getting the file absolute path");
        fileInput.sendKeys(uploadFile.getAbsolutePath());
        test1.info("Hit the submit button to submit the file");
        driver.findElement(By.id("file-submit")).click();

        test1.info("Validating the uploaded file");
        WebElement fileName = driver.findElement(By.id("uploaded-files"));
        Assert.assertEquals("nature.jpg",fileName.getText());
        test1.generateLog(Status.PASS,"The test is passed successfully");
        driver.quit();
        extent.flush();
    }
}
