package pageObjects.toDoLIst;

import Utilities.Base;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TodoPage extends Base {

    @FindBy(xpath = "//input[@placeholder='Create a task']")
    private WebElement input_toDo;
    @FindBy(xpath = "//div[@class='textWrapper_X9gil']/label")
    public List<WebElement> list_of_todos;
    @FindBy(xpath = "//div[@class='view_2Ow90']//*[name()='svg'][@class='destroy_19w1q']")
    private List<WebElement> delete_btns;


    @Step("create todo")
    public void makeTodo(String todoName) {
        input_toDo.sendKeys(todoName);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        input_toDo.sendKeys(Keys.ENTER);
    }

    @Step("edit todo name")
    public void edit(int editTodoIndex) {
        action = new Actions(electronWebDriver);
        action.moveToElement(list_of_todos.get(editTodoIndex)).doubleClick();
        action.sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.BACK_SPACE).sendKeys(expectedEditedTitle);
        action.sendKeys(Keys.ENTER).build().perform();


    }

    @Step("delete todo")
    public void delete(int chooseIndexToDelete) {
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        delete_btns.get(chooseIndexToDelete).click();

    }

}
