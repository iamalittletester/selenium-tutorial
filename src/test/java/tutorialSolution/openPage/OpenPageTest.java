package tutorialSolution.openPage;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class OpenPageTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void getPageProperties() {
        //open a valid URL
        driver.get("http://www.example.com");
        //check that expected URL was opened
        assertEquals("http://www.example.com/", driver.getCurrentUrl());
        //check that the title of the page is correct
        assertEquals("Example Domain", driver.getTitle());
    }
}
