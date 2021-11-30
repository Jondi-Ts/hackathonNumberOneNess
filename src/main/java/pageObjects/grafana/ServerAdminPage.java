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



    //צריך לקבל פרמטר ועליו ללחוץ
    public void Clicknewuser() {
        //  wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        newuserBtn.click();
    }

    public List<WebElement> getrows()
    {
        return rows;
    }

    public WebElement getrow()
    {
        return rowtow;
    }
    public WebElement getnamemo()
    {

        return namemo;
    }
    public WebElement getEditName()
    {

        return editname;
    }

    public void sizeofrows()
    {
        System.out.println("size of rows"+rows.size());
    }


}





