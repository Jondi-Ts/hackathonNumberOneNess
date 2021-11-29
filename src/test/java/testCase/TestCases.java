package testCase;

import org.testng.annotations.*;
import Utilities.CommonOps;
import org.testng.Assert;
import workFlows.WorkFlowAppium;

public class Test extends CommonOps {

    @org.testng.annotations.Test
    public void test1() {

        WorkFlowAppium.createCalculation("12000", "1", "1");
        WorkFlowAppium.createCalculation("254345", "2", "1");
        WorkFlowAppium.swipeAndCheckSave();
    }

    @org.testng.annotations.Test
    public void test2() {

        WorkFlowAppium.checkDelete();
    }
}
