package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SportVisionHomePage extends BaseHelper {
    WebDriver driver;

    public SportVisionHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private void navigateToHomepage(String url) {
        driver.get(url);
    }

    private void agreeGdpr() {
        wdWait.until(ExpectedConditions.elementToBeClickable(agreeGdprButton));
        agreeGdprButton.click();
    }

    private void inputSearchTerm(String searchTerm) {
        // wdWait.until(ExpectedConditions.visibilityOf(inputButton));
        inputButton.click();
        inputSearchTerm.sendKeys(searchTerm);
    }

    private void clickOnSearchButton() {
        wdWait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();
    }

    private void chooseBrandOnHomePage(String chosenBrand) {
        wdWait.until(ExpectedConditions.visibilityOf(mainList));
        List<WebElement> mainListOptions = mainList.findElements(By.tagName("a"));
        for (WebElement option : mainListOptions) {
            if (option.getText().toLowerCase().contains(chosenBrand.toLowerCase())) {
                option.click();
                break;
            }
        }
    }

    private void inputClothingSearchTerm(String clothingSearchTerm) {
        inputButton.click();
        inputSearchTerm.sendKeys(clothingSearchTerm);
    }

    public void searchFilterTest(String url, String searchTerm) {
        navigateToHomepage(url);
        agreeGdpr();
        inputSearchTerm(searchTerm);
        clickOnSearchButton();
    }

    public void chooseHomePageBrandCategory(String url, String chosenBrand) {
        navigateToHomepage(url);
        agreeGdpr();
        chooseBrandOnHomePage(chosenBrand);
    }

    public void wishListTest(String url, String clothingSearchTerm) {
        navigateToHomepage(url);
        agreeGdpr();
        inputClothingSearchTerm(clothingSearchTerm);
        clickOnSearchButton();
    }
}

