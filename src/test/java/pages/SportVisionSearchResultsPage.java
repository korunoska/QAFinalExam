package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportVisionSearchResultsPage extends BaseHelper {
    public SportVisionSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private void expandBrandCategory() {
        wdWait.until(ExpectedConditions.visibilityOf(brandCategory));
        WebElement showMore = brandCategory.findElement(By.className("show-all-filters"));
        showMore.click();
    }

    private void selectBrandCategory(String productBrand) {
        wdWait.until(ExpectedConditions.visibilityOf(brandCategory));
        wdWait.until(ExpectedConditions.visibilityOf(resultsNumber));

        String numberOfResultsPriorFilter = resultsNumber.getText();

        List<WebElement> brandsList = brandCategory.findElements(By.className("icheck-label"));
        for (WebElement brand : brandsList) {
            if (brand.getText().toLowerCase().contains(productBrand.toLowerCase())) {
                brand.click();
                break;
            }
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("products-found"), numberOfResultsPriorFilter));
    }

    private void selectAgeGroup(String ageGroup) {
        wdWait.until(ExpectedConditions.visibilityOf(ageGroupCategory));
        wdWait.until(ExpectedConditions.visibilityOf(resultsNumber));

        String numberOfResultsPriorFilter = resultsNumber.getText();
        List<WebElement> ageList = ageGroupCategory.findElements(By.className("icheck-label"));
        for (WebElement category : ageList) {
            if (category.getText().toLowerCase().contains(ageGroup.toLowerCase())) {
                wdWait.until(ExpectedConditions.elementToBeClickable(category));
                category.click();
                break;
            }
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("products-found"), numberOfResultsPriorFilter));
    }

    private void selectPriceCategory(String priceElement)  {
        wdWait.until(ExpectedConditions.visibilityOf(priceCategory));
        wdWait.until(ExpectedConditions.visibilityOf(resultsNumber));

        String numberOfResultsPriorFilter = resultsNumber.getText();

        List<WebElement> priceList = priceCategory.findElements(By.className("icheck-label"));
        for (WebElement category : priceList) {
            if (category.getText().toLowerCase().contains(priceElement.toLowerCase())) {
                // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", category);
                wdWait.until(ExpectedConditions.elementToBeClickable(category));
                category.click();
                break;
            }
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("products-found"), numberOfResultsPriorFilter));
    }

    public void filterArticleByProductTypes(String productBrand, String ageGroup, String priceElement) {
        expandBrandCategory();
        selectBrandCategory(productBrand);
        selectAgeGroup(ageGroup);
        selectPriceCategory(priceElement);
    }
}
