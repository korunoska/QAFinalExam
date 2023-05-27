package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportVisionJackWolfskinPage extends BaseHelper {
    WebDriver driver;


    public SportVisionJackWolfskinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void selectGenderCategory(String chosenGender) {
        wdWait.until(ExpectedConditions.visibilityOf(genderCategory));
        wdWait.until(ExpectedConditions.visibilityOf(resultsNumber));

        String numberOfResultsPriorFilter = resultsNumber.getText();

        List<WebElement> genderGroup = genderCategory.findElements(By.className("icheck-label"));
        for (WebElement element : genderGroup) {
            if (element.getText().toLowerCase().contains(chosenGender.toLowerCase())) {
                element.click();
                break;
            }
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("products-found"), numberOfResultsPriorFilter));
    }

    private void goToChosenPage() {
        wdWait.until(ExpectedConditions.visibilityOf(choosePage));
        List<WebElement> pagesList = choosePage.findElements(By.tagName("li"));
        int secondToLastIndex = pagesList.size() - 2;
        WebElement secondToLastElement = pagesList.get(secondToLastIndex);
        secondToLastElement.click();
    }

    public void chooseSpecificPage(String chosenGender) {
        selectGenderCategory(chosenGender);
        goToChosenPage();
    }
}
