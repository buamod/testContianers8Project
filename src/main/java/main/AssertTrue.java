package main;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import static org.rnorth.visibleassertions.VisibleAssertions.assertTrue;

public class AssertTrue extends AbstractTestCase {

    @Test
    public void simpleExploreTest(){
        BrowserWebDriverContainer chrome = getChrome();
        RemoteWebDriver driver = setupDriver(chrome);
        driver.get("http://en.wikipedia.org/wiki/Randomness");

        // Oh! The irony!
        assertTrue("Randomness' description has the word 'pattern'", driver.findElementByPartialLinkText("pattern").isDisplayed());
    }

    private static RemoteWebDriver setupDriver(BrowserWebDriverContainer chrome) {
        RemoteWebDriver driver = chrome.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }
}
