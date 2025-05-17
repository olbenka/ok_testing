package base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static data.SetUpData.*;

public abstract class BaseTest {
    @BeforeAll
    static void setUp() {
        Configuration.browser = BROWSER;
    }


}
