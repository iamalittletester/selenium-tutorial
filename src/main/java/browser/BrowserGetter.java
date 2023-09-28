package browser;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.setProperty;
import static org.apache.commons.lang3.SystemUtils.*;

public class BrowserGetter {
    /**
     *          detect operating system
     *          if it is not one of the predefined ones, just throw exception
     *          only create a webDriver instance for a known operating system
     */

    public WebDriver getWinChromeDriver() {
        setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getChromeDriver() {
        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
        if (IS_OS_WINDOWS) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriver.exe");
        }
        if (IS_OS_LINUX) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriver");
        }
        if (IS_OS_MAC) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriverMac");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getFirefoxDriver() {
        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
        if (IS_OS_WINDOWS) {
            setProperty("webdriver.gecko.driver", "src/test/resources/browserBinaries/geckodriver.exe");
        }
        if (IS_OS_LINUX) {
            setProperty("webdriver.gecko.driver", "src/test/resources/browserBinaries/geckodriver");
        }
        if (IS_OS_MAC) {
            setProperty("webdriver.gecko.driver", "src/test/resources/browserBinaries/geckodriverMac");
        }

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        switch (System.getProperty("browser").toLowerCase()) {
            case "chrome" :
                System.out.println("Chrome was chosen!");
                return getChromeDriver();
            case "firefox" :
                System.out.println("Firefox was chosen!");
                return getFirefoxDriver();
            default:
                throw new RuntimeException("Unsupported browser! Will not start any browser!");
        }
    }

    public WebDriver getChromeDriverCustomSize(int width, int height) {
        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
        if (IS_OS_WINDOWS) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriver.exe");
        }
        if (IS_OS_LINUX) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriver");
        }
        if (IS_OS_MAC) {
            setProperty("webdriver.chrome.driver", "src/test/resources/browserBinaries/chromedriverMac");
        }

        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(width, height));
        return driver;
    }

}
