/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bittertest;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Edsandro de Oliveira <edsandrom@gmail.com>
 */
public class bitterWebElements {

    static public WebElement getWebElementById(WebDriver driver, String id) {
        WebElement webElement = driver.findElement(By.id(id));
        return webElement;
    }

    static public WebElement getWebElementByClass(WebDriver driver, String className) {
        WebElement webElement = driver.findElement(By.className(className));
        return webElement;
    }

    public static Select ddlSelect(WebDriver driver, String name) {
        Select ddlProvince = new Select(driver.findElement(By.id(name)));
        return ddlProvince;
    }

    public static WebElement getTempSpanElementById(WebDriver driver, String id) {
        WebElement spanElement = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return spanElement;
    }

    public static List<WebElement> getWebElementsListByXpath(WebDriver driver, String attribute) {
        List<WebElement> elementsList = driver.findElements(By.xpath("//*[@" + attribute + "]"));
        return elementsList;
    }

    public static WebElement getWebElementByName(WebDriver driver, String name) {
        WebElement webElement = driver.findElement(By.name(name));
        return webElement;
    }

    public static boolean checkTextOnPage(WebDriver driver, String text) {
        if (driver.getPageSource().contains(text)) {
            return true;
        } else {
            return false;
        }
    }

    public static WebElement getWebElementByCssSelector(WebDriver driver, String cssClass) {
        WebElement webElement = driver.findElement(By.cssSelector(cssClass));
        return webElement;
    }

    public static WebElement getWebElementByTagName(WebDriver driver, String tagName) {
        WebElement element = driver.findElement(By.tagName(tagName));
        return element;
    }

    public static WebElement getWebElementByLinkText(WebDriver driver, String text) {
        return driver.findElement(By.linkText(text));
    }

    public static void clickLinkByHref(WebDriver driver, String href) {
        List<WebElement> anchors = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = anchors.iterator();

        while (i.hasNext()) {
            WebElement anchor = i.next();
            if (anchor.getAttribute("href").contains(href)) {
                anchor.click();
                break;
            }
        }
    }

    public static void clickInputByXpathID(WebDriver driver, String id) {
        driver.findElement(By.xpath("//input[@id='" + id + "']")).click();
    }

    public static WebElement selectInputByXpathName(WebDriver driver, String name) {
        return driver.findElement(By.xpath("//input[@name='" + name + "']"));
    }

    public static void dropdownSelect(WebDriver driver, String id, String text) {
        WebElement dropdown = driver.findElement(By.id(id));
        dropdown.click();
        List<WebElement> webElementList = dropdown.findElements(By.tagName("li"));
        for (WebElement webElement : webElementList) {
            if (webElement.getText().equals(text)) {
                webElement.click();
                break;
            }
        }
    }

}
