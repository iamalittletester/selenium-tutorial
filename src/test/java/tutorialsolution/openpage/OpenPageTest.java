package tutorialsolution.openpage;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

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
    public void getPageProperties() throws MalformedURLException {
        //open a valid URL
        driver.get("http://www.example.com");
        //check that expected URL was opened
        assertEquals("http://www.example.com/", driver.getCurrentUrl());
        //check that the title of the page is correct
        assertEquals("Example Domain", driver.getTitle());

        //other valid urls
        driver.get("https://www.example.com");
        driver.get("http://example.com");
        driver.get("https://example.com");

        //open a page with navigate.to() and String parameter
        driver.navigate().to("https://www.example.com");
        assertEquals("https://www.example.com/", driver.getCurrentUrl());

        //open a page with navigate.to() and URL parameter
        driver.navigate().to(new URL("http://example.com"));
        assertEquals("http://example.com/", driver.getCurrentUrl());
    }
}
