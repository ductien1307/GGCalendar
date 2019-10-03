package lib.extendReport;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SingleLogTest extends BaseExample {
    @Test
    public void passTest() {
        test = extent.startTest("passTest");
        test.log(LogStatus.PASS, "Pass");
        Assert.assertEquals(test.getRunStatus(), LogStatus.PASS);
        test.log(LogStatus.PASS, "Pass");
    }

    @Test
    public void intentionalFailure() throws Exception {
        test = extent.startTest("intentionalFailure");
        //throw new Exception("intentional failure");
    }
    @Test
    public void testcase01() throws Exception {
        test = extent.startTest("testcase01");
        test.log(LogStatus.PASS, "Pass");
    }
}
