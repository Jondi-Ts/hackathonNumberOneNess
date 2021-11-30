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
    public void test01() {
        ApiActions.get(urlKeysSuffix);
        Verfications.verifyEquals(response.getStatusCode(),200);

    }

    @Test
    public void test02() {
        WorkFlowApi.createKey("key4");
        Verfications.verifyEquals(response.getStatusCode(),200);

    }

    @Test
    public void test03() {
        WorkFlowApi.addUser("nn", "user@graf.com","user","userpassword");
        Verfications.verifyEquals(response.getStatusCode(),200);
    }

    @Test(dataProvider = "data-provider", dataProviderClass = FileAux.class)
    public void test035(String name, String email, String login, String pass) {
        WorkFlowApi.addUser(name, email,login,pass);
        Verfications.verifyEquals(response.getStatusCode(),200);
    }

    @Test
    public void test04() {
        //ApiWorkFlow.getUser("/api/users/lookup?loginOrEmail=user");
        //System.out.println(response.getBody().asString());
        WorkFlowApi.deleteUser("2");
        Verfications.verifyEquals(response.getStatusCode(),200);
    }



}
