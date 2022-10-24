import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UserPage {
    private final SelenideElement userName = $("#hook_Block_Navigation > " +
            "div > div > div:nth-child(1) > a > div");
    public String getUserName() {
        return userName.text();
    }
}
