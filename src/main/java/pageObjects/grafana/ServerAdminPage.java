package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ServerAdminPage {

    // WebElements definition
    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div[1]/a/span")
    private WebElement newuserBtn ;

    @FindBy(how = How.XPATH, using = "//*[@id='reactRoot']/div/main/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr")
    private List<WebElement> rows;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr")
     private WebElement row;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr[2]")
    private WebElement rowtow;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/a")
    private WebElement namemo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[2]/table/tbody/tr[2]/td[4]/a")
    private WebElement editname;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[2]/button[1]/span")
    private WebElement deleteBtn;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/button")
    private WebElement deleteBtn2;

    public List<WebElement> getrows()
    {
        return rows;
    }

    public WebElement getrow()
    {
        return rowtow;
    }

    public WebElement getnamemo() { return namemo; }

    public WebElement getEditName() { return editname; }

    public  WebElement getNewuserBtn() { return newuserBtn; }

    public  WebElement getDeleteBtn() { return deleteBtn; }

    public  WebElement getDeleteBtn2() { return deleteBtn2; }


    public void Clickdelete() { deleteBtn.click(); }

    public void Clickdelete2() { deleteBtn2.click(); }


    public void sizeofrows()
    {
        System.out.println("size of rows"+rows.size());
    }


}





