package workFlows;

import Utilities.CommonOps;
import extensions.DeskTopAction;
import io.qameta.allure.Step;
import org.testng.Assert;

public class WorkFlowDeskTop extends CommonOps {
@Step("Desktop calculator addition ")
    public static void Addition(){

        DeskTopAction.Click( calc.btn_C);
        DeskTopAction.Click( calc.btn_7);
        DeskTopAction.Click( calc.btn_plus);
        DeskTopAction.Click(  calc.btn_2);
        DeskTopAction.Click(  calc.btn_equal);

    }

}
