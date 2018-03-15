import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.IOException;


public class Testing extends BaseWebDriverContainerTest {


        @Rule
        public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
                .withDesiredCapabilities(DesiredCapabilities.chrome());

        @Test
        public void simpleTest() {
            doSimpleWebdriverTest(chrome);
        }

    @Test
    public void simpleExploreTest() throws IOException {
        doSimpleExplore(chrome);
    }
        protected static void doSimpleWebdriverTest(BrowserWebDriverContainer chrome){

            chrome.getWebDriver().get("http://www.google.com");
        }
    }

