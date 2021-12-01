package workFlows;

import Utilities.CommonOps;
import Utilities.ParameterContainer;
import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class WorkFlowElectron extends CommonOps {
    @Step("creation of four new todos and getting their amount for checking ")
    public static int createFourTodos() {
        for (int i = 1; i <= ParameterContainer.expectedAmountofTodos; i++) {
            UIActions.SendKeys(todoPage.getInput_toDo(), "todo " + i);
            UIActions.SendKeys(todoPage.getInput_toDo(), Keys.ENTER);
        }
        return todoPage.getList_of_todos().size();
    }

    @Step("editing todo name and getting text for checking")
    public static String edit(int editTodoIndex) {
        action = new Actions(driver);
        action.moveToElement(todoPage.getList_of_todos().get(editTodoIndex)).doubleClick();
        action.sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.BACK_SPACE).sendKeys(ParameterContainer.expectedEditedTitle);
        action.sendKeys(Keys.ENTER).build().perform();


        return todoPage.getList_of_todos().get(editTodoIndex).getText();
    }

    public static int deleteTodo() {
        UIActions.Click(todoPage.getDelete_btns().get(0));
        return todoPage.getDelete_btns().size();
    }

}