package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportVisionChosenBrandPage extends BaseHelper {
    WebDriver driver;

    public SportVisionChosenBrandPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private void chooseTypeOfWear(String chosenWear) {
        wdWait.until(ExpectedConditions.visibilityOf(wearCategoriesList));
        List<WebElement> wearCategoriesListOptions = wearCategoriesList.findElements(By.className("col-xs-12"));
        for (WebElement option : wearCategoriesListOptions) {
            if (option.getText().toLowerCase().contains(chosenWear.toLowerCase())) {
                option.click();
                break;
            }
        }
    }


    public void selectTheChosenWear(String chosenWear) {
                chooseTypeOfWear(chosenWear);
    }
}
