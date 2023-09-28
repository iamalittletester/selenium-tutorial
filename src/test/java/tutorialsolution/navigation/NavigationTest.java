package tutorialsolution.navigation;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.WebElementInteractionPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        //the expected url which should be loaded in the browser after clicking a link (second url)
        String redirectUrl = "https://www.example.com/";

        //opening the page on which a link exists and checking that the correct url opened (first url)
        //click the link and check that a different url opened (the redirect url)
        driver.get(new File("src/main/resources/interactions.html").getAbsolutePath());
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("interactions.html"));
        page.linkToClick.click();
        assertEquals(redirectUrl, driver.getCurrentUrl());

        //go back and check that the first url is loaded
        driver.navigate().back();
        assertEquals(currentUrl, driver.getCurrentUrl());

        //go forward and check that the second url is loaded
        driver.navigate().forward();
        assertEquals(redirectUrl, driver.getCurrentUrl());

        //refresh the page and check that the second url is still loaded
        driver.navigate().refresh();
        assertEquals(redirectUrl, driver.getCurrentUrl());
    }
}
