package Utilities;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pageObjects.calculator.CalculatorPage;
import pageObjects.grafana.*;
import pageObjects.toDoLIst.TodoPage;
import pageObjects.uintConverter.CalculatorPage2;

public class ManagePages extends Base {

    @Step("init web pages")
    public static void initWeb() {

        myloginpage = PageFactory.initElements(driver, LoginPage.class);
        myhomepage = PageFactory.initElements(driver, HomePage.class);
        myserveradminpage = PageFactory.initElements(driver, ServerAdminPage.class);
        mynewuserpage = PageFactory.initElements(driver, NewUserPage.class);
        myuserinfopage = PageFactory.initElements(driver, UserInfoPage.class);
        myDataPage = PageFactory.initElements(driver, DataSourcePage.class);
        mydspage = PageFactory.initElements(driver, AddDataSourcePage.class);
    }

    @Step("init DeskTop pages")
    public static void initDeskTop() {
        calc = PageFactory.initElements(driver, CalculatorPage2.class);
    }


    @Step("init electronPage")
    public static void initElectron() {
        todoPage = PageFactory.initElements(electronWebDriver, TodoPage.class);
    }

    @Step("init electronPage")
    public static void initAppium() {
        calculatorPage = new CalculatorPage(androidDriver);
        androidDriver.resetApp();
        calculatorPage.okAfterReset();
    }
}
