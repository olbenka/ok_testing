package pages;

import com.codeborne.selenide.SelenideElement;
import base.BasePage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {
    private final SelenideElement emailField = $x("//*[@id='field_email']");
    private final SelenideElement passwordField = $x("//*[@id='field_password']");
    private final SelenideElement loginButton = $x(".//input[@type='submit']");
    private final SelenideElement loginError = $x("//*[contains(@class, 'login_error')]");

    @Override
    protected void isLoaded() {
        emailField.shouldBe(visible.because("Поле email должно быть видно при загрузке"));
        passwordField.shouldBe(visible.because("Поле пароля должно быть видно при загрузке"));
        loginButton.shouldBe(visible.because("Кнопка входа должна быть видна"));
    }
    public LoginPage typeEmail(String email) {
        emailField.shouldBe(visible.because("Поле ввода email не отображается"))
                .setValue(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.shouldBe(visible.because("Поле ввода пароля не отображается"))
                .setValue(password);
        return this;
    }

    public void clickLogin() {
        loginButton.shouldBe(visible.because("Кнопка входа не отображается"))
                .scrollTo()
                .click();
    }

    public String getLoginErrorText() {
        return loginError.shouldBe(visible.because("Ошибка не отображается")).getText();
    }

}
