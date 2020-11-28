package Task_2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ProductPage {
    private static WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String checkDiscount(){

        //Find Discount
        WebElement discount = driver.findElement(By.className("current-price"));
        String Discount = discount.getText();
        return Discount;
    }

    public void SetSize(String Size){

        //Choose Size
        Select size = new Select(driver.findElement(By.id("group_1")));
        size.selectByVisibleText(Size);
    }

    public void SetQuantity(String Quantity){

        //Wait 0,5 sec
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }
        catch (InterruptedException e){
        }
        //Choose Quantity
        WebElement quantity = driver.findElement(By.id("quantity_wanted"));
        quantity.sendKeys(Keys.BACK_SPACE, Quantity);
    }

    public void AddToCart(){
        WebElement AddToCart = driver.findElement(By.cssSelector("#add-to-cart-or-refresh > div.product-add-to-cart > div > div.add > button"));
        AddToCart.click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        WebElement send = driver.findElement(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a"));
        send.click();
    }


}
