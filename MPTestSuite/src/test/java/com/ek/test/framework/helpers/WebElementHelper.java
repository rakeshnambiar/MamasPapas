package com.ek.test.framework.helpers;

import com.ek.test.pages.PageFactory;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.TAB;

/**
 * Created by S746032 on 23/11/2015.
 */
public class WebElementHelper {

    public static final int WEBELEMENT_DEFAULT_TIMEOUT = 20;

    public static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public static void enterText(WebElement element, String value) throws Exception {
        clickElement(element);
        element.clear();
        element.sendKeys(value);
        element.sendKeys(TAB);
    }

    public static void enterTextWithoutClick(WebElement element, String value) throws Exception {
        element.sendKeys(value);
        element.sendKeys(TAB);
    }

    public static void enterTextInSequenceWithoutClick(WebElement element, String value) throws Exception {
        for (int i = 0; i < value.length(); i++) {
            element.sendKeys(value.substring(i, i + 1));
            WaitHelper.waitFor(100);
        }
    }

    public static void enterTextInSequence(WebElement element, String value, boolean tab) throws Exception {
        clickElement(element);
        element.clear();
        for (int i = 0; i < value.length(); i++) {
            element.sendKeys(value.substring(i, i + 1));
            WaitHelper.waitFor(100);
        }
        if (tab) {
            element.sendKeys(TAB);
        }
    }

    public static void enterTextInSequenceIterative(WebElement element, String value, boolean tab) throws Exception {

        clickElement(element);

        for (int i = 0; i < value.length(); i++) {
            element.sendKeys(value.substring(i, i + 1));
            WaitHelper.waitFor(100);
        }
        if (tab) {
            element.sendKeys(TAB);
        }
    }

    public static void enterTextWithEnterKey(WebElement element, String value, boolean enterKey) throws Exception {
        clickElement(element);
        element.sendKeys(value);
        if (enterKey) {
            element.sendKeys(ENTER);
            WaitHelper.waitFor(500);
            WaitHelper.waitForPageLoad();
            WaitHelper.waitForJStoLoad();
        }
    }

    public static void enterTextWithOutTab(WebElement element, String value) throws Exception {

        // element.click();
        clickElement(element);
        element.clear();
        element.sendKeys(value);
    }


    public static void clickElement(WebElement element) throws Exception {
        int seconds = WEBELEMENT_DEFAULT_TIMEOUT;
        long time = 1000 * seconds;
        boolean timeout = false;
        while (!timeout && time > 0) {
            try {
                element.click();
                timeout = true;
                Thread.sleep(100);
            } catch (Exception e) {
                timeout = false;
                Thread.sleep(100);
                time = time - 100;
            }
        }
        if (!timeout) {
            throw new Exception("Element not clickable at the moment");
        }
        // WaitHelper.waitForJStoLoad();
    }

    public static String getElementValue(WebElement element) throws Exception {
        WaitHelper.waitUntilVisible(element);
        return getText(element);
    }

    public static String getElementValue2(WebElement element) throws Exception {
        WaitHelper.waitUntilVisible(element);
        return element.getAttribute("value");
    }

    public static String getElementValueWithoutWait(WebElement element) throws Exception {
        return element.getText();
    }

    public static String getAttributeValue(WebElement element, String attribute) throws Exception {
        WaitHelper.waitUntilVisible(element);
        return element.getAttribute(attribute);
    }

    public static void selectByValue(WebElement element, String value) throws Exception {
        WaitHelper.waitUntilVisible(element);
        Select dropDown = (Select) element;
        dropDown.selectByValue(value);
        WaitHelper.waitForJStoLoad();
    }

    public static void selectByIndex(WebElement element, int index) throws Exception {
        WaitHelper.waitUntilVisible(element);
        Select dropDown = (Select) element;
        dropDown.selectByIndex(index);
        WaitHelper.waitForJStoLoad();
    }

    public static void clickWithJquery(String cssPath) {
        JavascriptExecutor jse = (JavascriptExecutor) PageFactory.getDriver();
        jse.executeScript("document.querySelector('" + cssPath + "').click();");
    }

    public static boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public static String getText(WebElement element) throws Exception {
        int seconds = WEBELEMENT_DEFAULT_TIMEOUT;
        long time = 1000 * seconds;
        boolean timeout = false;
        String text = null;
        while (!timeout && time > 0) {
            try {
                text = element.getText();
                if (!StringUtils.isEmpty(text)) {
                    Thread.sleep(100);
                    timeout = true;
                }
            } catch (Exception e) {
                timeout = false;
                Thread.sleep(100);
                time = time - 100;
            }
        }
        if (!timeout) {
            throw new Exception("Failed to retrieve text from the element");
        }
        return text;
    }

    public static void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) PageFactory.getDriver();
        js.executeScript("window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
}

  public static void refreshPage() {
    WebDriver driver = PageFactory.getDriver();
    driver.navigate().refresh();
  }
}
