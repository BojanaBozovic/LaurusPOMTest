package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ALBrandPage extends BaseHelper
{
@FindBy(id = "ambrands-search-input")
WebElement searchBrandField;
@FindBy(xpath = "/html/body/div[1]/div/section/div/article/div/div[2]/div[1]/div/div/a")
WebElement ijpBrand;

public String choosenBrand;
public String itemsNo;

    private void enterBrandIntoSearchBrandField()
{
      wdWait.until(ExpectedConditions.visibilityOf(searchBrandField));
      searchBrandField.click();
      searchBrandField.sendKeys("JOSIF PA");
}
    private void chooseIJPBrand()
{
       wdWait.until(ExpectedConditions.visibilityOf(ijpBrand));
       choosenBrand = ijpBrand.getText();
       System.out.println("Choosen brand:"+choosenBrand);
       ijpBrand.click();
       wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/section/div[2]/article/div/article/div[1]/div/div[2]/div[2]/div")));
       itemsNo = driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/article/div/article/div[1]/div/div[2]/div[2]/div")).getText();
       System.out.println("ItemsNo:"+itemsNo);
}
public void chooseBrand()
{
    enterBrandIntoSearchBrandField();
    chooseIJPBrand();
}
    WebDriver driver;
    public ALBrandPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
