package Task_2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private  static WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void goToCheckout(){
        WebElement checkout = driver.findElement(By.cssSelector("a.btn.btn-primary"));
        checkout.click();
    }

}
