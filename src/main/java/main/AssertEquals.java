package main;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.util.concurrent.TimeUnit;

import static org.rnorth.visibleassertions.VisibleAssertions.assertEquals;

public class AssertEquals extends AbstractTestCase
{
    @Test
    public void doSimpleWebdriverTest() {
        BrowserWebDriverContainer chrome = getChrome();

        RemoteWebDriver driver = chrome.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println("Selenium remote URL is: " + chrome.getSeleniumAddress());
        System.out.println("VNC URL is: " + chrome.getVncAddress());

        //Runtime.getRuntime().exec("open " + rule.getVncUrl(driver)); // For debugging, on a Mac

        driver.get("http://www.google.com");
        driver.findElement(By.name("q")).sendKeys("testcontainers");
        driver.findElement(By.name("q")).submit();

        assertEquals("the word 'testcontainers' appears in the search box", "testcontainers", driver.findElement(By.name("q")).getAttribute("value"));
    }

}
