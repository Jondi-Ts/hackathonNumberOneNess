package testCase;

import Utilities.CommonOps;
import Utilities.ParameterContainer;
import extensions.Verfications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;
import workFlows.WorkFlowWeb;

import static org.testng.Assert.assertEquals;

public class WebTest extends CommonOps {


    @Test(priority = 1, description = "Test login")
    @Description("Login to grafana via saved info in remote sql database ")
    public void loginTest() {
        WorkFlowWeb.login();
        Verfications.verifyEquals(myhomepage.getTitle().getText(), ParameterContainer.expectedTitle);
    }

    @Test(priority = 2, description = "create new user")
    @Description("This test will fill all required fields and create user")
    public void CreateUserTest() {
        WorkFlowWeb.CreateUser();
        Verfications.verifyEquals(ParameterContainer.sizeofuserstable, ParameterContainer.expectedsizeofrows + 1);

    }

    @Test(priority = 3, description = "Edit name of user")
    @Description("This test will edit user's name and save changes")
    public void EditUserTest() {
        WorkFlowWeb.EditUser();

        Verfications.verifyEquals(myserveradminpage.getEditName().getText(), ParameterContainer.Editname);

    }

    @Test(priority = 4, description = "deleting user")
    @Description("This test will delete user and check functionality")
    public void DeleteUserTest() {
        WorkFlowWeb.deleteUser();
        Verfications.verifyEquals(ParameterContainer.sizeofuserstable, ParameterContainer.exceptedrow);


    }

    @Test(priority = 5, description = "multiply check of displayed elements")
    public void SoftAssertTest() {
        WorkFlowWeb.softAssertTest();

    }


    @Test(priority = 6)
    public void DataSourceTest() {
        WorkFlowWeb.DataSource();
        Verfications.verifyEquals(mydspage.getMysolSpan().getText(), ParameterContainer.search);

    }

    @Test(priority = 7)
    public void SeveniconTest() {

        int size = WorkFlowWeb.Sevenicon();
        Verfications.verifyEquals(size, ParameterContainer.expectedsizeoficons);

    }

    @Test(priority = 8)
    public void SikuliTest() throws FindFailed {


        Verfications.verifyTrue(WorkFlowWeb.Sikuli());
    }

}
