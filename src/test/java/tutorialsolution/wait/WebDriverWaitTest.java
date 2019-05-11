package tutorialsolution.wait;

import browser.BrowserGetter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tutorialsolution.pages.WebElementInteractionPage;
import waiter.Waiter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebDriverWaitTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private Waiter waiter = new Waiter();
    private WebElementInteractionPage page;
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, WebElementInteractionPage.class);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get(new File("src/main/resources/interactions.html").getAbsolutePath());
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void click() {
        //checking a checkbox
        waiter.click(page.checkboxToClick, driver);
        //unchecking the checkbox
        waiter.click(page.checkboxToClick, driver);
        //checking a radio button
        waiter.click(page.radioButtonToClick, driver);
        //clicking a button which triggers the display of a message
        waiter.click(page.buttonToClick, driver);
        //clicking on a link which causes a redirect to another page
        waiter.click(page.linkToClick, driver);
    }

    @Test
    public void sendKeys() {
        //type into an <input> HTML element whose 'type' attribute is 'text'
        page.textInput.sendKeys("coffee");
        waiter.waitForElementAttributeEqualsString(page.textInput, "value", "coffee", driver);
        //type into a <textarea> element
        //before typing, the textarea element displays a hint, but not an actual text (in the 'placeholder' attribute)
        //therefore the getAttribute("value") method call returns an empty String
        waiter.waitForElementAttributeEqualsString(page.textarea, "value", "", driver);
        page.textarea.sendKeys("1234567890");
        //after typing, the text in the field will be "1234567890"
        waiter.waitForElementAttributeEqualsString(page.textarea, "value", "1234567890", driver);
        //type the same text again and the text in the field becomes "12345678901234567890"
        page.textarea.sendKeys("1234567890");
        waiter.waitForElementAttributeEqualsString(page.textarea, "value", "12345678901234567890", driver);
    }

    @Test
    public void clear() {
        //type into an <input> HTML element whose 'type' attribute is 'text'
        page.textInput.sendKeys("coffee");
        waiter.waitForElementAttributeEqualsString(page.textInput, "value", "coffee", driver);
        //clear the textInput field, retype the String "coffee"
        page.textInput.clear();
        page.textInput.sendKeys("coffee");
        waiter.waitForElementAttributeEqualsString(page.textInput, "value", "coffee", driver);

        page.textarea.sendKeys("1234567890");
        //after typing, the text in the field will be "1234567890"
        waiter.waitForElementAttributeEqualsString(page.textarea, "value", "1234567890", driver);        //clear the field
        page.textarea.clear();
        //type the same text again and the text in the field becomes "1234567890"
        page.textarea.sendKeys("1234567890");
        waiter.waitForElementAttributeEqualsString(page.textarea, "value", "1234567890", driver);
    }

    @Test
    public void getText() {
        //clear the text of <textarea> element, and check that getText() still return the initial text that was
        // placed inside the tag
        page.getTextTextarea.clear();
        waiter.waitForElementTextEqualsString(page.getTextTextarea, "Predefined text", driver);
        waiter.waitForElementAttributeEqualsString(page.getTextTextarea, "value", "", driver);

        //type text in the text area. getText() returns initial text. getAttribute("value") returns newly typed text
        page.getTextTextarea.sendKeys("New text");
        waiter.waitForElementTextEqualsString(page.getTextTextarea, "Predefined text", driver);
        waiter.waitForElementAttributeEqualsString(page.getTextTextarea, "value", "New text", driver);
    }

}
