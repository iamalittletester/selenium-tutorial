package tutorialsolution.iframessolution;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.BasicPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class IframesTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private BasicPage page;
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, BasicPage.class);
        driver.get(new File("src/main/resources/withIframes.html").getAbsolutePath());
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void frameById() {
        //switch to frame identified by id, then interact with button from inside frame, and switch back to default
        // content
        driver.switchTo().frame("frameWithId");
        assertEquals("Inside frame with id", page.buttonForFrameWithId.getText());
        driver.switchTo().defaultContent();
    }

    @Test
    public void frameByIndex() {
        //switch to frame identified by index, then interact with button from inside frame, and switch back to
        // default content
        driver.switchTo().frame(1);
        assertEquals("Inside frame with index", page.buttonForFrameWithIndex.getText());
        driver.switchTo().defaultContent();
    }

    @Test
    public void frameAsWebElement() {
        //switch to frame identified by selector as WebElement, then interact with button from inside frame, and
        // switch back to default content
        driver.switchTo().frame(page.frameAsWebElement);
        assertEquals("Inside frame as WebElement", page.buttonForFrameWithName.getText());
        driver.switchTo().defaultContent();
    }
}
