package Task_1;

import Task_1.Pages.LoginPage;
import Task_1.Pages.NewAddressPage;
import Task_1.Pages.UserPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_1 {
    private static WebDriver driver;


    @Given("^An open browser with https://prod-kurs.coderslab.pl")
        public void SetUp(){
            //Configure the browser driver
            System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");

            //Open browser window
            driver = new ChromeDriver();

            //Maximize window
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            //Go to prod-kurs site
            driver.get("https://prod-kurs.coderslab.pl/");

            //Go to login site
            WebElement element = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a"));
            element.click();

    }

    @And("Logged in user")
        public void LogInWithProperCredentials(){
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loginAs("munpoofczxnmaucaof@kiabws.online", "123456");
            Assert.assertEquals("Adam Burczyk", loginPage.getLoggedUsername());
    }

    @When("User click in Create New Address button")
        public void createNewAddress(){
            UserPage userPage = new UserPage(driver);
            userPage.createNewAddress();
    }

    @And("A keyword (.*) is entered in Alias field")
        public void fillAlias(String keyword){
            NewAddressPage newAddressPage = new NewAddressPage(driver);
            newAddressPage.SetAlias(keyword);
    }

    @And("A keyword (.*) is entered in Address field")
        public void fillAddress(String keyword){
            NewAddressPage newAddressPage = new NewAddressPage(driver);
            newAddressPage.SetAddress(keyword);
    }

    @And("A keyword (.*) is entered in City field")
        public void fillCity(String keyword){
            NewAddressPage newAddressPage = new NewAddressPage(driver);
            newAddressPage.SetCity(keyword);
    }

    @And("A Zip/Postal Code (.*) is entered in Zip/Postal field")
        public void fillZip(String keyword){
            NewAddressPage newAddressPage = new NewAddressPage(driver);
            newAddressPage.SetZip(keyword);
    }


    @And("A Phone number (.*) is entered in Phone field")
        public void fillPhone(String keyword){
            NewAddressPage newAddressPage = new NewAddressPage(driver);
            newAddressPage.SetPhoneNumber(keyword);
    }

    @And("A new address is saved")
        public void saveAddress(){
            NewAddressPage newAddressPage = new NewAddressPage(driver);
            newAddressPage.SaveNewAddress();

            //Assert success alert
            WebElement successAlert = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div"));
            Assert.assertTrue(successAlert.getText().contains("Address successfully added!"));
    }

    @Then("Data validation (.*) (.*) (.*) (.*) (.*)")
        public void dataValidation(String Alias, String Address, String City, String Zip, String Phone){
            //Creating list of all adresses
            List<WebElement> addresses = driver.findElements(By.tagName("article"));
            String value = addresses.get(addresses.size()-1).getText();

            //Validation
            Assert.assertTrue(value.contains(Alias));
            Assert.assertTrue(value.contains(Address));
            Assert.assertTrue(value.contains(City));
            Assert.assertTrue(value.contains(Zip));
            Assert.assertTrue(value.contains(Phone));

    }

    @And("Deleting the created address")
        public void deleteAddress(){
            UserPage userPage = new UserPage(driver);
            userPage.DeleteLastAddress();
            //Assert deleting alert
            WebElement deletingAlert = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article"));
            Assert.assertTrue(deletingAlert.getText().contains("Address successfully deleted!"));
    }

    @And("Logout and close browser")
        public void tearDown() {
            WebElement signOutButton = driver.findElement(By.cssSelector("#_desktop_user_info > div > a.logout.hidden-sm-down"));
            signOutButton.click();
             driver.quit();
        }


}
