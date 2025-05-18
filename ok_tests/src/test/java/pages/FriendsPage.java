package pages;

import base.BasePageWithSidebar;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class FriendsPage extends BasePageWithSidebar {
    private final SelenideElement myFriendsBlock = $x("//div[@id='hook_Block_MyFriendsMRB']");
    @Override
    protected void isLoaded() {
        myFriendsBlock.shouldBe(visible.because("Блок друзей должен отображаться"));
    }

    public boolean isMyFriendsBlockVisible(){
        return myFriendsBlock.is(visible);
    }
}
