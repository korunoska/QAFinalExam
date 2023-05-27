package tests;

import helpers.BaseHelper;
import org.junit.After;
import org.junit.Before;


public class BaseTest extends BaseHelper
{
    @Before
    public void testInit()
    {
        driver.manage().window().maximize();
    }

    @After
    public void testTearDown() {
        driver.close();
        driver.quit();
    }

    String url = "https://www.sportvision.ba/";
    String searchTerm = "bicikl";
    String productBrand = "CAPRIOLO";
    String ageGroup = "Za manju djecu";
    String priceElement = "201 - 300";
    String minPrice = "201";
    String maxPrice = "300";


    String chosenBrand = "Under Armour";
    String chosenWear = "Ženska obuća";
    String productType = "Trčanje";
    int articleNumber = 3;
    String productQuantity = "2";


    String clothingSearchTerm = "Jack Wolfskin";
    String chosenGender = "Za muškarce";
    String emailAddress = "emilijakorunoska@gmail.com";
    String password = "probnasifra";
    String lastArticleId;
    String articleIdInWishList;

}