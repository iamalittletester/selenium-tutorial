package tutorialsolution.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebElementInteractionPage {
    //WebElement with ID
    @FindBy(css = "#idModuleImage")
    public WebElement elementWithId;

    //inputs section
    @FindBy(css = "[name='checkedCheckbox']") public WebElement checkedCheckbox;
    @FindBy(css = "[name='uncheckedCheckbox']") public WebElement uncheckedCheckbox;
    @FindBy(css = "#myRadio") public WebElement radioButton;

    //elements for clicking
    @FindBy(css = "[name='checkboxToClick']") public WebElement checkboxToClick;
    @FindBy(css = "#radioButtonToClick") public WebElement radioButtonToClick;
    @FindBy(css = "#buttonToClick") public WebElement buttonToClick;
    @FindBy(css = "#linkToClick") public WebElement linkToClick;

    //elements for typing
    @FindBy(css = "[type='text']") public WebElement textInput;
    @FindBy(css = "textarea") public WebElement textarea;

    //disabled button
    @FindBy(css = "input[type='button']") public WebElement disabledButton;

    //elements for getText
    @FindBy(css = "#getTextOuterDiv") public WebElement getTextOuterDiv;
    @FindBy(css = "#getTextInnerDiv") public WebElement getTextInnerDiv;
    @FindBy(css = "#getTextInnerDiv h5") public WebElement getTexth5;
    @FindBy(css = "#getTextInnerDiv img") public WebElement getTextImg;
    @FindBy(css = "#getTextInnerDiv a") public WebElement getTextLink;
    @FindBy(css = "#getTextInnerDiv button") public WebElement getTextButton;
    @FindBy(css = "#getTextInnerDiv select option") public WebElement getTextDropdownFirstOption;
    @FindBy(css = "[maxlength='100']") public WebElement getTextTextarea;

    //dropdowns
    @FindBy(css = "[name='coffee']") public WebElement coffeeSelect;
    @FindBy(css = "[name='tea']") public WebElement teaSelect;
    @FindBy(css = "[name='refreshment']") public WebElement refreshmentSelect;

    //for getting the CSS attributes
    @FindBy(css = "h2") public WebElement h2Element;
    @FindBy(css = "#getCssValueDiv") public WebElement h2DivElement;
}
