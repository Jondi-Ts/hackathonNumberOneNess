package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddDataSourcePage {
    @FindBy(how = How.XPATH, using ="//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[1]/div[1]/div/input")
    private WebElement filterinput ;

    @FindBy(how = How.XPATH, using ="//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div[2]/ul/li/div/div[1]/span[1]")
    private WebElement mysolSpan ;


    public WebElement getFilterinput() {
        return filterinput;
    }

    public WebElement getMysolSpan() {
        return mysolSpan;
    }


    //step in work flow
    public void searchFilter(String search) {
     filterinput.click();
      filterinput.sendKeys(search);
    }


}
