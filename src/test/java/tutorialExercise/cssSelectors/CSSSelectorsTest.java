package tutorialExercise.cssSelectors;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tutorialSolution.pages.BasicPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class CSSSelectorsTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private BasicPage page;
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, BasicPage.class);
        driver.get(new File("src/main/resources/fullPage.html").getAbsolutePath());
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }



}
