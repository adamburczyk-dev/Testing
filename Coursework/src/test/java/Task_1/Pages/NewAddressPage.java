package Task_1.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewAddressPage {
    private static WebDriver driver;

    public NewAddressPage (WebDriver driver){
        this.driver = driver;
    }

    public void SetAlias(String Alias){
        WebElement alias = driver.findElement(By.name("alias"));
        //Check if alias is displayed
        if (alias.isDisplayed()){
            WebElement aliasText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/label"));
            //Fill Alias
            alias.clear();
            alias.sendKeys(Alias);
            System.out.println(aliasText.getText() + ": "+ Alias);
        }
        else {
            Assert.fail();
        }
    }

    public void SetAddress(String Address){
        WebElement address = driver.findElement(By.name("address1"));
        //Check if address is displayed
        if (address.isDisplayed()){
            WebElement addressText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[6]/label"));
            //Fill Address
            address.clear();
            address.sendKeys(Address);
            System.out.println(addressText.getText() + ": " + Address);
        }
        else {
            Assert.fail();
        }
    }

    public void SetCity(String City){
        WebElement city = driver.findElement(By.name("city"));
        //Check if city is displayed
        if (city.isDisplayed()){
            WebElement cityText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/label"));
            //Fill City
            city.clear();
            city.sendKeys(City);
            System.out.println(cityText.getText() + ": " + City);
        }
        else {
            Assert.fail();
        }
    }

    public void SetZip(String Zip){
        WebElement zipPostal = driver.findElement(By.name("postcode"));
        //Check if Zip/Postal Code is displayed
        if (zipPostal.isDisplayed()){
            WebElement zipText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[9]/label"));
            //Fill Zip
            zipPostal.clear();
            zipPostal.sendKeys(Zip);
            System.out.println(zipText.getText() + ": " + Zip);
        }
        else {
            Assert.fail();
        }
    }

    public void SetPhoneNumber(String Number){
        WebElement phone = driver.findElement(By.name("phone"));
        //Check if Phone is displayed
        if(phone.isDisplayed()){
            WebElement phoneText = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[11]/label"));
            //Fill Phone Number
            phone.clear();
            phone.sendKeys(Number);
            System.out.println(phoneText.getText() + ": " + Number);
        }
        else {
            Assert.fail();
        }
    }

    public void SaveNewAddress(){
        //Find and click submit button
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        submit.click();

    }
}
