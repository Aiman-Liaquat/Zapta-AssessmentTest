package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class AssessmentZapta {
    WebDriver driver;

    public AssessmentZapta(WebDriver driver) {
        this.driver = driver;
    }
    //private By sucasaStandard = new By.ByCssSelector("div[class='container standard'] h2");


    public void verifySucasaStandardSectionText() {
        WebElement parentContainer = driver.findElement(By.className("standard"));
        List<WebElement> h4Elements = parentContainer.findElements(By.tagName("h4"));

        verifyTextInElements(h4Elements, "Work From Anywhere");
        verifyTextInElements(h4Elements, "Transparent Pricing");
        verifyTextInElements(h4Elements, "Premium Properties");
    }
    public void goToWorkFromAnywhereSection() {
        // Find the element for Work From Anywhere section
        By linkLocator = By.xpath("//h2[text()='Work From Anywhere']/following-sibling::a");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement workFromAnywhereLink = wait.until(ExpectedConditions.elementToBeClickable(linkLocator));

        // Scroll to the element using JavascriptExecutor
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});", workFromAnywhereLink);

        // Click on the element using JavascriptExecutor
        executor.executeScript("arguments[0].click();", workFromAnywhereLink);
    }
    public void verifyPageURL() {
        // Verify page URL
        String expectedURL = "https://saucasa.zaptatech.com/index?#featured";
        String actualURL = driver.getCurrentUrl();
        System.out.println("Actual URL: " + actualURL);
        System.out.println("Expected URL: " + expectedURL);
        if (actualURL.equals(expectedURL)) {
            System.out.println("Page URL is equal to " + expectedURL);
        } else {
            System.out.println("Page URL is not equal to " + expectedURL);
        }
    }

    public void takeScreenshot() {
        // Take a screenshot of the page
        SimpleDateFormat formatter = new SimpleDateFormat("HH-mm-ss");
        String timestamp = formatter.format(new Date());
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("C://Users//Aymen Liaquat//Desktop//ZaptaSS//s1" + timestamp + ".png");
        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void verifyTextInElements(List<WebElement> elements, String expectedText) {
        boolean found = false;
        for (WebElement element : elements) {
            if (element.getText().contains(expectedText)) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Text '" + expectedText + "' found in element");
        } else {
            System.out.println("Text '" + expectedText + "' not found in element");
        }
    }


}
