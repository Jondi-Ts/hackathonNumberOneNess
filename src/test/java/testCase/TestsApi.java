package testCase;

import Utilities.CommonOps;
import Utilities.DDT.FileAux;
import extensions.ApiActions;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import extensions.Verfications;
import workFlows.WorkFlowApi;

public class TestsApi extends CommonOps {

    @Test
    public void test00_clearUsers() {
        WorkFlowApi.deleteAllAddedUsers();
        Verfications.verifyEquals(WorkFlowApi.getUsersCount(), 1);
    }

    @Test
    public void test01_getApiKey() {
        WorkFlowApi.getKeys();
        Verfications.verifyEquals(response.getStatusCode(), 200);
    }


    @Test
    public void test02_addUser() {
        WorkFlowApi.addUser("nn", "user@graf.com", "user", "userpassword");
        Verfications.verifyEquals(response.getStatusCode(), 200);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = FileAux.class)
    public void test03_addUsersViaCsv(String name, String email, String login, String pass) {
        WorkFlowApi.addUser(name, email, login, pass);
        Verfications.verifyEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test11_clearUsers() {
        WorkFlowApi.deleteAllAddedUsers();
        Verfications.verifyEquals(WorkFlowApi.getUsersCount(), 1);
    }


}
