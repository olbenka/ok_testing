package tests.posts;

import base.BaseTest;
import data.objects.User;
import data.objects.UserData;
import org.junit.jupiter.api.*;
import pages.FeedPage;
import pages.LoginPage;
import pages.elements.PostElement;

import static com.codeborne.selenide.Selenide.*;
import static data.SetUpData.LOGIN_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("feed")
@DisplayName("Тесты с постами в ленте")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FeedLikeTests extends BaseTest {
    private FeedPage feedPage;
    private final User user = UserData.VALID_USER;

    @BeforeAll
    void loginAndOpenFeed() {
        open(LOGIN_URL);
        feedPage = new LoginPage()
                .typeEmail(user.email())
                .typePassword(user.password())
                .clickLoginSuccess();
        feedPage.checkIsLoaded();
    }

    @Test
    @DisplayName("Поставить лайк первому посту в ленте")
    void likeFirstPostTest() {
        PostElement firstPost = feedPage.getFirstPostWithLike();
        firstPost.like();
        assertTrue(firstPost.likeButton()
                .exists(), "Кнопка лайка существует после клика");
    }

    @AfterAll
    void tearDown() {
        closeWebDriver();
    }
}
