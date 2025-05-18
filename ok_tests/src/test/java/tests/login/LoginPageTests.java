package tests.login;

import base.BaseTest;
import org.junit.jupiter.api.*;
import pages.FeedPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static data.ErrorMessagesData.*;
import static data.SetUpData.*;
import static data.UserData.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTests extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    void openPage() {
        open(LOGIN_URL);
        loginPage = new LoginPage();
        loginPage.checkIsLoaded();
    }

    @Nested
    @Tag("negative")
    @DisplayName("Негативные сценарии авторизации")
    class NegativeLoginTests {
        @Test
        @DisplayName("Неверный логин и пароль")
        void invalidLoginTest() {
            loginPage.typeEmail(INVALID_EMAIL)
                    .typePassword(INVALID_PASSWORD)
                    .clickLogin();

            String actualError = loginPage.getLoginErrorText();
            assertEquals(EXPECTED_ERROR_INVALID_LOGIN, actualError,
                    "Сообщение об ошибке некорректного логина не совпадает с ожидаемым");
        }

        @Test
        @DisplayName("Поля логина и пароля пустые")
        void emptyFieldsTest() {
            loginPage.clickLogin();

            String actualError = loginPage.getLoginErrorText();
            assertEquals(EXPECTED_ERROR_EMPTY_LOGIN, actualError,
                    "Сообщение об ошибке при пустом логине не совпадает с ожидаемым");
        }

        @Test
        @DisplayName("Пустой пароль")
        void emptyFieldPasswordTest() {
            loginPage.typeEmail(INVALID_EMAIL)
                    .clickLogin();

            String actualError = loginPage.getLoginErrorText();
            assertEquals(EXPECTED_ERROR_EMPTY_PASSWORD, actualError,
                    "Сообщение об ошибке при пустом пароле не совпадает с ожидаемым");
        }
    }

    @Nested
    @Tag("positive")
    @DisplayName("Позитивные сценарии авторизации")
    class PositiveLoginTests {
        @Test
        @DisplayName("Успешная авторизация через кнопку 'Войти в Одноклассники'")
        void successfulLoginWithButtonTest() {
            FeedPage feedPage = loginPage.typeEmail(VALID_EMAIL)
                    .typePassword(VALID_PASSWORD)
                    .clickLoginSuccess();

            assertTrue(feedPage.isSidebarAvatarVisible(),
                    "Аватарка на боковой панели не отображается"
            );
        }
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
