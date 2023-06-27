import Base.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssessmentZapta extends BaseTest {
    @Test
    public void VerifyAssessmentZapta(){
        var zapta = homePage.GoToAssessmentZapta();


        zapta.verifySucasaStandardSectionText();
        zapta.goToWorkFromAnywhereSection();

        zapta.verifyPageURL();
        zapta.takeScreenshot();
    }
}
