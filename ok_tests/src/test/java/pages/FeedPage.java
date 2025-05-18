package pages;

import base.BasePageWithSidebar;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FeedPage extends BasePageWithSidebar {
    private final SelenideElement sidebarAvatar = $x("//*[@id='hook_Block_Avatar']");

    @Override
    protected void isLoaded() {
        sidebarAvatar.shouldBe(visible.because("Аватар должен отображаться"));
        sidebar.checkAllButtonsAreVisible();
    }

    public boolean isSidebarAvatarVisible() {
        return sidebarAvatar.is(visible);
    }
}
