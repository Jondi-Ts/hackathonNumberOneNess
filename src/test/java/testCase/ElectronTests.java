package testCase;

import Utilities.CommonOps;
import Utilities.ParameterContainer;
import extensions.Verfications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import workFlows.WorkFlowElectron;

public class ElectronTests extends CommonOps {

    @Test(priority = 1, description = "Test add functionality")
    @Description("This Test will input new todos name press enter and save new todo")
    public void checkAddElectron() {
        Verfications.verifyEquals(WorkFlowElectron.createFourTodos(), ParameterContainer.expectedAmountofTodos);
    }

    @Test(priority = 2, dependsOnMethods = {"checkAddElectron"}, description = "Check delete button")
    @Description("This test will delete first todo ")
    public void checkDeleteElectron() {
        Verfications.verifyEquals(WorkFlowElectron.deleteTodo(), ParameterContainer.expectedAmountofTodosAfterDelete);
    }

    @Test(priority = 3, dependsOnMethods = {"checkAddElectron"}, description = "Check editing functionality")
    @Description("This test will edit toto name and check that name was edited correctly")
    public void CheckEditElectron() {
        Verfications.verifyEquals(WorkFlowElectron.edit(2), ParameterContainer.expectedEditedTitle);
    }
}
