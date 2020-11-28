package Task_2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Searching {
    private static WebDriver driver;

    public Searching(WebDriver driver){
        this.driver = driver;
    }

    public void SearchASweater(){
        //Szukanie produktu
        WebElement search = driver.findElement(By.name("s"));
        search.sendKeys("Hummingbird Printed Sweater");
        search.submit();
        //Kliknięcie w kafelek
        WebElement product = driver.findElement(By.cssSelector("[data-id-product-attribute='9']"));
        product.click();
    }
}
