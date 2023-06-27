package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    private By zaptaLink = new By.ByXPath("//h2[normalize-space()='The Sucasa Standard']");


   public AssessmentZapta GoToAssessmentZapta() {
       driver.findElement(zaptaLink);
       return new AssessmentZapta(driver);
   }




}
