package pages.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class PostElement {
    private final SelenideElement root;
    public PostElement(SelenideElement root) {
        this.root = root;
    }

    public SelenideElement likeButton() {
        return root.$x(".//span[contains(@class, 'js-klass-action')]");
    }

    public void like() {
        likeButton().shouldBe(visible.because("Кнопка Класс не отображается"))
                .click();
    }
}
