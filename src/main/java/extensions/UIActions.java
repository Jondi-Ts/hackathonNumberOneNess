package extensions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIActions {


    public static void Click(WebElement elem)
    {
     elem.click();
    }

    public static void SendKeys(WebElement elem, String str)
    {
        elem.sendKeys(str);
    }


}
