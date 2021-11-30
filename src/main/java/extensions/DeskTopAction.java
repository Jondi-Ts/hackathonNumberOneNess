package extensions;

import Utilities.CommonOps;
import org.openqa.selenium.WebElement;

public class DeskTopAction extends CommonOps {


    public static void Click(WebElement elem)
    {
     elem.click();
    }
}
