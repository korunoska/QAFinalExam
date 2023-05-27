package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

public class SportVisionShoppingCartTest extends BaseTest {
    @Test
    public void shoppingCartTest() throws InterruptedException {


        SportVisionHomePage searchOnHomePage = new SportVisionHomePage(driver);
        searchOnHomePage.chooseHomePageBrandCategory(url, chosenBrand);

        SportVisionChosenBrandPage selectWearCategory = new SportVisionChosenBrandPage(driver);
        selectWearCategory.selectTheChosenWear(chosenWear);

        SportVisionUnderArmourFootwearPage filterProductsAncChoose = new SportVisionUnderArmourFootwearPage(driver);
        filterProductsAncChoose.filterAndChooseProduct(productType, articleNumber);

        SportVisionArticlePage chooseArticleSizeAndPutInCart = new SportVisionArticlePage(driver);
        chooseArticleSizeAndPutInCart.addArticleAndOpenShoppingCart(productQuantity);

        SportVisionShoppingCartPage shoppingCartPage = new SportVisionShoppingCartPage(driver);

        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("cart-table")));
        WebElement products = driver.findElement(By.className("cart-table"));
        WebElement totalPrice = products.findElement(By.className("product-item-prices"));
        WebElement priceWithDiscount = products.findElement(By.xpath("//*[@id=\"order_cart_content\"]/div[1]/div[2]/table/tbody/tr[1]/td[8]/div"));
        String productPrice = priceWithDiscount.getText();
        String priceAll = totalPrice.getText();

        System.out.println("Product price is: " + productPrice);
        System.out.println("Total Price is: " + priceAll);

        float articlePriceFloat = Float.parseFloat(productPrice.replace(",00", "").replace("BAM", ""));
        float totalPriceFloat = Float.parseFloat((priceAll.replace(",00", "").replace("BAM", "")));

        Assert.assertTrue("The total price of products is NOT correct!", ((Float.parseFloat(productQuantity)) * articlePriceFloat) == totalPriceFloat);


        Thread.sleep(5000);
    }


}
