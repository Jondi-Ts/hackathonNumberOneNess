package testCase;

import Utilities.CommonOps;
import Utilities.ParameterContainer;
import extensions.Verfications;
import org.testng.annotations.Test;
import workFlows.WorkFlowElectron;

public class ElectronTests extends CommonOps {

    @Test(priority = 1)
    public void checkAddElectron() {
        Verfications.verifyEquals(WorkFlowElectron.createFourTodos(), ParameterContainer.expectedAmountofTodos);
    }

    @Test(priority = 2)
    public void checkDeleteElectron() {
        Verfications.verifyEquals(WorkFlowElectron.deleteTodo(), ParameterContainer.expectedAmountofTodosAfterDelete);
    }

    @Test(priority = 3)
    public void CheckEditElectron() {
        Verfications.verifyEquals(WorkFlowElectron.edit(2), ParameterContainer.expectedEditedTitle);
    }
}
