package pages;

import helpers.BaseHelper;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SportVisionJackWolfskinProductPage extends BaseHelper {
    WebDriver driver;

    public SportVisionJackWolfskinProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    private void clickOnTheHeartIcon() {
        wdWait.until(ExpectedConditions.elementToBeClickable(heartIconToPutInWishlist));
        heartIconToPutInWishlist.click();
    }

    private void insertEmail(String emailAddress) {
        wdWait.until(ExpectedConditions.visibilityOf(loginFormWindow));
        emailFIeld.sendKeys(emailAddress);
    }

    private void insertPassword(String password) {
        passwordField.sendKeys(password);
    }

    private void clickOnLoginButton() {
        loginButton.click();
        wdWait.until(ExpectedConditions.visibilityOf(productDetails));
    }

    private void openWishList() {
        try {
            wdWait.until(ExpectedConditions.refreshed(
                    ExpectedConditions.and(
                            ExpectedConditions.visibilityOf(heartIconToOpenWishlist),
                            ExpectedConditions.elementToBeClickable(heartIconToOpenWishlist)
                    )
            ));
            heartIconToOpenWishlist.click();
        } catch (StaleElementReferenceException e) {
            openWishList();
        }
    }

    public void putProductInWishList(String emailAddress, String password) {
        clickOnTheHeartIcon();
        insertEmail(emailAddress);
        insertPassword(password);
        clickOnLoginButton();
        openWishList();
    }
}
