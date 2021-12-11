package testCase;

import Utilities.CommonOps;
import Utilities.DDT.ManageDDT;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import extensions.Verfications;
import workFlows.WorkFlowApi;

public class TestsApi extends CommonOps {

    @Test(description = "Clear all none defective users")
    public void test00_clearUsers() {
        WorkFlowApi.deleteAllAddedUsers();
        Verfications.verifyEquals(WorkFlowApi.getUsersCount(), 1);
    }

    @Test(description = "get api key")
    public void test01_getApiKey() {
        WorkFlowApi.getKeys();
        Verfications.verifyEquals(response.getStatusCode(), 200);
    }


    @Test(description = "creating new user")
    public void test02_addUser() {
        WorkFlowApi.addUser("nn", "user@graf.com", "user", "userpassword");
        Verfications.verifyEquals(response.getStatusCode(), 200);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = ManageDDT.class)
    @Description("Adding multiply users via csv file")
    public void test03_addUsersViaCsv(String name, String email, String login, String pass) {
        WorkFlowApi.addUser(name, email, login, pass);
        Verfications.verifyEquals(response.getStatusCode(), 200);
    }

    @Test(description = "Clear all none defective users")
    public void test11_clearUsers() {
        WorkFlowApi.deleteAllAddedUsers();
        Verfications.verifyEquals(WorkFlowApi.getUsersCount(), 1);
    }


}
