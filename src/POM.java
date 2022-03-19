import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class POM {

    WebDriver webDriver;
    WebElement lastElement;

    public POM() {
        if (webDriver ==null) {
            System.setProperty("webdriver.chrome.driver","D:\\ChromeDrivers\\chromedriver.exe");
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }
    }

    public void launchSite(String url) {
        webDriver.get(url);
    }

    public void clickElementByCSS(String css ) {
       lastElement = webDriver.findElement(By.cssSelector(css));
       lastElement.click();
    }

    public void typeText(String txt) {
        lastElement.sendKeys(txt);
    }

    public void clickElementByXpath(String xpath) {
        lastElement = webDriver.findElement(By.xpath(xpath));
        lastElement.click();
    }

    public void waitSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

    public void closeBrowsers() {
        webDriver.quit();
    }
}
