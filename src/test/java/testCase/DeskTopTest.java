package testCase;

import Utilities.CommonOps;
import extensions.Verfications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import workFlows.WorkFlowDeskTop;

public class DeskTopTest extends CommonOps {
    @Test(description = "check adding")
    @Description("Test adding functionality")
    public void testDeskTop() {

        WorkFlowDeskTop.Addition();
        Verfications.verifyTrue(calc.result() == 9);


    }
}
