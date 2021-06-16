package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import java.util.List;

public class ApotekaLaurusPOMTest extends BaseTest
{
    @Test
    public void apotekaLaurusLogin() throws InterruptedException
    {
        String email = "bojanaboz@hotmail.com";
        String password = "LaraTatar";
        ALLoginPage loginpage = new ALLoginPage(driver);
        loginpage.userLogin(email, password);
        WebElement message = driver.findElement(By.className("welcome-msg"));
        Assert.assertTrue("Unable to login!", message.getText().contains("Na ovom mestu možete videti istoriju svojih narudžbina kao i izmeniti podatke naloga - adrese za isporuku, lične podatke, lozinku idr. "));
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div/div[2]/ul/li[2]/a"));
        Assert.assertTrue("Not login!", logoutButton.getText().contains("LOG OUT"));

        ALSearchPage alsearch = new ALSearchPage(driver);
        alsearch.chooseBrandSection();


        ALBrandPage brandspage = new ALBrandPage(driver);
        brandspage.chooseBrand();
        wdWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("grid")));
        WebElement productHolder = driver.findElement(By.id("grid"));
        List<WebElement> products = productHolder.findElements(By.className("item"));
        System.out.println("Articles number on first page:" + products.size());

        int iteNo = Integer.parseInt(brandspage.itemsNo);
        //Confirm that nuber of product is correct
        Assert.assertTrue("Not correct No", products.size()<=iteNo);




        ALIjpPage ijppage = new ALIjpPage(driver);
        ijppage.chooseArticle();
        double specialPrice = Double.parseDouble(ijppage.specialPriceT);
        double oldPrice = Double.parseDouble(ijppage.oldPriceT);

        //Confirm special price is less than non-special price
        Assert.assertTrue("Not true!",specialPrice<oldPrice);

        //Confirm choosen article brand is required brand
        Assert.assertEquals("Choosen article is not from choosen brand!", brandspage.choosenBrand, ijppage.brandname);



    ALEchinaceaPage echinacea = new ALEchinaceaPage(driver);
    echinacea.orderArticle();
    double unitArticlePrice = Double.parseDouble(echinacea.unitPrice);
    double totalArticlePrice = Double.parseDouble(echinacea.totalPrice);

        //Confirm article price in basket is special price
        double actualPrice = Double.parseDouble(ijppage.specialPriceT);
        Assert.assertEquals("Not correct actual price!", actualPrice, unitArticlePrice, 0.01);

        wdWait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("price"),"979,77 din."));
        //Confirm that total price is correctly calculated
        Assert.assertTrue("Not correctly calculated!",totalArticlePrice==(2.00*unitArticlePrice));



        //Left for visual confirmation
        Thread.sleep(3000);
}
    }


