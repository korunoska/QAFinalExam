package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SportVisionWishListPage extends BaseHelper {
    public WebDriver driver;

    public SportVisionWishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> articleIdInWishList() {
        wdWait.until(ExpectedConditions.visibilityOf(wishListPage));
        List<WebElement> elements = driver.findElements(By.cssSelector("div.product-item"));
        List<String> elementsIds = new ArrayList<>();
        for (WebElement element : elements) {
            String productId = element.getAttribute("data-product-item-id");
            elementsIds.add(productId);
        }
        return elementsIds;
           }
}
