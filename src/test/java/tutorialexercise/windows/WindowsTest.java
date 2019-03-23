package tutorialexercise.windows;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.WindowsPage;

import java.io.File;

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
        driver.get(new File("src/main/resources/mainPage.html").getAbsolutePath());
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
