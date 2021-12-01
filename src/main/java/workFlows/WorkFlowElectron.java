package workFlows;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class WorkFlowElectron extends CommonOps {
    @Step("creation of four new todos and getting their amount for checking ")
    public static int createFourTodos() {
        for (int i = 1; i <= expectedCalculationsBeforeDelete; i++) {
            todoPage.makeTodo("Todo " + i);
        }
        return todoPage.list_of_todos.size();
    }

    @Step("editing todo name and geting text for cheking")
    public static String edit(int chooseIndexOfTodo) {
        todoPage.edit(chooseIndexOfTodo);
        return todoPage.list_of_todos.get(chooseIndexOfTodo).getText();
    }

    @Step("deleting todo for and getting size of todos for checking delete function")
    public static int deleteTodo(int chooseIndexOfTodo) {
        todoPage.delete(chooseIndexOfTodo);
        return todoPage.list_of_todos.size();
    }
}