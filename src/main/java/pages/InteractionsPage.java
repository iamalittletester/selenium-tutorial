package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InteractionsPage {
    @FindBy(css = "[name='checkboxToClick']") public WebElement checkbox;
    @FindBy(css = "#radioButtonToClick") public WebElement radioButton;
    @FindBy(css = "#linkToClick") public WebElement link;

    @FindBy(css = "[type='text']") public WebElement textInput;
    @FindBy(css = "textarea") public WebElement textArea;
    @FindBy(css = "[maxlength='100']") public  WebElement predefinedTextArea;

    @FindBy(css = "[src*='42514697560_1740d1993f_n.jpg']") public WebElement img;
    @FindBy(css = ".w3-purple") public WebElement disabledButton;

    @FindBy(css = "#getTextOuterDiv") public  WebElement div;
    @FindBy(css = "#getTextInnerDiv h5") public WebElement h5;

    @FindBy(css = "#getCssValueDiv") public WebElement container;
    @FindBy(css = "#getCssValueDiv h2") public WebElement h2;

    @FindBy(css = "[name='coffee']") public WebElement coffeeSelectWebElement;
    @FindBy(css = "[name='refreshment']") public WebElement refreshmentSelectWebElement;

    @FindBy(css = "h1") public WebElement h1;
}
