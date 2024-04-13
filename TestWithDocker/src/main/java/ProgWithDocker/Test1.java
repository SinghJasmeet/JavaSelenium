package ProgWithDocker;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class Test1 {
//    public static String remote_url_chrome = "http://localhost:4445";

    public static void main(String[] args) throws IOException {

//        System.setProperty("webdriver.chrome.driver","C:/Users/jasme/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        String remoteURL = String.valueOf(new URL("http://localhost:4444"));
//        WebDriver driver = new RemoteWebDriver(new URL(remoteURL),options);


//        options.setBinary("C:/Users/jasme/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
//        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.guru99.com");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable());

        Wait wait2 = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration.ofSeconds(10))
                                .ignoring(NoSuchElementException.class);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String title = driver.getTitle();
        System.out.println(title);
//        WebElement tp = driver.findElement(RelativeLocator.with(By.tagName()).above();
        WebElement name = driver.findElement(By.xpath("//*[@id=\"post-2669\"]/div/div[1]/div[1]/div[2]/div/div[2]/span[4]/a/img"));
        /**
         * Screenshot for particular elements
         */
        File source = name.getScreenshotAs(OutputType.FILE);
        /**
         * Screenshot for full page
         */
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File dest = new File("./target/screenshots" + "pic_"+System.currentTimeMillis()+".png");
        FileHandler.copy(srcFile, (dest));

//        System.out.println(System.currentTimeMillis());
        driver.quit();

    }
}
