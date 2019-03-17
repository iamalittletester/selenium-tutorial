package tutorialSolution.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage {
    @FindBy(css = "[href*='secondPage']") public WebElement linkToSecondPage;
    @FindBy(css = "[href*='thirdPage']") public WebElement linkToThirdPage;
    @FindBy(css = "h1") public WebElement h1Element;
}
