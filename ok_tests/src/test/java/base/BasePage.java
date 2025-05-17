package base;

public abstract class BasePage {
    public void checkIsLoaded() {
        isLoaded();
    }
    protected abstract void isLoaded();
}
