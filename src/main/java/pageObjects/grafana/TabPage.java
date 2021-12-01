package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TabPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[1]/div/div/nav/div[2]/ul/li[1]/a")
    private WebElement users ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[1]/div/div/nav/div[2]/ul/li[2]/a")
    private WebElement orgs ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[1]/div/div/nav/div[2]/ul/li[3]/a")
    private WebElement settings ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[1]/div/div/nav/div[2]/ul/li[4]/a")
    private WebElement plugins ;

    @FindBy(how = How.XPATH, using = "//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[1]/div/div/nav/div[2]/ul/li[5]/a")
    private WebElement Statsandlicensing ;


    public  WebElement getusers()
    {
        return users ;
    }

    public  WebElement getuorgs()
    {
        return orgs ;
    }

    public  WebElement getsettings()
    {
        return settings ;
    }

    public  WebElement getplugins()
    {
        return plugins ;
    }

    public  WebElement getStatsandlicensing()
    {
        return Statsandlicensing ;
    }


}
