import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage {
    public LoginPage() {
        openPage();
    }

    private final String url = "https://www.ok.ru";
    private final SelenideElement loginForm = $(By.name("st.email"));
    private final SelenideElement passwordForm = $(By.name("st.password"));
    private final SelenideElement signInButton = $("#anonymPageContent > div > " +
            "div.anon-main-design21_central-panel > div.clearfix.js-tab-login-form.anon-main-design21_tab-login " +
            "> div > div.tab-filter-with-body > div.tab-body > div.js-login-state.state-default-padding-small " +
            "> form > div.login-form-actions > input");

    public LoginPage openPage() {
        open(url);
        return this;
    }

    public LoginPage setLogin(String login) {
        loginForm.setValue(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        passwordForm.sendKeys(password);
        return this;
    }

    public UserPage pressSignInButton() {
        signInButton.click();
        return new UserPage();
    }

    public UserPage signIn(String login, String password) {
        setLogin(login);
        setPassword(password);
        return pressSignInButton();
    }
}




