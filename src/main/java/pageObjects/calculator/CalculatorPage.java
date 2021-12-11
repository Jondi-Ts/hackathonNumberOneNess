package pageObjects.calculator;

import Utilities.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
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

    @Step("Get amount element")
    public WebElement getAmount() {
        return amount;
    }

    @Step("Get term elment")
    public WebElement getTerm() {
        return term;
    }

    @Step("Get rate element")
    public WebElement getRate() {
        return rate;
    }

    @Step("Get calculation button")
    public WebElement getCalculate_btn() {
        return calculate_btn;
    }

    @Step("Get save button")
    public WebElement getSave_btn() {
        return save_btn;
    }

    @Step("Get delete button")
    public WebElement getDelete_btn() {
        return delete_btn;
    }

    @Step("Get list of delete buttons")
    public List<WebElement> getDelete_btns() {
        return delete_btns;
    }

    @Step("Get delete confirmation button")
    public WebElement getConfirm_delete_btn() {
        return confirm_delete_btn;
    }

    @Step("Get delete canceling button")
    public WebElement getCancel_delete_btn() {
        return cancel_delete_btn;
    }

    @Step("Get ok button after reseting")
    public WebElement getAfter_reset_ok_btn() {
        return after_reset_ok_btn;
    }


}
