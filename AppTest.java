package com.example;

import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AppTest {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;    

    @BeforeSuite
    public void beforeSuite() {
        String reportPath = System.getProperty("user.dir") + "ExtentReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Selenium Test Execution");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Hamsa");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("OS", "Windows 11");

        System.out.println("Before Suite: Setup global resources");
    }

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Before Method: Login to App");
    }
    @Test
    public static void ast()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.finology.in/");
        WebElement ele=driver.findElement(By.xpath("//a[text()=\"Login\"]"));
        ele.click();
        WebElement ph=driver.findElement(By.xpath("//input[@type=\"tel\"]"));
        ph.sendKeys("9876543210");
        WebElement cn=driver.findElement(By.xpath("//button[text()=\"Continue\"]"));  
        cn.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement txt=driver.findElement(By.xpath("//label[@class=\"fs1 fw600 pb1\"]"));

        String pagesource=txt.getText();
        System.out.println(pagesource);
        Assert.assertEquals(pagesource, "Please enter the OTP sent to your mobile number");
      // Assert.assertEquals(pagesource,"Please enter the OTP sent to your mobile number");
        
    }
    @Test
    public void Runtest() {
        test = extent.createTest("Login Test - SauceDemo");
        try {
            driver.get("https://www.saucedemo.com/");
            WebElement un = driver.findElement(By.id("user-name"));
            un.sendKeys("standard_user");
            WebElement pw = driver.findElement(By.id("password"));
            pw.sendKeys("secret_sauce");
            WebElement nbutton = driver.findElement(By.id("login-button"));
            nbutton.click();
            test.pass("Login successful in SauceDemo");
        } catch (Exception e) {
            test.fail("Login Test failed: " + e.getMessage());
        }
    }
    @Test
    public void ScreenShot() throws Exception{
        try{
            test=extent.createTest("ScreenShot taken");
            driver.get("https://www.google.com");
            File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File des=new File("sele_screenshot.png");
            FileUtils.copyFile(src, des);
            driver.quit();
            test.addScreenCaptureFromPath("C:\\Users\\Hamsha Vardhan\\Desktop\\Maven\\demo\\sele_screenshot.png");
        }
        catch (Exception e)
        {
            test.fail("ScreenShot Not taken");
        }
    }

    @Test
    public void Sample() {
        test = extent.createTest("Google Title Test");
        driver.get("https://www.chatgpt.com");
        String title = driver.getTitle();
        if (title.contains("Google")) {
            test.pass("Google page opened successfully. Title: " + title);
        } else {
            test.fail("Google page did not open as expected. Title: " + title);
        }
        //Assert.assertEquals(title, "Google");
    }

    @Test
    public void TestNG() {
        test = extent.createTest("String Uppercase Test");
        Assert.assertEquals("hello".toUpperCase(), "HELLO");
        test.pass("Uppercase conversion successful");
    }

    @Test
    public void testCase1() {
        test = extent.createTest("Test Case 1");
        System.out.println("Executing Test Case 1");
        test.pass("Test Case 1 executed");
    }

    @Test
    public void testCase2() {
        test = extent.createTest("Test Case 2");
        System.out.println("Executing Test Case 2");
        test.pass("Test Case 2 executed");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        System.out.println("After Method: Logout from App");
    }

    @AfterSuite
    public void afterSuite() {
        extent.flush(); // Generate report
        System.out.println("After Suite: Cleanup resources");
    }
}

