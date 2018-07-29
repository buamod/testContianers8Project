package main;
import org.junit.Test;
import org.testcontainers.containers.BrowserWebDriverContainer;

public class TestUrl extends AbstractTestCase{

    @Test
    public void goToUrl(BrowserWebDriverContainer chrome){

        chrome.getWebDriver().get("http://www.google.com");
    }



}
