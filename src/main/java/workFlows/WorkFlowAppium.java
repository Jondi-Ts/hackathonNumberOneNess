package workFlows;

import Utilities.CommonOps;
import Utilities.ParameterContainer;
import com.google.common.util.concurrent.Uninterruptibles;
import extensions.MobileActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import pageObjects.calculator.CalculatorPage;



public class WorkFlowAppium extends CommonOps {
  @Step("check save button")
    public static int checkSave() {
        for (int i = 0; i < ParameterContainer.twoAppiumCalculations; i++) {
            UIActions.SendKeys(calculatorPage.getAmount(), "12000" + i);
            UIActions.SendKeys(calculatorPage.getTerm(), "1" + i);
            UIActions.SendKeys(calculatorPage.getRate(), "1" + i);

            UIActions.Click(calculatorPage.getSave_btn());

        }
        MobileActions.swipeScreen(MobileActions.Direction.LEFT);
        return calculatorPage.getDelete_btns().size();
    }
@Step("check that delete button works")
    public static int checkDelete() {
        UIActions.Click(calculatorPage.getDelete_btn());
        UIActions.Click(calculatorPage.getConfirm_delete_btn());
        return calculatorPage.getDelete_btns().size();
    }

}