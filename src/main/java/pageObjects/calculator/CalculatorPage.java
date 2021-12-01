package pageObjects.calculator;

import Utilities.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CalculatorPage extends Base {
    AppiumDriver appiumDriver;

    public CalculatorPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(xpath = "//*[@id='etAmount']")
    private WebElement amount;
    @AndroidFindBy(xpath = "//*[@id='etTerm']")
    private WebElement term;
    @AndroidFindBy(xpath = "//*[@id='etRate']")
    private WebElement rate;
    @AndroidFindBy(xpath = "//*[@id='btnCalculate']")
    private WebElement calculate_btn;
    @AndroidFindBy(xpath = "//*[@id='btnSave']")
    private WebElement save_btn;
    @AndroidFindBy(xpath = "//*[@id='btnDel']")
    private WebElement delete_btn;
    @AndroidFindBy(xpath = "//*[@id='btnDel']")
    private List<WebElement> delete_btns;
    @AndroidFindBy(xpath = "//*[@text='OK']")
    private WebElement confirm_delete_btn;
    @AndroidFindBy(xpath = "//*[@text='Cancel']")
    private WebElement cancel_delete_btn;
    @AndroidFindBy(xpath = "//*[@id='button1']")
    private WebElement after_reset_ok_btn;


    public WebElement getAmount() {
        return amount;
    }

    public WebElement getTerm() {
        return term;
    }

    public WebElement getRate() {
        return rate;
    }

    public WebElement getCalculate_btn() {
        return calculate_btn;
    }

    public WebElement getSave_btn() {
        return save_btn;
    }

    public WebElement getDelete_btn() {
        return delete_btn;
    }

    public List<WebElement> getDelete_btns() {
        return delete_btns;
    }

    public WebElement getConfirm_delete_btn() {
        return confirm_delete_btn;
    }

    public WebElement getCancel_delete_btn() {
        return cancel_delete_btn;
    }

    public WebElement getAfter_reset_ok_btn() {
        return after_reset_ok_btn;
    }


}
