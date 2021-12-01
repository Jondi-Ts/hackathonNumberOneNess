package Utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ParameterContainer extends Base {
    public static int expectedsizeofrows = myserveradminpage.getrows().size();
    public static final int expectedsizeoficons = 7;
    public static int sizeofuserstable = myserveradminpage.getrows().size();
    public static List<WebElement> rows;
    public static String loginName = "group1";
    public static final String name = "winners";
    public static final String email = "ness@gmail.com";
    public static final String passworduser = "1212";
    public static final String Editname = "the best";
    public static final String search = "MySQL";
    public static final int exceptedrow = 0;
    public static final String expectedTitle = "Welcome to Grafana";


}
