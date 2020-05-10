package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Wait;

import java.util.Set;

public class ProductDetailsPage {

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
    WebElement addToCartButton;
//    @FindBy(how = How.XPATH, using = "//img[@title='Flipkart']")
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div[1]/div[2]/div[1]/div/a[1]/img")
    WebElement homeIcon;


    public void setAddToCartButton()
    {
        Wait.until(driver, ExpectedConditions.elementToBeSelected(addToCartButton));
        addToCartButton.click();
    }

    public void switchToProductDetailsPage()
    {
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles)
        {
            System.out.println(handle);
            driver.switchTo().window(handle);
        }
    }

    public void clickHomeIcon()
    {
        homeIcon.click();
    }


}
