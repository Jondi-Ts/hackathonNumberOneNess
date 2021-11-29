package workFlows;

import Utilities.CommonOps;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

public class WorkFlowAppium extends CommonOps {
    public static void createCalculation(String sendAmount, String sendyears, String sendPercent) {

        calculatorPage.sendKeys(sendAmount, sendyears, sendPercent);
        calculatorPage.calculate();
        calculatorPage.save();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

    }

    public static void swipeAndCheckSave() {
        calculatorPage.swipe();
        calculatorPage.checkSaved();

    }

    public static void checkDelete() {
        calculatorPage.checkDeleted();
    }
}