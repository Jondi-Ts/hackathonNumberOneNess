package testCase;

import Utilities.ParameterContainer;
import org.testng.annotations.*;
import Utilities.CommonOps;
import workFlows.WorkFlowAppium;
import extensions.Verfications;

public class AppiumTests extends CommonOps {

    @Test(priority = 1)
    public void checkSave() {

        Verfications.verifyEquals(WorkFlowAppium.checkSave(), ParameterContainer.expectedCalculationsBeforeDelete);
    }

    @Test(priority = 2)
    public void checkDelete() {
        Verfications.verifyEquals(WorkFlowAppium.checkDelete(), ParameterContainer.expectedCalculationsAfterDelete);
    }


}
