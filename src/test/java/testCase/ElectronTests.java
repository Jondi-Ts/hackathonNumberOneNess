package testCase;

import Utilities.CommonOps;
import extensions.Verfications;
import org.testng.Assert;
import org.testng.annotations.Test;
import workFlows.WorkFlowElectron;

public class ElectronTests extends CommonOps {
    //Electron
    @Test
    public void checkAddElectron() {

        expectedAmountofTodos = 4;

        int actual = WorkFlowElectron.createTodos();

        Verfications.verifyEquals(actual, expectedAmountofTodos);

//        Assert.assertEquals(WorkFlowElectron.createTodos(), expectedAmountofTodos);


    }

    @Test
    public void checkDeleteElectron() {
        Assert.assertEquals(WorkFlowElectron.deleteTodo(2), expectedAmountofTodosAfterDelete);

    }

    @Test
    public void CheckEditElectron() {
        Assert.assertEquals(WorkFlowElectron.edit(0), expectedEditedTitle);

    }
}
