package workFlows;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class WorkFlowElectron extends CommonOps {
    @Step("creation of four new todos and getting their amount for checking ")
    public static int createFourTodos() {
        todoPage.makeTodo("Todo 1");
        todoPage.makeTodo("Todo 2");
        todoPage.makeTodo("Todo 3");
        todoPage.makeTodo("Todo 4");
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