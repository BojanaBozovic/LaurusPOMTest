package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ALLoginPage extends BaseHelper
{
@FindBy(className = "links")
    WebElement userHolder;
@FindBy(id = "email")
        WebElement emailAddressField;
@FindBy(id = "pass")
        WebElement passwordField;
@FindBy(id = "send2")
        WebElement ulogujteSeButton;

private void navigateToLaurusHomepage()
{
driver.get("https://shop.apotekalaurus.rs/");
}
private void clickOnLogInButton()
{
    List<WebElement>loginuser = userHolder.findElements(By.tagName("a"));
    loginuser.get(1).click();
}
private void enterEmail(String email)
{
    wdWait.until(ExpectedConditions.visibilityOf(emailAddressField));
    emailAddressField.click();
    emailAddressField.sendKeys(email);
}
private void enterPassword(String password)
{
passwordField.click();
passwordField.sendKeys(password);
}
private void login()
{
    ulogujteSeButton.click();
}
public void userLogin(String email, String password)
{
    navigateToLaurusHomepage();
    clickOnLogInButton();
    enterEmail(email);
    enterPassword(password);
    login();
}

    WebDriver driver;

    public ALLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
