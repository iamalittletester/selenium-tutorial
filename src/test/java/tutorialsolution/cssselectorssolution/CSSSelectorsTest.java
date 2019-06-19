package tutorialsolution.cssselectorssolution;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.BasicPage;

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

    //test for a WebElement identified by ID
    //uniqueness = id
    @Test
    public void elementWithID() {
        assertEquals("This is the module with id", page.elementWithId.getAttribute("alt"));
    }

    //test for a WebElement identified by a single class
    //no uniqueness : first element with specified class
    @Test
    public void elementWithSingleClass() {
        assertEquals("One class", page.elementWithSingleClass.getText());
    }

    //test for a WebElement identified by multiple classes
    //uniqueness = specifying all the classes
    @Test
    public void elementWithMultipleClasses() {
        assertEquals("Many classes", page.elementWithMultipleClasses.getText());
    }

    //test for a WebElement with tag name identifier, like: h2, h3, p
    //uniqueness = on this page, there is only one h2, only one h3 and only one p
    @Test
    public void elementsWithTagNameIdentifier() {
        assertEquals("This is a H2 text", page.h2Element.getText());
        assertEquals("This is a H3 text", page.h3Element.getText());
        assertEquals("This is a text in a P", page.pElement.getText());
    }

    //just print text from the first div on the page
    //no uniqueness: first element of this type
    @Test
    public void firstDivOnPage() {
        System.out.println(page.divElement.getText());
    }

    //just print the text from all the divs on the page, on new lines each
    //all elements of same type from page are in the list
    @Test
    public void allDivsOnPage() {
        for (WebElement element : page.divElements) {
            System.out.println(element.getText());
        }
    }

    //print the text from the second div
    //pick an element from the list of all divs
    @Test
    public void secondDivOnPage() {
        System.out.println(page.divElements.get(1).getText());
    }

    //image with specified width
    //uniqueness = the only image with the width equal to 189
    @Test
    public void imageWithSpecifiedWidth() {
        System.out.println(page.imageWithSpecifiedWidth.getAttribute("src"));
    }

    //image whose "src" attribute contains 1878
    //uniqueness = only image on page whose src attribute contains 1878
    @Test
    public void imageWithSrcContains() {
        System.out.println(page.imageWithSrcContains.getAttribute("width"));
    }

    //first button from the relative module
    //uniqueness = id of containing module + button class as being the first such class right below the tag with the id
    @Test
    public void firstButtonInRelativeModule() {
        assertEquals("First button", page.firstButtonInRelativeModule.getText());
    }

    //thid button from the relative module
    //uniquness = the list + position
    @Test
    public void thirdButtonInRelativeModule() {
        assertEquals("Third button", page.allButtonsInRelativeModule.get(2).getText());
    }

    //element of a list without unique identifier, without known position (might be different each time)
    //uniqueness = element text
    @Test
    public void elementWhoseTextIsUnique() {
        for (int i = 0; i < page.listElements.size(); i++) {
            if (page.listElements.get(i).getText().equals("Americano")) {
                System.out.println("It is the " + i + "-th element");
            }
        }
    }

    @Test
    public void strategiesDemonstrated() {
        //level 2 no siblings
        System.out.println(page.level2.getText());
        //level 2 with siblings of different tags than item ALPHA
        System.out.println(page.level2SiblingsWithDifferentTags.getText());
        //level 2 with siblings of same tag as item ALPHA
        System.out.println(page.level2SiblingsSameTag.get(1).getText());
        //level 2 with siblings of same tag as item ALPHA but ALPHA has class
        System.out.println("level2SiblingsSameTagAndAlphaHasClass" + page.level2SiblingsSameTagAndAlphaHasClass.getText());
        //level 2 : dropdown
        System.out.println(page.dropdownOptions.get(2).getText());
        //unordered list
        System.out.println(page.unorderedList.get(2).getText());
        //ordered list
        System.out.println(page.orderedList.get(2).getText());
        //level 3, no siblings, ALPHA != BRAVO
        System.out.println(page.level3.getText());
        //level 3, no siblings, ALPHA=BRAVO
        System.out.println(page.level3AlphaEqualsBravo.getText());
        //level 3, no siblings, ALPHA=BRAVO
        System.out.println("level3AlphaEqualsBravoAlphaHasClass" + page.level3AlphaEqualsBravoAlphaHasClass.getText());
        //level 3, siblings on BRAVO level: ALPHA=h3, BRAVO=div
        //level 3, BRAVO has siblings, all BRAVO's children have same tag as ALPHA
        System.out.println(page.level3BravoIdenticalSiblings.get(1).getText());
        System.out.println(page.level3BravoIdenticalSiblings.size());
        //level 3, BRAVO has siblings, BRAVO has children, all siblings and children have same tag
        System.out.println(page.level3AllIdentical.get(1).getText());
        System.out.println(page.level3AllIdentical.size());
        //level 3, one BRAVO, ALPHA has siblings
        System.out.println(page.level3OneBravoSeveralAlphas.get(1).getText());
    }


}
