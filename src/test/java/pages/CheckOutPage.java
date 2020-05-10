package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import utils.PropertyManager;

import java.io.File;
import java.io.IOException;

public class CheckOutPage {

    private static final String SCREENSHOT_LOCATION = PropertyManager.getInstance().getScreenshotLocation();


    WebDriver driver;

    public CheckOutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//input[@class='_2zrpKA _3X0qwn']")
    WebElement inputUsername;
    @FindBy(how = How.XPATH, using = "//button[@type='submit' and @class='_2AkmmA T7K48m _7UHT_c' ]")
    WebElement loginContinueButton;
    @FindBy(how = How.XPATH, using = "//input[@type='password']")
    WebElement inputPassword;
    @FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA T7K48m _7UHT_c' and @type='submit']")
    WebElement loginButton;
    @FindBy(how = How.XPATH, using = "//input[@class='_35lzyU' and @type='email']")
    WebElement orderConfirmEmail;
    @FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _2Q4i61 _7UHT_c']")
    WebElement orderConfirmationContinue;
    @FindBy(how = How.XPATH, using = "//div[@class='_3i_pKg' and text()='Net Banking']")
    WebElement netBankingPaymentOption;
    @FindBy(how = How.XPATH, using = "//select[@class='_1CV081']")
    WebElement otherBankOption;
    @FindBy(how = How.XPATH, using = "//button[@class='_2AkmmA _2BikcQ _7UHT_c']")
    WebElement paymentButton;

    public void setInputUsername(String userName)
    {
        inputUsername.sendKeys(userName);
    }

    public void clickLoginContinueButton()
    {
        loginContinueButton.click();
    }

    public void setInputPassword(String password)
    {
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton()
    {
        loginButton.click();
    }

    public void setOrderConfirmEmail(String inputEmailID)
    {
        orderConfirmEmail.sendKeys(inputEmailID);
    }

    public void clickOrderConfirmContinue()
    {
        orderConfirmationContinue.click();
    }

    public void selectNetBanking()
    {
        netBankingPaymentOption.click();
    }

    public void selectBankName(String bankName)
    {
        Select bankNameElement = new Select(otherBankOption);
        bankNameElement.selectByVisibleText(bankName);
    }

    public void clickPaymentButton()
    {
        paymentButton.click();
    }

    public void takeScreenShot() throws IOException
    {
        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File screenFile = screenshot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(SCREENSHOT_LOCATION + "paymentPicture.jpg");
        FileUtils.copyFile(screenFile, DestFile);
    }

}
