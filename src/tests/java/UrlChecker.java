import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class UrlChecker {

    @BeforeAll
    public static void setup() {
        FileInputStream fis;
        Properties property = new Properties();
        String currentDir = System.getProperty("user.dir");
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
    public void CheckURL() {
        String url = "https://ok.ru/";
        open(url);
        String currentURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(url, currentURL);
    }

}
