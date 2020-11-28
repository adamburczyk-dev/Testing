package Task_2.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    // Log in
    public void loginAs(String email, String password){
        //Find and fill email field
        WebElement LoginInput = driver.findElement(By.name("email"));
        LoginInput.click();
        LoginInput.clear();
        LoginInput.sendKeys(email);

        //Find and fill password field
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

        //Click Sign in
        WebElement signInbutton = driver.findElement(By.id("submit-login"));
        signInbutton.click();
    }

    public String getLoggedUsername(){
        WebElement userName = driver.findElement(By.xpath("//a[@class='account']"));
        return userName.getText();
    }
}
