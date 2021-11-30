package workFlows;

import Utilities.CommonOps;
import extensions.DeskTopAction;
import org.testng.Assert;

public class WorkFlowDeskTop extends CommonOps {

    public static void Addition(){

        DeskTopAction.Click( calc.btn_C);
        DeskTopAction.Click( calc.btn_7);
        DeskTopAction.Click( calc.btn_plus);
        DeskTopAction.Click(  calc.btn_2);
        DeskTopAction.Click(  calc.btn_equal);
//        System.out.println(calc.result());
//        Assert.assertTrue(calc.result()==9);

    }


}
