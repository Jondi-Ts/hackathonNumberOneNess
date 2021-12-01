package testCase;

import Utilities.CommonOps;
import extensions.Verfications;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import workFlows.WorkFlowWeb;

import static org.testng.Assert.assertEquals;

public class WebTest extends CommonOps {


    @Test(priority = 1)
    public  void loginTest()
    {
        WorkFlowWeb.login();
       Verfications.verifyEquals(myhomepage.getTitle().getText(),expectedTitle);
    }

    @Test(priority = 2)
    public  void CreateUserTest()
    {
      WorkFlowWeb.CreateUser();
        Verfications.verifyEquals(sizeofuserstable,expectedsizeofrows + 1);

    }

    @Test(priority = 3)
    public  void EditUserTest()
    {
        WorkFlowWeb.EditUser();

        Verfications.verifyEquals(myserveradminpage.getEditName().getText(),Editname);

    }
    @Test(priority=4 )
    public  void DeleteUserTest()
    {
        WorkFlowWeb.deleteUser();;

      Verfications.verifyEquals(myserveradminpage.getEditName().getText(),Editname);

    }

    @Test(priority=5)
    public  void SoftAssertTest()
    {
        WorkFlowWeb.softAssertTest();

    }


    @Test(priority = 6)
    public  void  DataSourceTest()
    {
        WorkFlowWeb.DataSource();
        Verfications.verifyEquals(mydspage.getMysolSpan().getText(),search);

    }

    @Test(priority = 7)
    public  void   SeveniconTest()
    {

         int size=  WorkFlowWeb.Sevenicon();
        Verfications.verifyEquals(size,expectedsizeoficons);

    }

    @Test(priority = 8)
    public  void SikuliTest() throws FindFailed {

        Verfications.verifyTrue(WorkFlowWeb.sikuli());
    }

}
