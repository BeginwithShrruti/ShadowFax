package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CategoryPage {

    WebDriver driver;

    public CategoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void selectProduct(String productTitle)
    {
        WebElement webElement = driver.findElement(By.xpath("//a[contains(@title,'" + productTitle +"')]"));
        webElement.click();
    }
}
