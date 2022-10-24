import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class LoginPageTest {

    private static final Properties property = new Properties();
    private static final String currentDir = System.getProperty("user.dir");
    private final LoginPage page = new LoginPage();

    @BeforeAll
    public static void setup() {
        FileInputStream fis;
        try {
            fis = new FileInputStream(currentDir + "\\" + "conf.properties");
            property.load(fis);
            String driverPath = property.getProperty("driverPath");
            System.setProperty("webdriver.chrome.driver", driverPath);
        } catch (IOException e) {
            System.err.println("No config file. The latest version of Chrome Driver will be used");
        }
    }


    @Test
    void login() {
        UserPage profile = page.signIn(property.getProperty("botLogin"), property.getProperty("botPassword"));
        Assertions.assertEquals(property.getProperty("botName"), profile.getUserName());
    }
}