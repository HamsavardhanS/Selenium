package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class WebDriverHelper {
    public static final int IMPLICIT_WAIT_TIME = 10;
    public static final int PAGE_LOAD_TIME = 10;
    private WebDriver driver;

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(By element, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
        }
    }

    public void clickOnElement(By element) {
        try {
            WebElement webElement = driver.findElement(element);
            String elementName = webElement.getText();
            webElement.click();
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
        }
    }

    public void sendKeys(By element, String data) {
        try {
            WebElement webElement = driver.findElement(element);
            webElement.sendKeys(data);
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
        }
    }

    public String getText(By element) {
        try {
            WebElement webElement = driver.findElement(element);
            return webElement.getText();
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
            return null;
        }
    }

    public void jsClick(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'background: lightskyblue; border: 2px solid red;');", element);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
            js.executeScript("arguments[0].click();", element);
            String elementName = element.getText();
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
        }
    }

    public void javascriptScroll(By locator) {
        try {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', 'background: lightskyblue; border: 2px solid red;');", element);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
        }
    }

    public void switchToNewWindow() {
        try {
            Set<String> windowHandles = driver.getWindowHandles();
            for (String windowHandle : windowHandles) {
                if (!windowHandle.isEmpty()) {
                    driver.switchTo().window(windowHandle);
                } else {
                    throw new Exception("New window could not be retrieved");
                }
            }
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
        }
    }

    public void enterAction(By element) {
        try {
            WebElement webElement = driver.findElement(element);
            webElement.sendKeys(Keys.ENTER);
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
        }
    }

    public void hoverOverElement(By element) {
        try {
            WebElement webElement = driver.findElement(element);
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).perform();
        } catch (Exception e) {
            // Handle or rethrow the exception here
            e.printStackTrace();
        }
    }
}
