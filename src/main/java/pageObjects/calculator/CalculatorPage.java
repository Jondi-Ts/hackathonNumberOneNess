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


    public void sendKeys(String sendAmount, String sendTerm, String sendRate) {
        amount.sendKeys(sendAmount);
        term.sendKeys(sendTerm);
        rate.sendKeys(sendRate);
    }

    public void calculate() {
        calculate_btn.click();
    }

    public void save() {
        save_btn.click();
    }

    public void swipe() {
        swipeScreen(Direction.LEFT);
    }

    public void checkSaved() {
        Assert.assertEquals(delete_btns.size(), 2, "no saved calculations");

    }

    public void checkDeleted() {
        delete_btn.click();
        confirm_delete_btn.click();
        Assert.assertEquals(delete_btns.size(), 1, "no saved calculations");

    }

    public void okAfterReset() {
        after_reset_ok_btn.click();
    }



    public void swipeScreen(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = androidDriver.manage().window().getSize();

        // init start point = center of screen
        //original from center  pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);
        pointOptionStart = PointOption.point(dims.width -10, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction(androidDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
