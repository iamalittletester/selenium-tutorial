package tutorialsolution.cookies;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class CookiesTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        driver.get("https://example.com");
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void workingWithCookies() {
        //new Cookie object with only a name and value
        Cookie firstCookie = new Cookie("firstCookieName", "firstCookieValue");
        //new Cookie with name and value, set on the root path of the domain, with a specified expiryDate in the future
        Cookie secondCookie = new Cookie("secondCookieName", "secondCookieValue", "/",
                new Date(System.currentTimeMillis() + 600000));

        //before doing anything, clear all cookies in case any exist
        driver.manage().deleteAllCookies();
        //check that there are no cookies indeed
        assertEquals(0, driver.manage().getCookies().size());

        //set first cookie: only name and value are specified
        driver.manage().addCookie(firstCookie);
        //check that the cookie was set properly
        assertEquals(1, driver.manage().getCookies().size());
        assertEquals(firstCookie, driver.manage().getCookieNamed("firstCookieName"));
        driver.navigate().refresh();

        //set second cookie: name, value, path and expiry date were specified
        driver.manage().addCookie(secondCookie);
        assertEquals(2, driver.manage().getCookies().size());

        //check that the expiry date of the cookie is in the future
        int compareToResult = new Date(System.currentTimeMillis()).compareTo(driver.manage().getCookieNamed(
                "secondCookieName").getExpiry());
        assertEquals(-1, compareToResult);
        driver.navigate().refresh();

        //check what cookies are set on the domain
        Set<Cookie> expectedCookies = new HashSet<>();
        expectedCookies.add(firstCookie);
        expectedCookies.add(secondCookie);
        assertEquals(expectedCookies, driver.manage().getCookies());

        //delete second cookie by name
        driver.manage().deleteCookieNamed("secondCookieName");
        assertEquals(1, driver.manage().getCookies().size());
        Set<Cookie> expectedRemainingCookie = new HashSet<>();
        expectedRemainingCookie.add(firstCookie);
        assertEquals(expectedRemainingCookie, driver.manage().getCookies());

        //delete cookie by specifying the Cookie object used for creating the cookie
        driver.manage().deleteCookie(firstCookie);
        assertEquals(0, driver.manage().getCookies().size());
    }
}
