package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.*;

import java.util.List;

public class SportVisionWishListTest extends BaseTest {


    @Test
    public void wishListTest() throws InterruptedException {


        SportVisionHomePage searchOnHomePage = new SportVisionHomePage(driver);
        searchOnHomePage.wishListTest(url, clothingSearchTerm);

        SportVisionJackWolfskinPage sportVisionJackWolfskinPage = new SportVisionJackWolfskinPage(driver);
        sportVisionJackWolfskinPage.chooseSpecificPage(chosenGender);

        SportVisionJackWolfskinPage2 sportVisionJackWolfskinPage2 = new SportVisionJackWolfskinPage2(driver);
        sportVisionJackWolfskinPage2.openLastProductOfPage();

        lastArticleId = sportVisionJackWolfskinPage2.lastArticleId().replace("(", "").replace(")", "");


        SportVisionJackWolfskinProductPage sportVisionJackWolfskinProductPage = new SportVisionJackWolfskinProductPage(driver);
        sportVisionJackWolfskinProductPage.putProductInWishList(emailAddress, password);

        SportVisionWishListPage sportVisionWishListPage = new SportVisionWishListPage(driver);
        sportVisionWishListPage.articleIdInWishList();

        List<String> articleIdInWishList = sportVisionWishListPage.articleIdInWishList();

        boolean containsLastArticleId = false;
        for (String articleId : articleIdInWishList) {
            if (articleId.toLowerCase().equals(lastArticleId.toLowerCase())) {
                containsLastArticleId = true; //without break because I want to check if there are any more elements
                // break;
            }
        }
        softAssertion.assertTrue(containsLastArticleId, "Expected product is not in the wish list");
        System.out.println("The item you chose is put in the wish list." + "\nThe product you chose has an id " + lastArticleId + ". \nThe product in the wish list has an id " + articleIdInWishList + ".");

        softAssertion.assertAll();

        Thread.sleep(5000);
    }
}
