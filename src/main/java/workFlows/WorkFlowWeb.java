package workFlows;

import Utilities.CommonOps;
import Utilities.JDBC;
import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class WorkFlowWeb extends CommonOps {

    @Step("log in to grafana")

    public static void login() {
        //take the date from mysqldb

        UIActions.SendKeys( myloginpage.getUserNameBtn(),JDBC.getCredentials().get(0));
        UIActions.SendKeys( myloginpage.getCurrentPasswordBtn(),JDBC.getCredentials().get(1));

        UIActions.Click(myloginpage.getLogInBtn());

        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        UIActions.Click(myloginpage.getSkipBtn());


    }


    @Step("create new user")
    public static void CreateUser() {

        //Routing to Server Admin Page
        movetoServerAdminPage();

        //click om button "new user"
        UIActions.Click( myserveradminpage.getNewuserBtn());

        //inset data for user
        insertData();




    }
     @Step("insert data for user")
     public static void insertData() {

        UIActions.SendKeys(mynewuserpage.getNameInput(),loginName);
        UIActions.SendKeys(mynewuserpage.getEmailInput(),email);
        UIActions.SendKeys(mynewuserpage.getUsernameInput(),name);
        UIActions.SendKeys(mynewuserpage.getPasswordInput(),passworduser);
        UIActions.Click(mynewuserpage.getCreateBtn());
         sizeofuserstable++;
         System.out.println("size " + sizeofuserstable);
     }

    @Step("edit user")
    public static void EditUser() {
        //move to the row- and double click
        UIActions.moveToandDoubleClick( myserveradminpage.getrow(),myserveradminpage.getnamemo());

        //info pages
        editname(Editname);

        //back to home
        UIActions.Click(  myhomepage.getUsers());

    }

    @Step("edit name")
    public static void editname(String name)
    {
        UIActions.Click(myuserinfopage.getEditnameBtnBtn());
        UIActions.ClearInput(myuserinfopage.getInputname());
        UIActions.SendKeys(myuserinfopage.getInputname(),name);
        UIActions.Click(myuserinfopage.getSaveNameBtn());
    }

    @Step("find mysql in data source")
    public static  void DataSource() {

        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        UIActions.moveToandClick(myhomepage.getConfigBtn());
        UIActions.moveToandClick(myhomepage.getDataSourceBtn());

        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);

        UIActions.Click(myDataPage.getAddDataBtn());
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);

        searchFilter(search);
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);

    }

   @Step("search db in filter")
    public static void searchFilter(String search) {
        UIActions.Click(mydspage.getFilterinput());
        UIActions.SendKeys(mydspage.getFilterinput(),search);

    }

    @Step("chack if there is 7 icon")
    public static int Sevenicon() {

        return myhomepage.getBar().size();


    }

    @Step("sikuli test- ")
    public static Boolean sikuli() throws FindFailed {

        Uninterruptibles.sleepUninterruptibly(1500, TimeUnit.MILLISECONDS);
        //click on Shiled icon
        screen.click(sikulipath + "shiled.png");

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        //Write admin in the input
        screen.type(sikulipath + "i.png","admin");

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        if(screen.exists(sikulipath + "log.png")!=null)
        {
           return true;
        }
        else {
           return false;
        }

    }



    //delete
    @Step("delete user ")
    public static void deleteUser()
    {
        UIActions.moveToandDoubleClick( myserveradminpage.getrow(),myserveradminpage.getnamemo());
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);

        UIActions.Click(  myserveradminpage.getDeleteBtn());
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);

        UIActions.Click(  myserveradminpage.getDeleteBtn2());

    }


    @Step("softAssert on server admin ")
    public static void softAssertTest()
    {
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        UIActions.moveToandClick(myhomepage.getServerAdminBtn());
        UIActions.moveToandClick(myhomepage.getUserBtn());


        WebElement users =myTab.getusers();
        WebElement orgs = myTab.getuorgs();
        WebElement setting = myTab.getsettings();
        WebElement plufins = myTab.getplugins();
        WebElement state =myTab.getStatsandlicensing();

        softAssertion.assertTrue(users.isDisplayed(), "Oh No, users is not Displayed");
        softAssertion.assertTrue(orgs.isDisplayed(), "Oh No, orgs is not Displayed");
        softAssertion.assertTrue(setting.isDisplayed(), "Oh No,setting is not Displayed");
        softAssertion.assertTrue(plufins.isDisplayed(), "Oh No, plugins is not Displayed");
        softAssertion.assertTrue(state.isDisplayed(), "Oh No, state is not Displayed");


        softAssertion.assertAll();
    }





    @Step("navigate to server admin page")
    public static  void movetoServerAdminPage() {

        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
        UIActions.moveToandClick(myhomepage.getServerAdminBtn());
        UIActions.moveToandClick(myhomepage.getUserBtn());
        Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);

    }


}
