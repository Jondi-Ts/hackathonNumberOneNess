package extensions;

import org.testng.Assert;

public class Verfications {

    public static void verifyEquals(Object actual, Object expected){
        Assert.assertEquals(actual,expected);
    }

    public  static  void verifyTrue(Boolean condition)
    {
        Assert.assertTrue(condition);
    }

}
