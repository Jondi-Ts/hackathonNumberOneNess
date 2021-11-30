package testCase;

import org.testng.annotations.*;
import Utilities.CommonOps;
import org.testng.Assert;
import workFlows.WorkFlowAppium;
import workFlows.WorkFlowElectron;
import workFlows.WorkFlowDeskTop;
import extensions.Verfications;

public class AppiumTests extends CommonOps {
//Apium
    @Test
    public void test1() {

        WorkFlowAppium.createCalculation("12000", "1", "1");
        WorkFlowAppium.createCalculation("254345", "2", "1");
        WorkFlowAppium.swipeAndCheckSave();
    }

   @Test
    public void test2() {

        WorkFlowAppium.checkDelete();
    }
    //Appium





}
