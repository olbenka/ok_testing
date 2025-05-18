package pages;

import base.BasePageWithSidebar;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import pages.elements.PostElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class FeedPage extends BasePageWithSidebar {
    private final SelenideElement sidebarAvatar = $x("//*[@id='hook_Block_Avatar']");
    private final ElementsCollection posts = $$x("//*[contains(@class,'feed-w')]");

    @Override
    protected void isLoaded() {
        sidebarAvatar.shouldBe(visible.because("Аватар должен отображаться"));
        sidebar.checkAllButtonsAreVisible();
    }

    public boolean isSidebarAvatarVisible() {
        return sidebarAvatar.is(visible);
    }


    //TODO: временное решение для нахождения постов с кнопкой Класс
    public PostElement getFirstPostWithLike() {
        return posts.stream()
                .map(PostElement::new)
                .filter(post -> post.likeButton().exists())
                .findFirst()
                .orElseThrow(() -> new AssertionError("Нет ни одного поста с кнопкой Класс!"));
    }
}
