package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ALEchinaceaPage extends BaseHelper
{
    @FindBy(xpath = "/html/body/div[1]/div/section/div/article/div/form/fieldset/table/tbody/tr")
    WebElement orderHolder;
    @FindBy(name = "cart[84400][qty]")
    WebElement quantityField;
    @FindBy(name = "update_cart_action")
    WebElement osveziteKorpuButton;
    @FindBy(className = "success-msg")
    WebElement successMsg;

              public String unitPrice;
              public String totalPrice;

    private void changeQuantity()
{
   wdWait.until(ExpectedConditions.textToBePresentInElement(successMsg,"ECHINACEA KAPI 30ML je dodat u Vašu korpu."));
   quantityField.click();
   quantityField.clear();
   quantityField.sendKeys("2");
}
private void refreshBasket()
{
    osveziteKorpuButton.click();
}
private void comparePrices()
{

    List<WebElement>unitPriceText = orderHolder.findElements(By.tagName("td"));
    unitPrice = unitPriceText.get(3).getText().replace("din.","").replace(",",".");
    System.out.println("Unit price in basket:"+unitPrice);

  //  wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("price"),"979,77 din."));

    totalPrice = unitPriceText.get(5).getText().replace("din.","").replace(",",".");
    System.out.println("Total price in basket:"+totalPrice);
}

public void orderArticle()
{
    changeQuantity();
    refreshBasket();
    comparePrices();
}
    WebDriver driver;
    public ALEchinaceaPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
