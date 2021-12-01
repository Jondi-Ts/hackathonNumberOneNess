package pageObjects.grafana;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DataSourcePage {

    @FindBy(how = How.XPATH, using ="//*[@id=\"reactRoot\"]/div/main/div[3]/div/div[1]/div/div[2]/div/a/span")
    private WebElement addDataBtn ;

    public WebElement getAddDataBtn() {
        return addDataBtn;
    }

}
