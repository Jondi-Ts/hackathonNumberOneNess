package workFlows;

import Utilities.CommonOps;
import Utilities.JDBC;
import com.google.common.util.concurrent.Uninterruptibles;
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
        myloginpage.sendkeys1(JDBC.getCredentials().get(0));
        myloginpage.sendkeys2(JDBC.getCredentials().get(1));
        myloginpage.Clicklogin();
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        myloginpage.Clickskip();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);


    }


    @Step("create new user")
    public static void CreateUser() {

        //Routing to Earver Admin Page
        movetoServerAdminPage();

        //click om button "new user"
        myserveradminpage.Clicknewuser();

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);

        //new user page
        // db----ddt
        mynewuserpage.sendkeys1(name);
        mynewuserpage.sendkeys2("m@gmail.con");
        mynewuserpage.sendkeys3("momo");
        mynewuserpage.sendkeys4("988761");
        mynewuserpage.Clickcreate();
        sizeofuserstable++;
        System.out.println("size " + sizeofuserstable);

    }

    @Step("edit user")
    public static void EditUser() {

        WebElement row = myserveradminpage.getrow();
        WebElement mo = myserveradminpage.getnamemo();
        Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);
        action.moveToElement(row).moveToElement(mo).build().perform();
        action.doubleClick().build().perform();
        Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);
        //info pages
        myuserinfopage.editname(Editname);

        //back to home
        myhomepage.clickonUsers();

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);


    }

    @Step("find mysql in data source")
    public static  void DataSource() {

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        WebElement c = myhomepage.getconfigBtnBtn();
        WebElement d = myhomepage.getdataSourceBtn();
        action.moveToElement(c).click();
        action.moveToElement(d).click();
        action.build().perform();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        myDataPage.ClickAdd();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);

        mydspage.searchFilter(search);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);

    }

    @Step("chack if there is 7 icon")
    public static void Sevenicon() {
        ///return 7
        //ex--7
        assertEquals(myhomepage.getSizeBar(),7);

    }

    @Step("sikuli test- ")
    public static void sikuli() throws FindFailed {

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        //click on Shiled icon
        screen.click(sikulipath + "shiled.png");

        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        //Write admin in the input
        screen.type(sikulipath + "i.png","admin");

        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

        if(screen.exists(sikulipath + "log.png")!=null)
        {
            System.out.println("find!");
        }
        else {
            System.out.println("not found");
        }

    }



    //delete
    @Step("delete user ")
    public static void deleteUser()
    {
        WebElement row = myserveradminpage.getrow();
        WebElement mo = myserveradminpage.getnamemo();

        Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);

        action.moveToElement(row).moveToElement(mo).build().perform();
        action.doubleClick().build().perform();

        Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);

        myserveradminpage.Clickdelete();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        myserveradminpage.Clickdelete2();


    }


    @Step("softAssert on server admin ")
    public static void softAssertTest()
    {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        WebElement admin = myhomepage.getserverAdminBtn();
        WebElement user = myhomepage.getuserBtn();

        action.moveToElement(admin).click();
        action.moveToElement(user).click();
        action.build().perform();

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

        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        WebElement admin = myhomepage.getserverAdminBtn();
        WebElement user = myhomepage.getuserBtn();
        action.moveToElement(admin).click();
        action.moveToElement(user).click();
        action.build().perform();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


}
