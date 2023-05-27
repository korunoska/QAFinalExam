package helpers;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import slack.Slack;
import slack.SlackBlocksMessageBuilder;
import slack.SlackChannel;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class BaseHelper
{

    protected static WebDriver driver = setUpChromeDriver();
    protected static WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected static JavascriptExecutor js = (JavascriptExecutor) driver;
    SlackBlocksMessageBuilder slackMessageBuilder = new SlackBlocksMessageBuilder();
    protected SoftAssert softAssertion = new SoftAssert();
    protected void assertResult(String result, String assertText)
    {
        if (!result.contains(assertText))
        {
            slackMessageBuilder.setTitle(":x: " + assertText + " :x:");
            slackMessageBuilder.addMessageContent("Expected to find ", assertText);
            slackMessageBuilder.setUrl(driver.getCurrentUrl());
            slackMessageBuilder.addMessageContent("On website ", driver.getCurrentUrl());
            System.out.println(slackMessageBuilder.getMessage());
            Slack.postSlackBlocksMessage(slackMessageBuilder.getMessage(), SlackChannel.QARevealed);

            Assert.fail("There is no " + assertText + " in the result.");
        }
    }

    public static WebElement returnElementAttValue (String attributeName, String attributeValue)
    {
        String selector = "[" + attributeName + "=" + attributeValue + "]";
        WebElement element = driver.findElement(By.cssSelector(selector));
        return element;
    }

    protected static WebDriver setUpChromeDriver()
    {
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        return driver;

    }
    @FindBy(className = "cookie-agree-gdpr")
    protected WebElement agreeGdprButton;
    @FindBy(xpath = "/html/body/header/div[2]/div/div[3]/div[3]/span")
    protected WebElement inputButton;
    @FindBy(id = "search-text")
    protected WebElement inputSearchTerm;
    @FindBy(className = "heading-append")
    protected WebElement searchButton;
    @FindBy(className = "list-inline")
    protected WebElement mainList;

    @FindBy(id="nb_f-attr-25487197")
    protected WebElement brandCategory;
    @FindBy(id = "nb_f-attr-25487363")
    protected WebElement ageGroupCategory;
    @FindBy(xpath = "//*[@id=\"filter_form\"]/div/div[6]")
    protected WebElement priceCategory;
    @FindBy(className = "products-found")
    protected WebElement resultsNumber;

    @FindBy(className = "grid-3-wrapper")
    protected WebElement wearCategoriesList;

    @FindBy(id = "nb_f-attr-25487048")
    protected WebElement typeCategory;

    @FindBy(className = "products-listing")
    protected WebElement searchResults;

    @FindBy(className = "product-attributes")
    protected WebElement sizeList;
    @FindBy(id = "product_quantity")
    protected WebElement inputQuantityField;
    @FindBy (id = "nb_addToCartButton")
    protected WebElement addToCartButton;
    @FindBy (className = "mini-cart")
    protected WebElement cartIcon;

    @FindBy(id = "nb_f-attr-25486799")
    protected WebElement genderCategory;

    @FindBy(className = "pagination")
    protected WebElement choosePage;

    @FindBy(className = "product-listing-items")
    protected WebElement searchedResults;
    @FindBy(className = "product-details")
    protected WebElement productDetails;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/div[1]/div[1]/div/div[2]/div[7]")
    protected WebElement heartIconToPutInWishlist;
    @FindBy(className = "login_form")
    protected WebElement loginFormWindow;
    @FindBy(id = "login_email")
    protected WebElement emailFIeld;
    @FindBy(id = "login_password")
    protected WebElement passwordField;
    @FindBy(className = "btn-login")
    protected WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"miniFavContent\"]/a/div[1]")
    protected WebElement heartIconToOpenWishlist;

    @FindBy(id = "tab_sho-list")
    protected WebElement wishListPage;





}

