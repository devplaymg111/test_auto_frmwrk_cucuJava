//package PageObjects;
//
//import Driver.DriverFactory;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//
//import java.time.Duration;
//
//public class Base_PO {
//
//    public Base_PO() {
//        PageFactory.initElements(getDriver(), this);
//    }
//
//     public WebDriver getDriver()
//     {
//         return DriverFactory.getDriver();
//     }
//
//     public void navigateto_Url(String url){
//        getDriver().get(url);
//     }
//
//    public String generateRandomNumber(int length) {
//        return RandomStringUtils.randomNumeric(length);
//    }
//
//    public String generateRandomString(int length) {
//        return RandomStringUtils.randomAlphabetic(length);
//    }
//
//    public void sendKeys(By by, String textToType) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
//    }
//
//    public void sendKeys(WebElement element, String textToType) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
//    }
//
//    public void waitFor(By by) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
//    }
//
//    public void waitFor(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public void waitForWebElementAndClick(By by) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
//    }
//
//    public void waitForWebElementAndClick(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
//    }
//
//    public void waitForAlert_And_ValidateText(String text) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//        String alert_Message_Text = getDriver().switchTo().alert().getText();
//        Assert.assertEquals(alert_Message_Text, text);
//    }
//
//}
package PageObjects;

import Driver.DriverFactory;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class Base_PO {

    private static final int DEFAULT_TIMEOUT = 10; // seconds

    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void navigateto_Url(String url) {
        getDriver().get(url);
    }

//    public String generateRandomNumber(int length) {
//        return RandomStringUtils.randomNumeric(length);
//    }
//
//    public String generateRandomString(int length) {
//        return RandomStringUtils.randomAlphabetic(length);
//    }

    public String generateRandomNumber(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be > 0");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(0, 10));
        }
        return sb.toString();
    }

    public String generateRandomString(int length) {
        if (length <= 0) throw new IllegalArgumentException("Length must be > 0");
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = ThreadLocalRandom.current().nextInt(chars.length());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }

    // ===== Wait Utilities =====
    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public void sendKeys(By locator, String text) {
        WebElement element = getWait().until(ExpectedConditions.elementToBeClickable(locator));
        element.clear();
        element.sendKeys(text);
    }

    public void sendKeys(WebElement element, String text) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.clear();
        element.sendKeys(text);
    }

    public void waitForVisibility(By locator) {
        getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void waitForVisibility(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void clickWhenClickable(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void clickWhenClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAlertAndValidateText(String expectedText) {
        getWait().until(ExpectedConditions.alertIsPresent());
        String actualText = getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualText, expectedText, "Alert text does not match!");
    }
}
