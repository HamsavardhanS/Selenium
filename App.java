package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;


public class App 
{
    private static final Logger log=LogManager.getLogger(App.class);
    public static void log4j()
    {
        log.info("Info Message");
        log.warn("Warn Message");
        log.debug("Debug Message");
        log.trace("Trace Message");
        log.fatal("Fatal Message");
        log.error("Error Message");
    }

    public static void cssSelectors()
    {
        WebDriverManager.chromedriver().setup();
        // WebDriverListener listeners=new EventHandler();
        // driver=new EventFiringDecorator<>(listeners).decorate(new ChromeDriver());
        WebDriver driver=new ChromeDriver();
        
        driver.get("https://www.google.com");
        //---->//For Collecting Cookies in the website
        for(Cookie cookie : driver.manage().getCookies())
        {
            System.out.println(cookie);
        }
        WebElement contains=driver.findElement(By.cssSelector("textarea[id*=\"qb\"]"));
        contains.sendKeys("Selenium");
        WebElement ends=driver.findElement(By.cssSelector("textarea[id$=\"qb\"]"));
        ends.sendKeys("Selenium");
        WebElement starts=driver.findElement(By.cssSelector("textarea[id^=\"AP\"]"));
        starts.sendKeys("Selenium");
        WebElement tagname=driver.findElement(By.cssSelector("textarea[title=\"Search\"]"));
        tagname.sendKeys("Selenium");
        // WebElement class=driver.findElement(By.cssSelector("textarea.gLFyf"));
        // class.sendKeys("Selenium");
        WebElement id=driver.findElement(By.cssSelector("textarea#APjFqb"));
        id.sendKeys("Selenium");
    }
    public static void xpath()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement un=driver.findElement(By.xpath("(//input[starts-with(@class,\"input_error\")])[1]"));
        un.sendKeys("standard_user");
        WebElement pd=driver.findElement(By.xpath("(//input[starts-with(@class,\"input_error\")])[2]"));
        pd.sendKeys("secret_sauce");
        WebElement btn=driver.findElement(By.xpath("//input[@value=\"Login\"]"));
        btn.click();

    }
    public static void waitc() throws InterruptedException
    {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--disable-notifications");
            WebDriver driver=new ChromeDriver(options);
            driver.get("https://www.medplusmart.com");
            // Alert alt=driver.switchTo().alert();
            // alt.dismiss();
            WebElement pr=driver.findElement(By.xpath("(//a[@title=\"Promotions\"])[2]"));
            pr.click();
            WebElement qo=driver.findElement(By.xpath("//button[@title=\"Quick Order\"]"));
            qo.click();
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
            //Thread.sleep(3000);
            WebElement cr=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type=\"button\"])[3]")));
            cr.click();
            Thread.sleep(3000);
            WebElement lg=driver.findElement(By.xpath("//span[@class=\"user-name\"]"));
            lg.click();
    }
    public static void Enter()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        WebElement ele=driver.findElement(By.id("APjFqb"));
        ele.sendKeys("Selenium"+Keys.ENTER);
        // WebElement btn = driver.findElement(By.className("gNO89b"));
        // Actions action = new Actions(driver);
        // action.moveToElement(btn).perform();
        // btn.click();
    }
    public static void Swaglabs()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        try{
            driver.get("https://www.saucedemo.com/");
            WebElement un =driver.findElement(By.id("user-name"));
            un.sendKeys("standard_user");
            WebElement pw =driver.findElement(By.id("password"));
            pw.sendKeys("secret_sauce");
            WebElement nbutton = driver.findElement(By.id("login-button"));
            nbutton.click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void action() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //--->>mouse handling
        /*driver.get("https://demoqa.com/buttons");
        Actions action =new Actions(driver);
        WebElement doublec=driver.findElement(By.xpath("//button[text()=\"Double Click Me\"]"));
        action.doubleClick(doublec).perform();
        WebElement rightc=driver.findElement(By.xpath("//button[text()=\"Right Click Me\"]"));
        action.contextClick(rightc).perform();
        Thread.sleep(100000);
        driver.quit();*/

        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        Actions action=new Actions(driver);
        WebElement ele=driver.findElement(By.xpath("(//button[@class=\"nav-flyout-button nav-icon nav-arrow\"])[2]"));
        action.moveToElement(ele).perform();
        Thread.sleep(2000);
        WebElement sn=driver.findElement(By.xpath("(//span[text()=\"Sign in\"])[1]"));
        sn.click();
        driver.navigate().back();
        WebElement sr=driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]"));
        sr.sendKeys("Nothing Phone 2a");
        WebElement sb=driver.findElement(By.xpath("//input[@id=\"nav-search-submit-button\"]"));
        sb.click();
        driver.close();

        //-->Copy-Paste:

        // driver.get("https://adactinhotelapp.com/");
        // WebElement ele=driver.findElement(By.xpath("//input[@type=\"text\"]"));
        // ele.sendKeys("Salman");
        // ele.sendKeys(Keys.CONTROL + "a");
        // ele.sendKeys(Keys.CONTROL + "c");
        // WebElement ele1=driver.findElement(By.xpath("//input[@type=\"password\"]"));
        // ele1.sendKeys(Keys.CONTROL + "v");
        // Thread.sleep(6000);
        // driver.quit();
    }
    public  static void alert() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Alerts.html");
        WebElement btn=driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]"));
        btn.click();
        Alert alt=driver.switchTo().alert();
        alt.accept();
        WebElement btn1=driver.findElement(By.xpath("//a[text()=\"Alert with OK & Cancel \"]"));
        btn1.click();
        WebElement btn2=driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]"));
        btn2.click();
        Alert dms=driver.switchTo().alert();
        dms.dismiss();

        
       
    }
    public static void ScreenShot() throws IOException
    {
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.google.com");
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File des=new File("D:\\Selenium\\sele_screenshot.png");

        FileUtils.copyFile(src, des);
        driver.quit();
    }
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
      //  Assert.assertEquals(pagesource, "Please enter the OTP sent to your mobile number");
        
    }
    
    public static void dragdrop() throws Exception{
         WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0); // Page has iframe

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();

        Thread.sleep(3000);
        driver.quit();
    }
    public static void switchwin() throws Exception
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1. Open parent page
        driver.get("https://the-internet.herokuapp.com/windows");

        // Get parent window ID
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window Title: " + driver.getTitle());

        // 2. Click link to open child window
        WebElement link = driver.findElement(By.xpath("//a[text()='Click Here']"));
        link.click();

        // 3. Get all window handles
        Set<String> windows = driver.getWindowHandles();

        // 4. Switch to child window
        for (String win : windows) {
            if (!win.equals(parentWindow)) {
                driver.switchTo().window(win);
                System.out.println("Child Window Title: " + driver.getTitle());

                // Do something in child window
                Thread.sleep(2000);

                // Close child window
                driver.close();
            }
        }

        // 5. Switch back to parent
        driver.switchTo().window(parentWindow);
        System.out.println("Back to Parent Window: " + driver.getTitle());

        // Close parent
        // driver.quit();
    }
    public static void xlx() throws Exception
    {
        Workbook wb=new XSSFWorkbook();
        Sheet sh =wb.createSheet("Demo");
        Row r1=sh.createRow(0);
        Cell c1=r1.createCell(0);
        c1.setCellValue("Hello");
        Cell c2=r1.createCell(1);
        c2.setCellValue("World");
        FileOutputStream fos=new FileOutputStream("Demo.xlsx");
        wb.write(fos);
        fos.close();
        wb.close();
        FileInputStream fis=new FileInputStream("Demo.xlsx");
        Workbook wb1=new XSSFWorkbook(fis);
        Sheet sh1=wb1.getSheet("Demo");
        Row r2=sh1.getRow(0);
        Cell c3=r2.getCell(0);
        System.out.println(c3.getStringCellValue());
        Cell c4=r2.getCell(1);
        System.out.println(c4.getStringCellValue());
        wb1.close();
        fis.close();
    }

    public static void main( String[] args ) throws Exception
    {
        // cssSelectors();
        //xpath();
        //Swaglabs();
        //Enter();
        //action();
        //alert();
       //waitc();
        //ScreenShot();
       // dragdrop();
        //xlx();
        ast();
        //log4j();
        //switchwin();
    }
}
