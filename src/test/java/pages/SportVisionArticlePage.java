package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SportVisionArticlePage extends BaseHelper {
    public SportVisionArticlePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void selectSize() {
        List<WebElement> sizes = sizeList.findElements(By.className("ease"));
        for (WebElement size : sizes) {
            String classes = size.getAttribute("class");
            if (!classes.contains("greyOut")) {
                size.click();
                break;
            }
        }
    }

    private void inputQuantity(String productQuantity) {
        inputQuantityField.clear();
        inputQuantityField.sendKeys(productQuantity);
    }

    private void clickAddToCart() {
        addToCartButton.click();
    }

    private void openShoppingCart() {
        cartIcon.click();
    }


    public void addArticleAndOpenShoppingCart(String productQuantity) {
        selectSize();
        inputQuantity(productQuantity);
        clickAddToCart();
        openShoppingCart();
    }


}
