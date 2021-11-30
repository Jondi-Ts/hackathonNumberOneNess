package testCase;

import org.testng.annotations.*;
import Utilities.CommonOps;
import org.testng.Assert;
import workFlows.WorkFlowAppium;
import workFlows.WorkFlowElectron;
import extensions.Verfications;

public class TestCases extends CommonOps {
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
    public void CheckEditElectron(){
        Assert.assertEquals(WorkFlowElectron.edit(0), expectedEditedTitle);

    }

    //Electron
}
