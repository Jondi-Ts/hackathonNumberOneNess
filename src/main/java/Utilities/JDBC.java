package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC extends Base {


    public void initSQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl, username, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error Occurred while Connecting to DB, See Details: " + e);
        }
    }

    public List<String> getCredentials() {
        List<String> credentials = new ArrayList<String>();
        try {
            rs = stmt.executeQuery("SELECT user_name,password FROM users WHERE comments='correct'");
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));

        } catch (SQLException e) {
            System.out.println("Error Occurred While Printing Table Data, See Details: " + e);
        }
        return credentials;
    }

    public void closeDBCon() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error Occured While Closing JDBC, See Details: " + e);
        }
    }
}

//use example

/*public class RemoteDbTest extends RemoteDb {
    WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://atidcollege.co.il/Xamples/demo");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initSQLConnection();
    }

    @Test()
    public void Test01() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys(getCredentials().get(0));
        driver.findElement(By.name("password")).sendKeys(getCredentials().get(1));
        driver.findElement(By.id("submit")).click();
        Assert.assertEquals(driver.findElement(By.id("loggedin")).getText(), "You Are Logged in");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        closeDBCon();
    }*/