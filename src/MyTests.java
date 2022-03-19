import org.testng.Assert;
import org.testng.annotations.*;

public class MyTests {

   POM pom;

    @Test(priority = 0)
    public void launchSiteValidFields() {
        try {
            enterDetails("tala777333@gmail.com","0544748674" );
            Assert.assertTrue(true, "Test completed successfully");
        }
        catch (Exception ex) {
            Assert.fail("Error in test: " + ex.getMessage());
        }
        finally {
            pom.closeBrowsers();
        }
    }

    @Test(priority = 1)
    public void testBadEmail() {
        try {
            enterDetails("NotATrueEmail","0544748674" );
            Assert.assertTrue(false, "Test needs to fail");
        }
        catch (Exception ex) {
            Assert.assertTrue(true,"Test needs to fail because invalid Email");
        }
        finally {
            pom.closeBrowsers();
        }
    }

    @Test(priority = 2)
    public void testBadPhone() {
        try {
            enterDetails("tala777333@gmail.com","1234" );
            Assert.assertTrue(false, "Test needs to fail");
        }
        catch (Exception ex) {
            Assert.assertTrue(true,"Test needs to fail because invalid phone");
        }
        finally {
            pom.closeBrowsers();
        }
    }

    private void enterDetails(String email, String phoneNumber) throws InterruptedException {
        pom = new POM();
        pom.launchSite("https://automation.herolo.co.il/");
        pom.clickElementByCSS("input[name='name']");
        pom.typeText("טל אנגל");
        pom.clickElementByCSS("input[name='email']");
        pom.typeText(email);
        pom.clickElementByCSS("input[name='phone']");
        pom.typeText(phoneNumber);
        pom.clickElementByXpath("//span[contains(text(),'שליחה')]");
        pom.waitSeconds(5);
        pom.clickElementByXpath("//span[contains(text(),'הנתונים התקבלו בהצלחה')]");
    }

}
