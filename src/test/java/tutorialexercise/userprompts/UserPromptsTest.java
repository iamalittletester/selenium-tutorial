package tutorialexercise.userprompts;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.UserPromptsPage;

import java.io.File;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class UserPromptsTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private UserPromptsPage page;
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, UserPromptsPage.class);
        driver.get(new File("src/main/resources/userPrompts.html").getAbsolutePath());
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }


}
