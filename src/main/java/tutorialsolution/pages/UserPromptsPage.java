package tutorialsolution.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPromptsPage {
    @FindBy(css = "#alertButton") public WebElement alertButton;
    @FindBy(css = "#confirmButton") public WebElement confirmButton;
    @FindBy(css = "#promptButton") public WebElement promptButton;
    @FindBy(css = "#userClicked") public WebElement userClicked;
}
