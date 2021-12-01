package workFlows;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

public class WorkFlowAppium extends CommonOps {
    public static int checkSave() {

        calculatorPage.sendKeys("254345", "2", "1");
        calculatorPage.calculate();
        calculatorPage.save();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        calculatorPage.sendKeys("50000", "1", "3");
        calculatorPage.calculate();
        calculatorPage.save();
        calculatorPage.swipe();
        return calculatorPage.delete_btns.size();
    }


    public static int checkDelete() {
        calculatorPage.delete();
        return calculatorPage.delete_btns.size();
    }
}