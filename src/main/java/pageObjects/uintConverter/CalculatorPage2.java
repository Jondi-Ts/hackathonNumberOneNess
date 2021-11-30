package pageObjects.uintConverter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage2 {
    @FindBy(name = "ועוד")
    public  WebElement btn_plus;
    @FindBy(name = "הכפל ב")
    public WebElement btn_multy;
    @FindBy(name = "שווה")
    public WebElement btn_equal;
    @FindBy (xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement btn_result;
    @FindBy(name = "נקה ערך")
    public WebElement btn_C;
    @FindBy(name = "שבע")
    public WebElement btn_7;
    @FindBy(name = "שתיים")
    public WebElement btn_2;

    public Integer result(){
        String str=btn_result.getAttribute("Name");
        String []arr=str.split(" ");
        return Integer.parseInt(arr[arr.length-1]);
    }

}
