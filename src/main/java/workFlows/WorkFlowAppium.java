package workFlows;

import Utilities.CommonOps;
import Utilities.ParameterContainer;
import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import pageObjects.calculator.CalculatorPage;

import java.util.concurrent.TimeUnit;

public class WorkFlowAppium extends CommonOps {
    //    public static int checkSave() {
//
//        calculatorPage.sendKeys("254345", "2", "1");
//        calculatorPage.calculate();
//        calculatorPage.getSaveBtn();
//        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
//        calculatorPage.sendKeys("50000", "1", "3");
//        calculatorPage.calculate();
//        calculatorPage.getSaveBtn();
//        calculatorPage.swipe();
//        return calculatorPage.delete_btns.size();
//    }
//
//
//    public static int checkDelete() {
//        calculatorPage.delete();
//        return calculatorPage.delete_btns.size();
//    }
    public static int checkSave() {
        for (int i = 0; i < ParameterContainer.twoAppiumCalculations; i++) {
            UIActions.SendKeys(calculatorPage.getAmount(), "12000" + i);
            UIActions.SendKeys(calculatorPage.getTerm(), "1" + i);
            UIActions.SendKeys(calculatorPage.getRate(), "1" + i);

            UIActions.Click(calculatorPage.getSave_btn());

        }
        calculatorPage.swipeScreen(CalculatorPage.Direction.LEFT);
        return calculatorPage.getDelete_btns().size();
    }

    public static int checkDelete() {
        UIActions.Click(calculatorPage.getDelete_btn());
        UIActions.Click(calculatorPage.getConfirm_delete_btn());
        return calculatorPage.getDelete_btns().size();
    }

}