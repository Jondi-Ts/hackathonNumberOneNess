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

    @Step("editing todo name and geting text for cheking")
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
//
//    @Step("deleting todo for and getting size of todos for checking delete function")
//    public static int deleteTodo(int chooseIndexOfTodo) {
//        todoPage.delete(chooseIndexOfTodo);
//        return todoPage.list_of_todos.size();
//    }


//    public void edit(int editTodoIndex) {
//        action = new Actions(driver);
//        action.moveToElement(list_of_todos.get(editTodoIndex)).doubleClick();
//        action.sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.BACK_SPACE).sendKeys(expectedEditedTitle);
//        action.sendKeys(Keys.ENTER).build().perform();
//
//
//    }
//
//    @Step("delete
//    public void delete(int chooseIndexToDelete) {
//        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
//        delete_btns.get(chooseIndexToDelete).click();
//
//    }
}