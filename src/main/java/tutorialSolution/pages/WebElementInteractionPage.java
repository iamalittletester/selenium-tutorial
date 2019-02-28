package tutorialSolution.pages;

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
    @FindBy(css = "[type='button']") public WebElement disabledButton;

    //dropdowns
    @FindBy(css = "[name='coffee']") public WebElement coffeeSelect;
    @FindBy(css = "[name='tea']") public WebElement teaSelect;
    @FindBy(css = "[name='refreshment']") public WebElement refreshmentSelect;

}
