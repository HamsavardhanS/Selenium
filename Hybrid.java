package runner;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class TestClass extends Base {

    WebDriverHelper wb;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod()
    public void setup() {
        openBrowser();
        wb = new WebDriverHelper(driver);
        extent = Reporter.generateExtentReport("Extent_Report");
    }

    @Test(priority = 1)
    public void test1() throws Exception {
        test = extent.createTest("Test1");
        wb.clickOnElement(By.xpath("(//div[@class='login-button js-hrf'])[1]"));
        LoggerHandler.info("click on signin");
        wb.clickOnElement(By.xpath("(//a[@class='example-company'])[1]"));
        wb.switchToNewWindow();
        wb.javascriptScroll(By.xpath("//a[@class='verified-dealer-title js-link-into-dialog']"));
        wb.clickOnElement(By.xpath("//a[@class='verified-dealer-title js-link-into-dialog']"));
        Thread.sleep(2000);
        wb.clickOnElement(By.xpath("//a[@class='contact-with-dealer-button']"));
        test.pass("Take_Screen_Shot");
        Screenshot.captureScreenShot("agronetto_screenshot");
        test.addScreenCaptureFromPath(System.getProperty("user.dir") + "/screenshots/agronetto_screenshot.png");
        Thread.sleep(5000);
    }

    @Test(priority = 2)
    public void test2() throws Exception {
        test = extent.createTest("Test_2");
        wb.javascriptScroll(By.xpath("//div[@class='footer-top']"));
        wb.clickOnElement(By.xpath("//a[text()='Blog']"));
        for (int i = 1; i <= 10; i++) {
            LoggerHandler.info("click on Blog");
        }
        test.log(Status.PASS, "Blog Clicked");
        wb.hoverOverElement(By.xpath("//div[@class='project-curr']"));
        wb.clickOnElement(
                By.xpath("//li[@id='menu-item-1536']//a[normalize-space()='Blog about construction machinery']"));
        wb.switchToNewWindow();
        wb.clickOnElement(By.xpath("(//span[text()='Special machinery'])[1]"));
        test.pass("Take_Screen_Shot");
        Screenshot.captureScreenShot("No result");
        test.addScreenCaptureFromPath(System.getProperty("user.dir") + "/screenshots/No result.png");
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public void test3() throws Exception {
        test = extent.createTest("Test_3");
        wb.clickOnElement(By.xpath("(//div[@class='menu-item detailed-menu-header__item scrollable'])[3]"));
        wb.sendKeys(By.xpath("//input[@name='spcid']"), "37178");
        wb.enterAction(By.xpath("//input[@name='spcid']"));
        wb.clickOnElement(By.xpath("//div[@class='sl-header-button__content']"));
        wb.clickOnElement(By.xpath("(//span[@class='menu-item link js-hrf'])[2]"));
        Thread.sleep(5000);
    }

    @AfterMethod
    public void last() {
        if (driver != null)
            driver.quit();
    }

    @AfterClass
    public void erase() {
        if (extent != null) {
            extent.flush();
        }
    }
}
