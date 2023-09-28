package ntd2019;

import browser.BrowserGetter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.InteractionsPage;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CookieTest {
    private WebDriver driver;
    private BrowserGetter browserGetter = new BrowserGetter();

    @BeforeAll
    public void beforeAll() {
        driver = browserGetter.getChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://example.com/");
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void addCookie() {
        Cookie firstCookie = new Cookie("firstCookie", "goodCookie");
        Cookie secondCookie = new Cookie("secondCookie", "badCookie");
        driver.manage().addCookie(firstCookie);
        driver.manage().addCookie(secondCookie);
        driver.navigate().refresh();

        assertEquals(2, driver.manage().getCookies().size());

        driver.manage().deleteAllCookies();
        assertEquals(0, driver.manage().getCookies().size());
    }
}
