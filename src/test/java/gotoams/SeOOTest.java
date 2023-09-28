package gotoams;

import browser.BrowserGetter;
import objects.Article;
import objects.Image;
import objects.Link;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SeOOPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SeOOTest {
    private BrowserGetter browserGetter = new BrowserGetter();
    private WebDriver driver;
    private SeOOPage page;

    @BeforeAll
    public void beforeAll() {
        driver = browserGetter.getChromeDriver();
        page = PageFactory.initElements(driver, SeOOPage.class);
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get(new File("src/main/resources/goto.html").getAbsolutePath());
        Thread.sleep(2000);
        Article expectedArticle = new Article(new Image("http://www.gotoams.nl", "250", "250"), "Tags: smth",
                new Link("https://imalittletester.com", "Testing"));
        Article actualArticle = new Article(page.elements.get(0));
        assertEquals(expectedArticle, actualArticle);
    }
}






