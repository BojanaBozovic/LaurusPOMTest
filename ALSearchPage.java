package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ALSearchPage extends BaseHelper
{
   @FindBy(className = "custom-nav")
   WebElement customerHolder;
  // @FindBy(className = "bare-list")
   // WebElement brandHolder;

   private void clickOnBrendoviButton()
   {
       WebElement message = driver.findElement(By.className("welcome-msg"));
       wdWait.until(ExpectedConditions.visibilityOf(message));
       List<WebElement>brendovi = customerHolder.findElements(By.tagName("a"));
       brendovi.get(1).click();
   }
  public void chooseBrandSection()
  {
      clickOnBrendoviButton();
  }
    WebDriver driver;
    public ALSearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
