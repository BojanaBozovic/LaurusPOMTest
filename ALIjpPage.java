package pages;

import helpers.BaseHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ALIjpPage extends BaseHelper
{
    @FindBy(className = "products-grid")
    WebElement ijpItems;
    @FindBy(id = "product-addtocart-button")
    WebElement addToBasketButton;
    @FindBy(id = "old-price-43509")
    WebElement oldPriceText;
    @FindBy(id = "product-price-43509")
    WebElement specialPriceText;

    public String oldPriceT;
    public String specialPriceT;
    public String brandname;




    private void clickOnArticle()
    {
        List<WebElement> ijpitem = ijpItems.findElements(By.tagName("img"));
        js.executeScript("arguments[0].click();", ijpitem.get(3));
    }

    private void printPrices() {
        oldPriceT = oldPriceText.getText().replace("din.", "").replace(",", ".");
        System.out.println("Old price:" + oldPriceT);

        specialPriceT = specialPriceText.getText().replace("din.", "").replace(",", ".");
        System.out.println("Special price:" + specialPriceT);
    }

    private void addToBasket() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("brand-link")));
        WebElement brandName = driver.findElement(By.className("brand-link"));
        brandname = brandName.getText().replace("Proizvođač:", "").trim();
        System.out.println("Brand name:" + brandname);

        wdWait.until(ExpectedConditions.elementToBeClickable(By.id("product-addtocart-button")));
        js.executeScript("arguments[0].click();", addToBasketButton);
    }

    public void chooseArticle() {
        clickOnArticle();
        printPrices();
        addToBasket();
    }

    WebDriver driver;

    public ALIjpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}