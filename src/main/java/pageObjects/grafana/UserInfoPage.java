package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserInfoPage {

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/button[1]/span")
    private WebElement deleteBtn ;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/table/tbody/tr[1]/td[3]/div/span/span[1]/button/span")
    private WebElement editnameBtn ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/table/tbody/tr[2]/td[3]/div/span/span[1]/button/span")
    private WebElement editemailBtn ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/table/tbody/tr[3]/td[3]/div/span/span[1]/button/span")
    private WebElement editusernameBtn ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/table/tbody/tr[4]/td[3]/div/span/span[1]/button/span")
    private WebElement editpasswordBtn ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/table/tbody/tr[1]/td[2]/div/div/input")
    private WebElement inputname ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/table/tbody/tr[1]/td[3]/div/span/span[2]/button[2]/span")
    private WebElement saveNameBtn ;





    public void Clicknewuser() {
      deleteBtn.click();
    }

    public void editnameBtn() {
        editnameBtn.click();
    }
    public void editemailBtn() {
        editemailBtn.click();
    }
    public void editusernameBtn() {
        editusernameBtn.click();
    }
    public void editpasswordBtn() {
        editpasswordBtn.click();
    }
    public void savename() {
        saveNameBtn.click();
    }
    public  void sendkeysname(String name)
    {
        inputname.sendKeys(name);
    }

    public  void editname(String name)
    {
        editnameBtn();
        inputname.clear();
        sendkeysname(name);
        savename();

    }


}
