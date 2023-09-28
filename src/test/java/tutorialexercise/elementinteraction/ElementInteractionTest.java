package tutorialexercise.elementinteraction;

import browser.BrowserGetter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.WebElementInteractionPage;

import java.io.File;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class ElementInteractionTest {
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

    @BeforeEach
    public void beforeEach() {
        driver.get(new File("src/main/resources/interactions.html").getAbsolutePath());
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void click() {

    }

    @Test
    public void sendKeys() {

    }

    @Test
    public void clear() {

    }

    @Test
    public void getText() {

    }

    @Test
    public void getAttribute() {

    }

    @Test
    public void select() {

    }

    @Test
    public void getCssValue() {

    }
}

