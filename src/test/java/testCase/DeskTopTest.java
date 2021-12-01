package testCase;

import Utilities.CommonOps;
import extensions.Verfications;
import org.testng.annotations.Test;
import workFlows.WorkFlowDeskTop;

public class DeskTopTest extends CommonOps {
    @Test
    public void testDeskTop() {

        WorkFlowDeskTop.Addition();
        Verfications.verifyTrue(calc.result() == 9);


    }
}
