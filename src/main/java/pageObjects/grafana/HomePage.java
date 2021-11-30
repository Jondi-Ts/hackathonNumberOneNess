package pageObjects.grafana;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/nav/div[2]/div[7] ")
    private WebElement serverAdminBtn ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/nav/div[2]/div[6]")
    private WebElement configBtn ;


    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/nav/div[2]/div[7]/ul/li[2]/a")
    private WebElement usergBtn ;


    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/nav/div[2]/div[6]/ul/li[2]/a")
    private WebElement dataSourceBtn ;

    @FindBy(how = How.XPATH, using = " //*[@id=\"reactRoot\"]/div/nav/div[2]/div")
    private List<WebElement >bar ;




    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[1]/div/div/nav/div[2]/ul/li[1]/a")
    private WebElement users ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div/div[1]/div/div/div[1]/div/div/div[1]/section/div[2]/div/h1")
    private WebElement title ;


    public  WebElement getserverAdminBtn()
    {
        return serverAdminBtn ;
    }
    public  WebElement getconfigBtnBtn()
    {
        return configBtn ;
    }
    public  WebElement getuserBtn()
    {
        return  usergBtn;
    }
    public  WebElement getdataSourceBtn()
    {
        return  dataSourceBtn;
    }
    public  WebElement getusTitle()
    {
        return title;
    }

    public int getSizeBar()
    {
        return bar.size();
    }

    public void clickonUsers()
    {
        users.click();
    }



}
