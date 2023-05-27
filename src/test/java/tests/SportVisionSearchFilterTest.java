package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SportVisionHomePage;
import pages.SportVisionSearchResultsPage;

import java.util.List;

public class SportVisionSearchFilterTest  extends BaseTest {
    @Test
    public void searchFilterTest() throws InterruptedException {

        SportVisionHomePage searchOnHomePage = new SportVisionHomePage(driver);
        searchOnHomePage.searchFilterTest(url, searchTerm);

        SportVisionSearchResultsPage selectCategories = new SportVisionSearchResultsPage(driver);
        selectCategories.filterArticleByProductTypes(productBrand, ageGroup, priceElement);

        WebElement filterResults = driver.findElement(By.className("products-listing"));
        List<WebElement> results = filterResults.findElements(By.className("item-data"));
        for (WebElement result : results) {
            String title = result.findElement(By.className("title")).getText();
            Assert.assertTrue("Product in the searched results is not of the filtered brand " + "\nProduct name is: "
                    + title + "\nProduct name should include: " + productBrand, title.toLowerCase().contains(productBrand.toLowerCase()));
            System.out.println(title + " is a product of the filtered brand");

            WebElement priceResults = result.findElement(By.className("current-price"));
            String priceElementText = priceResults.getText().replace(",00", "").replace( "BAM", "").replace(",01", "").replace(",10", "");
            float price = Float.parseFloat(priceElementText);

            Assert.assertTrue("Price is not in selected range for item:" + title, (price >= Float.parseFloat(minPrice) && price <= Float.parseFloat(maxPrice))); {
                System.out.println("Price is in selected range for item: " + title);
            }
        }

        Thread.sleep(5000);

    }
}
