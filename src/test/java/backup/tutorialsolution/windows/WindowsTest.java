package backup.tutorialsolution.windows;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.WindowsPage;

import java.io.File;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WindowsTest {
    private WebDriver driver;
    private BrowserGetter browserGetter = new BrowserGetter();
    private WindowsPage page;

    @BeforeEach
    public void beforeEach() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, WindowsPage.class);
        driver.get("https://imalittletester.godaddysites.com/mainpage");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }

    @Test
    public void savingHandlesToSet() {
        //before opening any new page, get the handle of the main page
        //it will be needed later in the tes
        String mainPageWindowHandle = driver.getWindowHandle();

        //open two new pages in new windows/tabs
        page.linkToSecondPage.click();
        page.linkToThirdPage.click();
        //two new windows or tabs are open
        //first call the 'getWindowHandles()' method which returns a set of window handles
        Set<String> setOfWindowHandles = driver.getWindowHandles();
        //check that there are 3 open windows
        assertEquals(3, setOfWindowHandles.size());

        //check that the <h1> element on the second page (with url containing 'secondPage') is correct; also check
        // that there exists an open page with the url corresponding to the expected second page
        boolean foundWindow = false;
        for (String handle : setOfWindowHandles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("secondpage")) {
                driver.switchTo().defaultContent();
                driver.switchTo().frame(0);
                assertEquals("Welcome to the second page", page.h1Element.getText());
                foundWindow = true;
            }
        }
        //if this check would not be done, the for loop would exit successfully both if the expected windows was or
        // was not found
        assertTrue(foundWindow, "No such window was open");

        //switch to the main page and check that the switch was made correctly
        driver.switchTo().window(mainPageWindowHandle);
        assertTrue(driver.getCurrentUrl().contains("mainpage"));
    }

    @Test
    public void closeOneOfOpenWindows() {
        //from the main page click on both links, which will open two new windows
        page.linkToSecondPage.click();
        page.linkToThirdPage.click();

        //two new windows or tabs are open
        //check that there are 3 open windows/tabs
        assertEquals(3, driver.getWindowHandles().size());

        //close second page window/tab
        //iterate over list since you don't know which handle corresponds to second page
        Set<String> setOfWindowHandles = driver.getWindowHandles();
        for (String handle : setOfWindowHandles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("secondpage")) {
                driver.close();
            }
        }
        //check that there are now 2 open windows/tabs
        assertEquals(2, driver.getWindowHandles().size());

        //in order to continue working with the remaining pages, you will need to switch to them
        //keep in mind that the handle of the second page is not valid anymore
        //therefore you should regenerate the list of handles, for it to only contain the handles of the currently
        // open pages
        setOfWindowHandles = driver.getWindowHandles();
        //switch to the main page
        for (String handle : setOfWindowHandles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("mainpage")) {
                break;
            }
        }

        //open the second page again. It will now have a new handle. Therefore the list of handles needs to be
        // regenerated if you want to work with any of the windows
        //if not, just check that now there are three open windows
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        page.linkToSecondPage.click();
        assertEquals(3, driver.getWindowHandles().size());
    }
}
