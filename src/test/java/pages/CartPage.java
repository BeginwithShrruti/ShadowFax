package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//span[text()='Place Order']")
    WebElement orderPlace;

    public WebElement getProductInCart(String productName)
    {
        return driver.findElement(By.xpath("//a[contains(text(),'"+ productName +"')]"));
    }

    public void placeOrder()
    {
        orderPlace.click();
    }
}
