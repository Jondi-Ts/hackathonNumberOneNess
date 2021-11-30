package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[2]/div/div/form/div[1]/div[2]/div/div/input")
    private WebElement userNameBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"current-password\"]")
    private WebElement currentPasswordBtn;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[2]/div/div/form/button")
    private WebElement logInBtn;

    @FindBy(how = How.CSS, using = "#reactRoot > div > main > div.css-1cgt561 > div > div.css-9h8xxw > div > form > div.css-66nrdr-vertical-group > div:nth-child(2) > button")
    private WebElement skipBtn;



    //UI ACTIONS
    //להתשמש בפונקציות ששם
    public void sendkeys1(String str) {
       userNameBtn.sendKeys(str);
    }
    public void sendkeys2(String str) {
        currentPasswordBtn.sendKeys(str);
    }

    ///צריך לקבל פרמטר ועליו ללחוץ
    public void Clicklogin() {
       logInBtn.click();
    }
    public void Clickskip() {
        skipBtn.click();
    }




}
