package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewUserPage {
//cvs
    @FindBy(how = How.XPATH, using ="//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/form/div[1]/div[2]/div/div/input")
    private WebElement nameInput ;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/div[2]/div[2]/div/div/input")
    private WebElement emailInput ;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/div[3]/div[2]/div/div/input")
    private WebElement usernameInput ;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/div[4]/div[2]/div[1]/div/input")
    private WebElement passwordInput ;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/form/button/span")
    private WebElement createBtn ;


    public WebElement getNameInput() {
        return nameInput;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getUsernameInput() {
        return usernameInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getCreateBtn() {
        return createBtn;
    }

}
