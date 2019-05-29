package ntd2019;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.TabsPage;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WindowsAndTabsTest {
    private WebDriver driver;
    private BrowserGetter browserGetter = new BrowserGetter();
    private TabsPage page;

    @BeforeAll
    public void beforeAll() {
        driver = browserGetter.getChromeDriver();
        page = PageFactory.initElements(driver, TabsPage.class);
        driver.get("https://imalittletester.godaddysites.com/mainpage");
        driver.switchTo().frame(0);
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void theTest() throws InterruptedException {
        String mainWindowHandle = driver.getWindowHandle();
        page.linkToSecondPage.click();
        Thread.sleep(1000);
        page.linkToThirdPage.click();
        Thread.sleep(1000);

        Set<String> windowHandles = driver.getWindowHandles();
        assertEquals(3, windowHandles.size());
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("secondpage")) {
                break;
            }
        }
        driver.switchTo().frame(0);
        System.out.println(page.h1.getText());
        driver.switchTo().defaultContent();
        driver.close();
        assertEquals(2, driver.getWindowHandles().size());

        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(5000);
        driver.switchTo().frame(0);
        page.linkToSecondPage.click();
        Thread.sleep(1000);
        assertEquals(3, driver.getWindowHandles().size());

    }
}
