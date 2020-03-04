package betlista.springTests.springBootTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test,live")
public class YMLUnitTest {

    @Autowired
    private YMLProps ymlProps;

    @Autowired
    private Environment env;

    @Test
    public void testYmlProps() {
        String[] activeProfiles = env.getActiveProfiles();
        Assert.assertEquals("live", activeProfiles[1]); // Active profile is 'live'
        Assert.assertEquals("t-live", ymlProps.getName()); // Fails here!
    }

}
