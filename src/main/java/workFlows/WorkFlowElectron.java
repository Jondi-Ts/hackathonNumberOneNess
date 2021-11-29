package workFlows;

import Utilities.CommonOps;

public class WorkFlowElectron extends CommonOps {
    public static int createTodos() {
        todoPage.makeTodo("Todo 1");
        todoPage.makeTodo("Todo 2");
        todoPage.makeTodo("Todo 3");
        todoPage.makeTodo("Todo 4");
        return todoPage.list_of_todos.size();
    }

    public static String edit(int chooseIndexOfTodo) {
        todoPage.edit(chooseIndexOfTodo);
        return todoPage.list_of_todos.get(chooseIndexOfTodo).getText();
    }

    public static int deleteTodo(int chooseIndexOfTodo) {
        todoPage.delete(chooseIndexOfTodo);
        return todoPage.list_of_todos.size();
    }
}