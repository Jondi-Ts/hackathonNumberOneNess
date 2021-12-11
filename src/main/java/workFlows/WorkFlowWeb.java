package workFlows;

import Utilities.CommonOps;
import Utilities.JDBC;
import Utilities.ParameterContainer;
import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class WorkFlowWeb extends CommonOps {


    @Step("log in to grafana")
    @Description("log to grafana")
    public static void login() {
        //take the date from mysqldb
        JDBC.initSQLConnection();
        UIActions.SendKeys(myloginpage.getUserNameBtn(), JDBC.getCredentials().get(0));
        UIActions.SendKeys(myloginpage.getCurrentPasswordBtn(), JDBC.getCredentials().get(1));
        UIActions.Click(myloginpage.getLogInBtn());
        JDBC.closeDBCon();
        UIActions.Click(myloginpage.getSkipBtn());
    }


    @Step("create new user")
    @Description("create new user")
    public static void CreateUser() {

        //Routing to Server Admin Page
        movetoServerAdminPage();
        //click om button "new user"
        UIActions.Click(myserveradminpage.getNewuserBtn());
        //inset data for user
        insertData();
    }

    @Step("insert data for user")
    public static void insertData() {

        UIActions.SendKeys(mynewuserpage.getNameInput(), ParameterContainer.loginName);
        UIActions.SendKeys(mynewuserpage.getEmailInput(), ParameterContainer.email);
        UIActions.SendKeys(mynewuserpage.getUsernameInput(), ParameterContainer.name);
        UIActions.SendKeys(mynewuserpage.getPasswordInput(), ParameterContainer.passworduser);
        UIActions.Click(mynewuserpage.getCreateBtn());
        ParameterContainer.sizeofuserstable++;
        System.out.println("size " + ParameterContainer.sizeofuserstable);
    }

    @Step("edit user")

    public static void EditUser() {
        //move to the row- and double click
        UIActions.moveToandDoubleClick(myserveradminpage.getrow(), myserveradminpage.getnamemo());
        //info pages
        editname(ParameterContainer.Editname);
        //back to home
        UIActions.Click(myhomepage.getUsers());

    }

    @Step("edit name")
    public static void editname(String name) {
        UIActions.Click(myuserinfopage.getEditnameBtnBtn());
        UIActions.ClearInput(myuserinfopage.getInputname());
        UIActions.SendKeys(myuserinfopage.getInputname(), name);
        UIActions.Click(myuserinfopage.getSaveNameBtn());
    }

    @Step("find mysql in data source")
    public static void DataSource() {

        //routing to Configuration page
        UIActions.moveToandClick(myhomepage.getConfigBtn());

        //click on data source
        UIActions.moveToandClick(myhomepage.getDataSourceBtn());

        //click on add data source Btn
        UIActions.Click(myDataPage.getAddDataBtn());

        //search a db in the input
        searchFilter(ParameterContainer.search);


    }

    @Step("search a db in filter")
    public static void searchFilter(String search) {

        //click and search
        UIActions.Click(mydspage.getFilterinput());
        UIActions.SendKeys(mydspage.getFilterinput(), search);

    }

    @Step("chack if there is 7 icon")
    public static int Sevenicon() {
        return myhomepage.getBar().size();
    }


    @Step("sikuli test")
    public static boolean Sikuli() {
        try {

            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            //click on Shiled icon
            screen.click(sikulipath + "shiled.png");

            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            //Write admin in the input
            screen.type(sikulipath + "i.png", "admin");

            Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
            screen.exists(sikulipath + "log.png");
            return true;
        } catch (FindFailed e) {
            e.printStackTrace();
            return false;
        }
    }


    //delete
    @Step("delete user ")
    public static void deleteUser() {
        UIActions.moveToandDoubleClick(myserveradminpage.getrow(), myserveradminpage.getnamemo());
        UIActions.Click(myserveradminpage.getDeleteBtn());
        ParameterContainer.sizeofuserstable--;
        UIActions.Click(myserveradminpage.getDeleteBtn2());


    }


    @Step("softAssert on server admin ")
    public static void softAssertTest() {

        UIActions.moveToandClick(myhomepage.getServerAdminBtn());
        UIActions.moveToandClick(myhomepage.getUserBtn());


        WebElement users = myTab.getusers();
        WebElement orgs = myTab.getuorgs();
        WebElement setting = myTab.getsettings();
        WebElement plufins = myTab.getplugins();
        WebElement state = myTab.getStatsandlicensing();

        softAssertion.assertTrue(users.isDisplayed(), "Oh No, users is not Displayed");
        softAssertion.assertTrue(orgs.isDisplayed(), "Oh No, orgs is not Displayed");
        softAssertion.assertTrue(setting.isDisplayed(), "Oh No,setting is not Displayed");
        softAssertion.assertTrue(plufins.isDisplayed(), "Oh No, plugins is not Displayed");
        softAssertion.assertTrue(state.isDisplayed(), "Oh No, state is not Displayed");


        softAssertion.assertAll();
    }


    @Step("navigate to server admin page")
    public static void movetoServerAdminPage() {
        UIActions.moveToandClick(myhomepage.getServerAdminBtn());
        UIActions.moveToandClick(myhomepage.getUserBtn());
    }


}
