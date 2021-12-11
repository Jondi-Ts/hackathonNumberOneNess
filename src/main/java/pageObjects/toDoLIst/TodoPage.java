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
    private List<WebElement> list_of_todos;
    @FindBy(xpath = "//div[@class='view_2Ow90']//*[name()='svg'][@class='destroy_19w1q']")
    private List<WebElement> delete_btns;

    @Step("Get input filed for todo name")
    public WebElement getInput_toDo() {
        return input_toDo;
    }

    @Step("Get list of todos")
    public List<WebElement> getList_of_todos() {
        return list_of_todos;
    }

    @Step("Get list of delete buttons")
    public List<WebElement> getDelete_btns() {
        return delete_btns;
    }
}
