import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class AbstractTestCase {
    private static final Logger logger = LoggerFactory.getLogger(AbstractTestCase.class);
    public BrowserWebDriverContainer chrome;

    @BeforeClass
    protected void initUI() throws Exception {
        logger.info("STARTING");

        chrome = new BrowserWebDriverContainer()
                .withDesiredCapabilities(DesiredCapabilities.chrome())
                .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_FAILING, new File("/target/"));
        chrome.start();

        logger.info("The Docker Selenium URL is: " + chrome.getSeleniumAddress().toString());

    }

    public BrowserWebDriverContainer getChrome(){
        return chrome;
    }

    @AfterClass
    protected void cleanUpContainer(){
//        chrome.stop();
    }
}

