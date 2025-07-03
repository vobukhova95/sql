package test;

import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class AuthTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldLogIn() {
        var info = DataHelper.getAuthInfo();
        var login = info.getLogin();
        LoginPage page = new LoginPage();
        var verifyPage = page.validLogin(info);
        var authCode = SQLHelper.getAuthCode(login);
        var dashBoardPage = verifyPage.validVerify(authCode);
    }
}
