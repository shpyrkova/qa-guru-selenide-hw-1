import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GithubSelenideSoftAssertionsPageTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void jUnit5ShouldBeInSoftAssertions() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(byText("Show 3 more pages…")).click();
        $("[data-filterable-for=wiki-pages-filter]").lastChild().preceding(0).shouldHave(text("SoftAssertions"));
        $(byText("Soft assertions")).click(); // таких элемента два, но нам ведь неважно здесь, куда кликать
        $("#user-content-3-using-junit5-extend-test-class").preceding(0).shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
