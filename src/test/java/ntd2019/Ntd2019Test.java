package ntd2019;

import browser.BrowserGetter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import pages.InteractionsPage;
import waiter.Waiter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Ntd2019Test {
    private WebDriver driver;
    private BrowserGetter browserGetter = new BrowserGetter();
    private InteractionsPage page;
private Waiter waiter = new Waiter();

    @BeforeAll
    public void beforeAll() {
        driver = browserGetter.getDriver();
        page = PageFactory.initElements(driver, InteractionsPage.class);
        waiter.get("https://imalittletester.godaddysites.com/interactions", driver);

    }

    @BeforeEach
    public void beforeEach() {
        driver.switchTo().defaultContent();
        assertEquals("https://imalittletester.godaddysites.com/interactions", driver.getCurrentUrl());
        driver.switchTo().frame(0);
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void clickTest() throws InterruptedException {
        waiter.click(page.checkbox, driver);
        waiter.waitForElementAttributeEqualsString(page.checkbox, "checked", "true", driver);

//        page.checkbox.click();
//        Thread.sleep(1000);
//        assertNull(page.checkbox.getAttribute("checked"));
//
//        assertNull(page.radioButton.getAttribute("checked"));
//        page.radioButton.click();
//        Thread.sleep(1000);
//        assertEquals("true", page.radioButton.getAttribute("checked"));
//

        waiter.click(page.link, driver);
        waiter.waitForUrl("https://www.example.com/", driver);
        waiter.waitForElementTextEqualsString(page.h1, "Example Domain", driver);

    }

    @Test
    public void sendKeysTest() throws InterruptedException {
        page.textInput.sendKeys("007");
        Thread.sleep(1000);

        page.textInput.clear();
        Thread.sleep(1000);

        page.textInput.sendKeys("009");
        Thread.sleep(1000);

        page.textArea.sendKeys("008");

        System.out.println("---------" + page.predefinedTextArea.getText());
        page.predefinedTextArea.clear();
        page.predefinedTextArea.sendKeys("New text");
        Thread.sleep(5000);

    }

    @Test
    public void getAttributeTest() {
        assertEquals("100", page.img.getAttribute("width"));
        System.out.println(page.disabledButton.getAttribute("disabled"));
    }

    @Test
    public void getTextTest() {
        assertEquals("Link", page.link.getText());
        assertEquals("H5 text", page.h5.getText());
        assertEquals("dummy", page.div.getText());
    }

    @Test
    public void getCssValueTest() {
        System.out.println(page.container.getCssValue("width"));
        System.out.println(page.h2.getCssValue("font-family"));
    }

    @Test
    public void selectFromDropdown() throws InterruptedException {
        Select refreshmentSelect = new Select(page.refreshmentSelectWebElement);
        refreshmentSelect.selectByValue("4");
        refreshmentSelect.selectByVisibleText("Sparkling Water");
        Thread.sleep(4000);
        refreshmentSelect.deselectAll();
        Thread.sleep(4000);
    }

    @Test
    public void navigation() throws InterruptedException {
        page.link.click();
        Thread.sleep(3000);
        assertEquals("https://www.example.com/", driver.getCurrentUrl());
        driver.navigate().back();
        Thread.sleep(3000);
        assertTrue(driver.getCurrentUrl().contains("interactions"));

        driver.navigate().forward();
        Thread.sleep(3000);
        assertEquals("https://www.example.com/", driver.getCurrentUrl());

        driver.navigate().refresh();
        Thread.sleep(3000);
        assertEquals("https://www.example.com/", driver.getCurrentUrl());
    }
}
