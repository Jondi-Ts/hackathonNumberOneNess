package Utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.calculator.CalculatorPage;
import pageObjects.grafana.*;
import pageObjects.toDoLIst.TodoPage;
import pageObjects.uintConverter.CalculatorPage2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Base {

    //general
    protected static WebDriver driver;
    protected static Actions action;
    protected static  WebDriverWait wait ;
    //put the url in xml


    //web-selenium

    protected static SoftAssert softAssertion;

    protected static LoginPage myloginpage;
    protected static HomePage myhomepage;
    protected static ServerAdminPage myserveradminpage;
    protected static NewUserPage mynewuserpage;
    protected static UserInfoPage myuserinfopage;
    protected static DataSourcePage myDataPage;
    protected static AddDataSourcePage mydspage;
    protected static TabPage myTab;
    protected static Screen screen;
    protected static String sikulipath;


    //Rest API
    protected static String urlApi;
    protected static String urlKeysSuffix;
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params;
    protected static JsonPath jp;

// api


    //appium

    protected static AndroidDriver<AndroidElement> androidDriver;


    //Desired Capabilities
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //expectations
    protected static CalculatorPage calculatorPage;


    //desktop

    protected DesiredCapabilities deskTopCapabilities;
    protected static CalculatorPage2 calc;

    //electron start
    protected static ChromeOptions opt;
    protected static DesiredCapabilities electronCapabilities;


    //po
    protected static TodoPage todoPage;


    //electron End


    //JDBC
    static ResultSet rs;
    static Connection con;
    static Statement stmt;

}
