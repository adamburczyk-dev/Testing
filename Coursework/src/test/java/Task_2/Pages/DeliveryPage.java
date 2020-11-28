package Task_2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeliveryPage {
    private static WebDriver driver;

    public DeliveryPage(WebDriver driver){
        this.driver = driver;
    }

    public void AcceptAddress(){
        WebElement addresses = driver.findElement(By.name("confirm-addresses"));
        addresses.click();
    }

    public void deliveryPrestaShop(){
        WebElement delivery = driver.findElement(By.id("delivery_option_1"));

        try{
            delivery.click();
        }
        catch(ElementClickInterceptedException e) {

        }
        WebElement acceptDelivery = driver.findElement(By.name("confirmDeliveryOption"));
        acceptDelivery.click();
    }

    public void PayByCheck(){
        WebElement payment = driver.findElement(By.id("payment-option-1"));

        try{
            payment.click();
        }
        catch(ElementClickInterceptedException e) {

        }

        WebElement checkout1 = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        checkout1.click();
    }

    public void AcceptAll(){

        WebElement submit2 = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]//button"));
        submit2.click();
    }

}
