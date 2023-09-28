package tutorialexercise.navigation;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.WebElementInteractionPage;

import java.io.File;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private WebElementInteractionPage page;
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, WebElementInteractionPage.class);
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void navigation() {
        driver.get(new File("src/main/resources/interactions.html").getAbsolutePath());
    }
}
