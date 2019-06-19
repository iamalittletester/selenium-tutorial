package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SeOOPage {
    @FindBy(css = "article") public
    List<WebElement> elements;
}
