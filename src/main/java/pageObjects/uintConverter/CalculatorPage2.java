package pageObjects.uintConverter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage2 {
    @FindBy(name = "Plus")
    public  WebElement btn_plus;
    @FindBy(name = "Multiply by")
    public WebElement btn_multy;
    @FindBy(name = "Equals")
    public WebElement btn_equal;
    @FindBy (xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement btn_result;
    @FindBy(name = "Clear")
    public WebElement btn_C;
    @FindBy(name = "Seven")
    public WebElement btn_7;
    @FindBy(name = "Two")
    public WebElement btn_2;

    public Integer result(){
        String str=btn_result.getAttribute("Name");
        String []arr=str.split(" ");
        return Integer.parseInt(arr[arr.length-1]);
    }

}
