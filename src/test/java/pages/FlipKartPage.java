package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FlipKartPage {

    WebDriver driver;

    public FlipKartPage(WebDriver driver)
    {
        this.driver = driver;
        this.driver.get("https://www.flipkart.com/");
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/button")
    WebElement closePopUp;
    @FindBy(how = How.XPATH, using = "//a[@href='/viewcart?otracker=Cart_Icon_Click']")
    WebElement cartIcon;

    public void closeLoginPopUp()
    {
        closePopUp.click();
    }

    public void selectCategoryByClass(String categoryClass)
    {
        Actions actions = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("//span[@class='_1QZ6fC _3Lgyp8' and text()='"+ categoryClass +"']"));
        actions.moveToElement(category).perform();
    }


    public void selectOption(String title)
    {
        driver.findElement(By.xpath("//a[@title ='" + title +"']")).click();
    }

    public void clickCartIcon()
    {
        cartIcon.click();
    }

}
