package testCase;

import Utilities.ParameterContainer;
import io.qameta.allure.Description;
import org.testng.annotations.*;
import Utilities.CommonOps;
import workFlows.WorkFlowAppium;
import extensions.Verfications;

public class AppiumTests extends CommonOps {

    @Test(priority = 1, description = "check save button")
    @Description("This Test fill in mortgage fields and calculate repayment, after that calculation will be saved")
    public void checkSave() {
        Verfications.verifyEquals(WorkFlowAppium.checkSave(), ParameterContainer.expectedCalculationsBeforeDelete);
    }

    @Test(priority = 2, dependsOnMethods = {"checkSave"}, description = "check delete button")
    @Description("This Test checks delete functionality")
    public void checkDelete() {
        Verfications.verifyEquals(WorkFlowAppium.checkDelete(), ParameterContainer.expectedCalculationsAfterDelete);
    }


}
