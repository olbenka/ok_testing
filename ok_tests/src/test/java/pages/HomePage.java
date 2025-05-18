package pages;

import base.BasePageWithSidebar;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BasePageWithSidebar {
    private final SelenideElement avatar = $x("//*[@id='hook_Block_Avatar']");

    @Override
    protected void isLoaded() {
        avatar.shouldBe(visible.because("Аватар должен отображаться"));
    }

    public boolean isAvatarVisible() {
        return avatar.is(visible);
    }
}
