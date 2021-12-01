package workFlows;

import Utilities.CommonOps;
import extensions.ApiActions;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkFlowApi extends CommonOps {
    @Step("creating api key")
    public static void createKey(String name, String role) {
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("role", role);
        JSONObject params = createJson(map);
        ApiActions.post(urlKeysSuffix, params);
    }

    public static void deleteKey(int id) {
        deleteKey(Integer.toString(id));
    }
@Step("delete key")
    public static void deleteKey(String id) {
        ApiActions.delete(urlKeysSuffix, id);
    }

    public static void createKey(String name) {
        createKey(name, "Admin");
    }

    public static void addUser(String name, String email, String login, String password) {
        ApiActions.post("/api/admin/users", ApiActions.createJson(name, email, login, password));
    }

    public static void deleteUser(String id) {
        ApiActions.delete("/api/admin/users/", id);
    }

    public static void getUser(String url) {
        ApiActions.get(url);
    }

    public static JsonPath getAllUsers() {
        ApiActions.get("/api/users");
        return response.jsonPath();
    }

    public static List<String> getAllUsersList(JsonPath jsonPath) {
        return jsonPath.getList("id");
    }

    public static List<String> getAllUsersList() {
        return getAllUsersList(getAllUsers());
    }

    public static int getUsersCount(JsonPath jsonPath) {
        return getAllUsersList(getAllUsers()).size();
    }

    public static boolean isUserExists(String id) {
        return getAllUsersList().contains(id);
    }

    public static int getNumOfKeys(JsonPath jsonPath) {
        return ApiActions.countElementsInJsonPath(jsonPath);
    }

    public static int getNumOfKeys() {
        ApiActions.get(urlKeysSuffix);
        return ApiActions.countElementsInJsonPath(response.jsonPath());
    }

    public static void deleteAllUsers() {
        List<String> users = getAllUsersList();
        for (String str: users) {
            if (!str.equals("1")) {
                deleteUser(str);
            }
        }
    }
}
