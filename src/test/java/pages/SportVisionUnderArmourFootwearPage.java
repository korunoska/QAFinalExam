package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportVisionUnderArmourFootwearPage extends BaseHelper {
    WebDriver driver;

    public SportVisionUnderArmourFootwearPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void chooseProductType(String productType) {
        wdWait.until(ExpectedConditions.visibilityOf(typeCategory));
        wdWait.until(ExpectedConditions.visibilityOf(resultsNumber));

        String numberOfResultsPriorFilter = resultsNumber.getText();

        List<WebElement> productTypeList = typeCategory.findElements(By.className("icheck-label"));
        for (WebElement element : productTypeList) {
            if (element.getText().toLowerCase().contains(productType.toLowerCase())) {
                element.click();
                break;
            }
        }
        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("products-found"), numberOfResultsPriorFilter));
    }

    private String clickOnRequestedArticle(int articleNumber) {
        wdWait.until(ExpectedConditions.visibilityOf(searchResults));
        List<WebElement> articleList = searchResults.findElements(By.className("item-data"));
        WebElement articleTitle = articleList.get(articleNumber - 1).findElement(By.className("title"));
        String articleHeadline = articleTitle.getText();
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", articleTitle);
        articleTitle.click();
        return articleHeadline;
    }

    public void filterAndChooseProduct(String productType, int articleNumber) {
        chooseProductType(productType);
        clickOnRequestedArticle(articleNumber);
    }
}
