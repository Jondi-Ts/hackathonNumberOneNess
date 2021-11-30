package extensions;

import Utilities.CommonOps;
import org.testng.Assert;

public class Verfications extends CommonOps {

    public static void verifyEquals(Object actual, Object expected){
        Assert.assertEquals(actual,expected);
    }

    public  static  void verifyTrue(Boolean condition)
    {
        Assert.assertTrue(condition);
    }

}
