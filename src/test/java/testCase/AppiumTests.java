package testCase;

import org.testng.annotations.*;
import Utilities.CommonOps;
import workFlows.WorkFlowAppium;
import extensions.Verfications;

public class AppiumTests extends CommonOps {

    @Test(priority = 1)
    public void checkSave() {

        Verfications.verifyEquals(WorkFlowAppium.checkSave(), expectedCalculationsBeforeDelete);
    }

    @Test(priority = 2)
    public void checkDelete() {
        Verfications.verifyEquals(WorkFlowAppium.checkDelete(), expectedCalculationsAfterDelete);
    }


}
