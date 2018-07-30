package main;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testng.annotations.Test;

public class TestUrl extends AbstractTestCase{

    @Test
    public void goToUrl(){
        BrowserWebDriverContainer chrome = getChrome();
        chrome.getWebDriver().get("http://www.google.com");
    }



}
