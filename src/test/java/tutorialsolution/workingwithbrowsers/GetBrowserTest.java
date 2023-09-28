package tutorialsolution.workingwithbrowsers;

import browser.BrowserGetter;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tutorialsolution.pages.WindowsPage;

import java.io.File;

public class GetBrowserTest {

    private WebDriver driver;
    private BrowserGetter browserGetter = new BrowserGetter();

    @Test
    public void getChromeDriver() {
        //open a Chrome browser
        driver = browserGetter.getChromeDriver();
        //close all the open browser windows; in this case just the one
        driver.quit();
    }

    @Test
    public void getFirefoxDriver() {
        //open a Firefox browser
        driver = browserGetter.getFirefoxDriver();
        //close all the open browser windows; in this case just the one
        driver.quit();
    }

    @Test
    public void getBrowser() {
        //open a browser based on the "browser" System property
        driver = browserGetter.getDriver();
        //close all the open browser windows; in this case just the one
        driver.quit();
    }

    @Test
    public void multipleBrowserWindows() {
        //start one browser instance
        driver = browserGetter.getChromeDriver();
        //open new page
        WindowsPage page = PageFactory.initElements(driver, WindowsPage.class);
        driver.get(new File("src/main/resources/mainPage.html").getAbsolutePath());
        //click on page links which will open new windows
        page.linkToSecondPage.click();
        page.linkToThirdPage.click();
        page.linkToThirdPage.click();
        //there are currently 4 open windows: the initial one + the three opened by clicking on the links
        System.out.println("There are now " + driver.getWindowHandles().size() + " open windows");
        //using driver.close() will only close the current browser window
        driver.close();
        //there are now 3 open windows
        System.out.println("There are now " + driver.getWindowHandles().size() + " open windows");
        //close all the browser instances
        driver.quit();
    }

    @Test
    public void getChromeDriverCustomSize() {
        //open a Chrome browser
        driver = browserGetter.getChromeDriverCustomSize(460, 640);
        //close all the open browser windows; in this case just the one
        driver.quit();
    }
}
