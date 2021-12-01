package extensions;


import Utilities.CommonOps;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UIActions extends CommonOps {


    public static void Click(WebElement elem) {

        elem.click();
       // wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

    public static void SendKeys(WebElement elem, String str) {
        elem.sendKeys(str);
    }

    public static void SendKeys(WebElement elem, Keys str) {
        elem.sendKeys(str);
    }


    public static void ClearInput(WebElement elem) {
        elem.clear();
    }

    public static void moveToandDoubleClick(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).build().perform();
        action.doubleClick().build().perform();
    }

    public static void moveToandClick(WebElement elem) {
        action.moveToElement(elem).click();
        action.build().perform();
    }


}
