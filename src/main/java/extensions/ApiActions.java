package extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiActions extends CommonOps {
    @Step("Get request ")
    public static void get(String url) {
        response = httpRequest.get(url);
    }

    @Step("Post")
    public static void post(String url, JSONObject params) {
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(url);
    }

    @Step("Put")
    public static void put(String url, String id, JSONObject params) {
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(url + id);
    }

    @Step("delete")
    public static void delete(String url, String id) {
        response = httpRequest.delete(url + id);
    }
@Step("create Json object from strings")
    public static JSONObject createJson(String name, String email, String login, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("email", email);
        map.put("login", login);
        map.put("password", password);
        return createJson(map);

    }
@Step("count Json elements")
    public static int countElementsInJsonPath(JsonPath jasonPath) {
        if (jasonPath == null) {
            return -1;
        }
        return jasonPath.getList("").size();
    }
}
