package tutorialsolution.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasicPage {
    //WebElement with ID
    @FindBy(css = "#idModuleImage")
    public WebElement elementWithId;
    //WebElement with single class (the first element found that has this class)
    @FindBy(css = ".w3-btn")
    public WebElement elementWithSingleClass;
    //WebElement with multiple classes
    @FindBy(css = ".w3-btn.w3-padding.w3-border.w3-sand")
    public WebElement elementWithMultipleClasses;
    //WebElements with tag name identifier, like h2, h3, p
    @FindBy(css = "h2")
    public WebElement h2Element;
    @FindBy(css = "h3")
    public WebElement h3Element;
    @FindBy(css = "p")
    public WebElement pElement;
    @FindBy(css = "div")
    public WebElement divElement;
    //list of all the divs on the page
    @FindBy(css = "div")
    public List<WebElement> divElements;
    //image whose width attribute equals 189
    @FindBy(css = "[width='189'][height='125']")
    public WebElement imageWithSpecifiedWidth;
    //image whose sources (src) attribute contains 1878
    @FindBy(css = "[src*='1878']")
    public WebElement imageWithSrcContains;
    //relativity: first button from the module with id relativeModule
    @FindBy(css = "#relativeModule button")
    public WebElement firstButtonInRelativeModule;
    //relativity: all buttons from the module with id relativeModule
    @FindBy(css = "#relativeModule button")
    public List<WebElement> allButtonsInRelativeModule;
    //element whose text is an expected one; we just know it is an element with identifier "li", and there are
    // several elements with this identifier
    @FindBy(css = "li")
    public List<WebElement> listElements;

    //Strategies demonstrated
    @FindBy(css = "#level2 h3")
    public WebElement level2;
    @FindBy(css = "#level2SiblingsDiffTags h3")
    public WebElement level2SiblingsWithDifferentTags;
    @FindBy(css = "#level2SiblingsSameTag h3")
    public List<WebElement> level2SiblingsSameTag;
    @FindBy(css = "#level2SiblingsSameTagAndClass .someClass")
    public WebElement level2SiblingsSameTagAndAlphaHasClass;
    @FindBy(css = "select[name='BRAVO'] option")
    public List<WebElement> dropdownOptions;
    @FindBy(css = "#BRAVOUL li")
    public List<WebElement> unorderedList;
    @FindBy(css = "#BRAVOOL li")
    public List<WebElement> orderedList;
    @FindBy(css = "#level3 h3")
    public WebElement level3;
    @FindBy(css = "#level3AEqualsB div div")
    public WebElement level3AlphaEqualsBravo;
    @FindBy(css = "#level3AEqualsBAHasClass .w3-red")
    public WebElement level3AlphaEqualsBravoAlphaHasClass;
    @FindBy(css = "#level3BravoIdenticalSiblings h3") public List<WebElement> level3BravoIdenticalSiblings;
    @FindBy(css = "#level3AllIdenticalSiblings div div") public List<WebElement> level3AllIdentical;
    @FindBy(css = "#level3OneBravoSeveralAlphas h3") public List<WebElement> level3OneBravoSeveralAlphas;

    //iframes page
    //button found inside the frame identified by id
    @FindBy(css = "#btnForFrameWithId") public WebElement buttonForFrameWithId;
    //button found inside the frame identified by index
    @FindBy(css = "#btnForFrameWithIndex") public WebElement buttonForFrameWithIndex;
    //button found inside the frame identified as a WebElement
    @FindBy(css = "#btnForFrameAsWebElement") public WebElement buttonForFrameWithName;
    //selector for identifying frame as WebElement (when frame has no id, name and will not be identified by index)
    @FindBy(css = "[src*='FrameAsWebElement']") public WebElement frameAsWebElement;
}
