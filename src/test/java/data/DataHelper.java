package data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;

public class DataHelper {

    private DataHelper() {
    }

    private static final Faker faker = new Faker();

    public static String generateLogin() {
        return faker.name().username();
    }

    public static String generatePassword() {
        return faker.internet().password();
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class AuthInfo {
        private String login;
        private String password;
    }
}
