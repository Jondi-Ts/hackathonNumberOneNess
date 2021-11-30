package testCase;

import Utilities.CommonOps;
import extensions.Verfications;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import workFlows.WorkFlowWeb;

import static org.testng.Assert.assertEquals;

public class WebTest extends CommonOps {


    @Test
    public  void loginTest()
    {
        WorkFlowWeb.login();
        Verfications.verifyEquals(myhomepage.getusTitle().getText(),expectedTitle);
    }

    @Test
    public  void CreateUserTest()
    {
      WorkFlowWeb.CreateUser();
        Verfications.verifyEquals(sizeofuserstable,expectedsizeofrows + 1);

    }

    @Test
    public  void EditUserTest()
    {
        WorkFlowWeb.CreateUser();

        Verfications.verifyEquals(myserveradminpage.getEditName().getText(),Editname);

    }

    @Test
    public  void  DataSourceTest()
    {
        WorkFlowWeb.DataSource();
        Verfications.verifyEquals(mydspage.getSpan().getText(),search);

    }

    @Test
    public  void   SeveniconTest()
    {
        WorkFlowWeb.Sevenicon();
    }

    @Test
    public  void SikuliTest() throws FindFailed {
        WorkFlowWeb.sikuli();
    }







}
