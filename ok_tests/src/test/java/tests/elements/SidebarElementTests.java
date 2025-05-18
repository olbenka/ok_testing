package tests.elements;

import base.BasePageWithSidebar;
import base.BaseTest;
import data.objects.User;
import data.objects.UserData;
import org.junit.jupiter.api.*;
import pages.FeedPage;
import pages.FriendsPage;
import pages.HomePage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.*;
import static data.SetUpData.LOGIN_URL;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("sidebar")
@DisplayName("Переходы по сайдбару")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SidebarElementTests extends BaseTest {
    private BasePageWithSidebar currentPage;
    private final User user = UserData.VALID_USER;

    @BeforeAll
    void loginAndOpenHomePage() {
        open(LOGIN_URL);
        currentPage = new LoginPage()
                .typeEmail(user.email())
                .typePassword(user.password())
                .clickLoginSuccess();
    }

    @Test
    @DisplayName("Переход в Профиль через Sidebar")
    void goToProfileFromSidebarTest() {
        currentPage.getSidebar().goToProfile();

        HomePage homePage = new HomePage();
        homePage.checkIsLoaded();

        assertTrue(homePage.isAvatarVisible(),
                "Аватар не отображается"
        );

        currentPage = homePage;
    }

    @Test
    @DisplayName("Переход в Новости через Sidebar")
    void goToFeedFromSidebarTest() {
        currentPage.getSidebar().goToFeed();

        FeedPage feedPage = new FeedPage();
        feedPage.checkIsLoaded();

        assertTrue(feedPage.isSidebarAvatarVisible(),
                "Аватар на боковой панели не отображается"
        );

        currentPage = feedPage;
    }

    @Test
    @DisplayName("Переход в Друзья через Sidebar")
    void goToFriendsFromSidebar() {
        currentPage.getSidebar().goToFriends();

        FriendsPage friendsPage = new FriendsPage();
        friendsPage.checkIsLoaded();

        assertTrue(friendsPage.isMyFriendsBlockVisible(),
                "Блок друзей не отображается"
        );

        currentPage = friendsPage;
    }


    @AfterAll
    void tearDown() {
        closeWebDriver();
    }

}
