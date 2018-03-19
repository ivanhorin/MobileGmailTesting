import com.epam.lab5.consts.UserData;
import com.epam.lab5.driver.DriverHandler;
import com.epam.lab5.pages.LoginPage;
import com.epam.lab5.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GmailTest {
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeMethod
    public void init(){
        loginPage=new LoginPage();
        mainPage=new MainPage();
    }

    @Test
    public void gmailTest() {
        DriverHandler.getDriver().get(UserData.GMAIL_URL);
        loginPage.enterEmail(UserData.EMAIL).clickNextButton()
                .enterPassword(UserData.PASSWORD).clickLoginButton();

        mainPage.clickComposeButton().enterMailSubject(UserData.MAIL_SUBJECT)
                .enterMailTo(UserData.SEND_TO)
                .enterMailMessage(UserData.MAIL_MESSAGE).clickSendButton()
                .clickMoreButton().openSentMails().selectEmail().deleteEmail();
        Assert.assertTrue(mainPage.isMailDeleted());
    }

    @AfterMethod
    public void quit(){
        DriverHandler.quitDriver();
    }
}
