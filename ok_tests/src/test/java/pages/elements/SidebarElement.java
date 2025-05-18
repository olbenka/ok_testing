package pages.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class SidebarElement {
    private final SelenideElement profileButton = $x("//a[contains(@data-l, 'userPage')]");
    private final SelenideElement feedButton = $x("//a[contains(@data-l, 'userMain')]");
    private final SelenideElement hobbyButton = $x("//a[contains(@data-l, 'hobby')]");
    private final SelenideElement friendsButton = $x("//a[contains(@data-l, 'userFriend')]");
    private final SelenideElement photosButton = $x("//a[contains(@data-l, 'userPhotos')]");
    private final SelenideElement groupsButton = $x("//a[contains(@data-l, 'userAltGroup')]");

    private final SelenideElement gamesButton = $x("//a[contains(@data-l, 'appsShowcaseHD')]");
    private final SelenideElement giftsButton = $x("//a[contains(@data-l, 'giftsFront')]");
    private final SelenideElement discoveryButton = $x("//a[contains(@data-l, 'discovery')]");
    private final SelenideElement servicesButton = $x("//a[contains(@data-l, 'bizApps')]");
    private final SelenideElement datingButton = $x("//a[contains(@data-l, 'appsDating')]");

    public void checkAllButtonsAreVisible() {
        profileButton.shouldBe(visible.because("Кнопка 'Профиль' не видна"));
        feedButton.shouldBe(visible.because("Кнопка 'Лента' не видна"));
        hobbyButton.shouldBe(visible.because("Кнопка 'Хобби' не видна"));
        friendsButton.shouldBe(visible.because("Кнопка 'Друзья' не видна"));
        photosButton.shouldBe(visible.because("Кнопка 'Фото' не видна"));
        groupsButton.shouldBe(visible.because("Кнопка 'Группы' не видна"));
        gamesButton.shouldBe(visible.because("Кнопка 'Игры' не видна"));
        giftsButton.shouldBe(visible.because("Кнопка 'Подарки' не видна"));
        discoveryButton.shouldBe(visible.because("Кнопка 'Рекомендации' не видна"));
        servicesButton.shouldBe(visible.because("Кнопка 'Приложения' не видна"));
        datingButton.shouldBe(visible.because("Кнопка 'Знакомства' не видна"));
    }

    public void goToProfile() {
        profileButton.shouldBe(visible.because("Кнопка 'Профиль' не видна"))
                .click();
    }

    public void goToFeed() {
        feedButton.shouldBe(visible.because("Кнопка 'Лента' не видна"))
                .click();
    }

    public void goToFriends() {
        friendsButton.shouldBe(visible.because("Кнопка 'Друзья' не видна"))
                .click();
    }

}
