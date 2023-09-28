package tutorialsolution.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage {
    @FindBy(css = "[href*='secondpage']") public WebElement linkToSecondPage;
    @FindBy(css = "[href*='thirdpage']") public WebElement linkToThirdPage;
    @FindBy(css = "h1") public WebElement h1Element;
}
