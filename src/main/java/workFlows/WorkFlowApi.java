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

    @Step("create key admin")
    public static void createKey(String name) {
        createKey(name, "Admin");
    }

    @Step("creating new user")
    public static void addUser(String name, String email, String login, String password) {
        ApiActions.post("/api/admin/users", ApiActions.createJson(name, email, login, password));
    }

    @Step("delete user by id")
    public static void deleteUser(String id) {
        ApiActions.delete("/api/admin/users/", id);
    }

    @Step("Get")
    public static void getUser(String url) {
        ApiActions.get(url);
    }

    @Step("gets all users by path")
    public static JsonPath getAllUsers() {
        ApiActions.get("/api/users");
        return response.jsonPath();
    }

    @Step("get list of all user's ids")
    public static List<Integer> getAllUsersList(JsonPath jsonPath) {
        return jsonPath.getList("id");
    }

    @Step("get list of all user's ids")
    public static List<Integer> getAllUsersList() {
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

    @Step("Delete all added users ")
    public static void deleteAllAddedUsers() {
        List<Integer> users = getAllUsersList();
        for (int id : users) {
            if (id != 1) {
                deleteUser(Integer.toString(id));
            }
        }
    }

    @Step("get user amount")
    public static int getUsersCount() {
        return getAllUsersList(getAllUsers()).size();
    }

    @Step("Get id of user")
    public static int getIdFromJson(JsonPath jsonPath) {
        return jsonPath.getInt("id");
    }

    @Step
    public static void getKeys() {
        ApiActions.get(urlKeysSuffix);
    }

    public static int getUserByEmail(String loginOrMail) {
        WorkFlowApi.getUser("/api/users/lookup?loginOrEmail=" + loginOrMail);
        if (response.getStatusCode() == 200) {
            return getIdFromJson(response.jsonPath());
        } else return -1;
    }

    public static void updateUser(String id, String name, String email, String login, String password) {
        ApiActions.put("/api/admin/users", id, ApiActions.createJson(name, email, login, password));
    }



}
