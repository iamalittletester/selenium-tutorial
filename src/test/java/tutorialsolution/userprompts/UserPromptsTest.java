package tutorialsolution.userprompts;

import browser.BrowserGetter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.UserPromptsPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class UserPromptsTest {
    private final BrowserGetter browserGetter = new BrowserGetter();
    private UserPromptsPage page;
    private WebDriver driver;

    @BeforeAll
    public void beforeAll() {
        //initialize the Chrome browser here
        driver = browserGetter.getChromeDriver();
        //initialize page object class
        page = PageFactory.initElements(driver, UserPromptsPage.class);
        driver.get(new File("src/main/resources/userPrompts.html").getAbsolutePath());
    }

    @AfterAll
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void alertGetTextAndAccept() throws InterruptedException {
        //click the button which triggers an alert to be displayed
        page.alertButton.click();
        //!!!the Threa.sleep() is only in this test so that you can actually see
        //how the alert is being displayed
        //otherwise the test runs too fast and you don't see the alert
        //do not use Thread.sleep() in your real tests!!
        Thread.sleep(1000);
        //create a new variable of type Alert
        //this way you can interact with it multiple times
        //this is done by switching to the alert with switchTo().alert()
        //it returns an Alert Java object
        Alert alert = driver.switchTo().alert();
        //check that the text displayed in the alert is correct
        assertEquals("This is the alert box", alert.getText());
        //close the alert
        alert.accept();
        //!!!sleep so you see that the alert closed
        Thread.sleep(1000);
    }

    @Test
    public void alertAccept() throws InterruptedException {
        //click the button which triggers an alert to be displayed
        page.alertButton.click();
        //!!!the Threa.sleep() is only in this test so that you can actually see
        //how the alert is being displayed
        //otherwise the test runs too fast and you don't see the alert
        //do not use Thread.sleep() in your real tests!!
        Thread.sleep(1000);
        //switch to the alert and accept it, which will close it
        //no need to create an Alert variable here
        //in the test you are not interested in any other alert interactions
        driver.switchTo().alert().accept();
    }

    @Test
    public void confirmGetTextAcceptAndDismiss() throws InterruptedException {
        //click the button which triggers a 'confirm' element to be displayed
        page.confirmButton.click();
        //get a handle to the newly opened 'confirm'
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        //check that the text inside the 'confirm' is correct
        assertEquals("Confirm modal", alert.getText());
        //click the OK button on the 'confirm' (accept)
        alert.accept();
        Thread.sleep(1000);
        //check that the field which displays what the user clicked
        //displays "OK"
        assertEquals("OK", page.userClicked.getText());

        //trigger the 'confirm' to be displayed again
        page.confirmButton.click();
        Thread.sleep(1000);
        //click the Cancel button on the 'confirm' (dimiss)
        alert.dismiss();
        Thread.sleep(1000);
        //check that the field which displays what the user clicked
        //displays "Cancel"
        assertEquals("Cancel", page.userClicked.getText());
    }

    @Test
    public void confirmAcceptAndDismiss() throws InterruptedException {
        //trigger the 'confirm' to be displayed
        page.confirmButton.click();
        Thread.sleep(1000);
        //accept the 'confirm'
        driver.switchTo().alert().accept();
        //check that the field which displays what the user clicked
        //displays "OK"
        assertEquals("OK", page.userClicked.getText());

        //trigger the 'confirm' to be displayed
        page.confirmButton.click();
        Thread.sleep(1000);
        //dismiss the 'confirm'
        driver.switchTo().alert().dismiss();
        //check that the field which displays what the user clicked
        //displays "Cancel"
        assertEquals("Cancel", page.userClicked.getText());
    }

    @Test
    public void promptGetTextAcceptAndDismiss() throws InterruptedException {
        //click the button which triggers a 'prompt' element to be displayed
        page.promptButton.click();
        //get a handle to the newly opened 'prompt'
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        //check that the text inside the 'prompt' is correct
        assertEquals("Type something", alert.getText());
        Thread.sleep(1000);
        //click the OK button on the 'prompt' (accept)
        alert.accept();
        Thread.sleep(1000);
        //check that the field which displays what the user clicked
        //displays "OK"
        assertEquals("OK", page.userClicked.getText());

        //trigger the 'prompt' to be displayed again
        page.promptButton.click();
        Thread.sleep(1000);
        //click the Cancel button on the 'prompt' (dimiss)
        alert.dismiss();
        Thread.sleep(1000);
        //check that the field which displays what the user clicked
        //displays "Cancel"
        assertEquals("Cancel", page.userClicked.getText());
    }

    @Test
    public void promptAcceptAndDismiss() throws InterruptedException {
        //trigger the 'prompt' to be displayed
        page.promptButton.click();
        Thread.sleep(1000);
        //accept the 'prompt'
        driver.switchTo().alert().accept();
        //check that the field which displays what the user clicked
        //displays "OK"
        assertEquals("OK", page.userClicked.getText());

        //trigger the 'prompt' to be displayed
        page.promptButton.click();
        Thread.sleep(1000);
        //dismiss the 'prompt'
        driver.switchTo().alert().dismiss();
        //check that the field which displays what the user clicked
        //displays "Cancel"
        assertEquals("Cancel", page.userClicked.getText());
    }

}
