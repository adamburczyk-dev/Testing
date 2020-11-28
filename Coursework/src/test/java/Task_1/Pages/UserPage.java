package Task_1.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserPage {
    private static WebDriver driver;

    public UserPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewAddress(){
        boolean isAnyAddressExist;

        //Check if is at least one Address
        try{
            WebElement addresses = driver.findElement(By.id("addresses-link"));
            isAnyAddressExist = true;
        }
        catch (NoSuchElementException e){
            isAnyAddressExist = false;
        }

        //Creating a New Address
        if (isAnyAddressExist = true){
            WebElement addressesWindow = driver.findElement(By.id("addresses-link"));
            addressesWindow.click();
            WebElement newAddress = driver.findElement(By.cssSelector("#content > div.addresses-footer > a"));
            newAddress.click();
        }
        else {
            WebElement NewAddress = driver.findElement(By.id("address-link"));
            NewAddress.click();
        }

    }

    public void DeleteLastAddress(){
        //Find last Address
        List<WebElement> addresses = driver.findElements(By.tagName("article"));
        WebElement lastAddress = addresses.get(addresses.size()-1);
        //Find delete button
        WebElement deleteButton = lastAddress.findElement(By.cssSelector("[data-link-action='delete-address']"));
        deleteButton.click();

    }

}
