package tutorialSolution.elementInteractionSolution;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialSolution.pages.WebElementInteractionPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class ElementInteractionTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private WebElementInteractionPage page;
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, WebElementInteractionPage.class);
        driver.get(new File("src/main/resources/interactions.html").getAbsolutePath());
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void click() {

    }

    @Test
    public void sendKeys() {

    }

    @Test
    public void clear() {

    }

    @Test
    public void getText() {

    }

    @Test
    public void getAttribute() throws InterruptedException {
        //an attribute that is assigned to the WebElement
        System.out.println("Existing attribute: " + page.elementWithId.getAttribute("height"));
        assertEquals("100", page.elementWithId.getAttribute("height"));
        //an attribute that could be assigned to the WebElement (is it allowed on the WebElement as per the HTML
        // definition) but is not currently assigned
        System.out.println("Non-assigned attribute: " + page.elementWithId.getAttribute("class"));
        assertEquals("", page.elementWithId.getAttribute("class"));
        //an attribute that could never be assigned to the WebElement as it is not allowed by the HTML definition
        System.out.println("Non-existent attribute: " + page.elementWithId.getAttribute("nonExistentAttribute"));
        assertNull(page.elementWithId.getAttribute("nonExistentAttribute"));
        //attributes that appear to have multiple values
        //value of 'class' attribute is composed of multiple 'words'
        System.out.println("The value of the class attribute: " + page.disabledButton.getAttribute("class"));
        assertEquals("w3-btn w3-padding w3-border w3-purple", page.disabledButton.getAttribute("class"));
        //value of 'style' attribute refers to several properties: font size, font family
        System.out.println("The value of the style attribute: " + page.disabledButton.getAttribute("style"));
        assertEquals("font-size: 24px; font-family: verdana;", page.disabledButton.getAttribute("style"));
        assertEquals("font-size: 24px; font-family: verdana;".replaceAll("\\s", ""),
                page.disabledButton.getAttribute("style").replaceAll("\\s", ""));
        //'boolean' attributes
        //the 'checked' attribute value of a checked checkbox
        System.out.println("Checked checkbox state: " + page.checkedCheckbox.getAttribute("checked"));
        assertEquals("true", page.checkedCheckbox.getAttribute("checked"));
        //the 'checked' attribute value of an unchecked checkbox
        System.out.println("Unchecked checkbox state: " + page.uncheckedCheckbox.getAttribute("checked"));
        assertNull(page.uncheckedCheckbox.getAttribute("checked"));
        //the 'checked' attribute value of an unchecked radio button
        System.out.println("Radio button state before checking: " + page.radioButton.getAttribute("checked"));
        assertNull(page.radioButton.getAttribute("checked"));
        page.radioButton.click();
        //the 'checked' attribute value of a checked radio button
        System.out.println("Radio button state after checking: " + page.radioButton.getAttribute("checked"));
        assertEquals("true", page.radioButton.getAttribute("checked"));
        //the value of the 'disabled' attribute of the disabled button
        System.out.println("Disabled attribute of the disabled button: " + page.disabledButton.getAttribute("disabled"
        ));
        assertEquals("true", page.disabledButton.getAttribute("disabled"));
    }

    @Test
    public void getCSSValue() {

    }
}

