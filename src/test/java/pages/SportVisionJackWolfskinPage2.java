package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportVisionJackWolfskinPage2 extends BaseHelper {
    WebDriver driver;
    //private String lastElementTitle;

    public SportVisionJackWolfskinPage2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private void chooseLastProduct()  {
        try {
            wdWait.until(ExpectedConditions.visibilityOf(searchedResults));
            List<WebElement> searchedItemsList = searchedResults.findElements(By.className("title"));
            int lastIndex = searchedItemsList.size() - 1;
            WebElement lastElement = searchedItemsList.get(lastIndex);
            lastElement.click();
           // wdWait.until(ExpectedConditions.visibilityOf(productDetails));
        } catch (StaleElementReferenceException e) {
            chooseLastProduct();
        }
    }


    public void openLastProductOfPage() {
        chooseLastProduct();
    }

    public String lastArticleId() {
        WebElement codeElement = driver.findElement(By.cssSelector("div.code > span"));
        String codeText = codeElement.getText();
        return codeText;
    }
}