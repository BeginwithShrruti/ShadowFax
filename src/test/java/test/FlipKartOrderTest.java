package test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.*;
import utils.PropertyManager;
import utils.Wait;

import java.io.IOException;

public class FlipKartOrderTest extends TestBase
{
    private static final Logger LOGGER = LogManager.getLogger(FlipKartOrderTest.class);
    private static final String USERNAME = PropertyManager.getInstance().getFlipkartUsername();
    private static final String PASSWORD = PropertyManager.getInstance().getFlipkartPassword();

    @Test
    public void checkOutFlowTest() throws IOException, InterruptedException
    {
        LOGGER.info("starting Order Confirmation Test");
        FlipKartPage flipKartPage = PageFactory.initElements(driver, FlipKartPage.class);
        selectCategoryOnHomePage(flipKartPage, "Electronics", "OPPO");
        selectProduct("OPPO F11");
        addToCartOnProductDetailPage();
        flipKartPage.clickCartIcon();
        validateCartAndPlaceOrder("OPPO F11");
        handleCheckOut();
    }

    private void selectCategoryOnHomePage(FlipKartPage flipKartPage, String category, String subCategory)
    {
        LOGGER.info("select category on homepage");
        flipKartPage.closeLoginPopUp();
        flipKartPage.selectCategoryByClass(category);
        flipKartPage.selectOption(subCategory);
    }

    private void selectProduct(String productName)
    {
        LOGGER.info("select product");
        CategoryPage categoryPage = PageFactory.initElements(driver, CategoryPage.class);
        categoryPage.selectProduct(productName);
    }

    private void addToCartOnProductDetailPage() throws InterruptedException
    {
        LOGGER.info("Add to cart");
        ProductDetailsPage productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);
        productDetailsPage.switchToProductDetailsPage();
        productDetailsPage.setAddToCartButton();
        productDetailsPage.clickHomeIcon();
    }

    private void validateCartAndPlaceOrder(String productName)
    {
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        WebElement productInCart = cartPage.getProductInCart(productName);
        assert productInCart != null;
        Wait.untilPageLoadComplete(driver, 5L);
        cartPage.placeOrder();
    }

    private void handleCheckOut() throws InterruptedException, IOException
    {
        CheckOutPage checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);
        checkOutPage.setInputUsername(USERNAME);
        checkOutPage.clickLoginContinueButton();
        checkOutPage.setInputPassword(PASSWORD);
        checkOutPage.clickLoginButton();
        //       checkOutPage.setOrderConfirmEmail("sddixitshruti@gmail.com");
        checkOutPage.clickOrderConfirmContinue();
        checkOutPage.selectNetBanking();
        checkOutPage.selectBankName("Corporation Bank");
        checkOutPage.clickPaymentButton();
        Wait.until(driver, ExpectedConditions.titleContains("CorpNet"));
        checkOutPage.takeScreenShot();
    }
}
