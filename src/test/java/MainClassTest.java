import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SuiteDisplayName("FirstSuite")
public class MainClassTest {
    @Test
    public void testHelloWorld() {
        Assertions.assertEquals("hallo, World!", MainClass.getHelloWorld());
    }
}