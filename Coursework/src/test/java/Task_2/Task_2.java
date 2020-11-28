package Task_2;

import Task_1.Pages.LoginPage;
import Task_2.Pages.CartPage;
import Task_2.Pages.DeliveryPage;
import Task_2.Pages.ProductPage;
import Task_2.Pages.Searching;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task_2 {
    private WebDriver driver;
    //Order Number
    private String Order_number;
    //Amount
    private String Amount;
    //Last Order
    private String Last_Order;

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
    public void Log_in() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("munpoofczxnmaucaof@kiabws.online", "123456");
        Assert.assertEquals("Adam Burczyk", loginPage.getLoggedUsername());

    }

    @When("Search a product")

    public void Searching(){
        //Searching Sweater
        Searching searching = new Searching(driver);
        searching.SearchASweater();
    }

    @And("Check Discount")

    public void CheckingDiscount() {
        //Validate Discount
        ProductPage productPage = new ProductPage(driver);
        Assert.assertTrue(productPage.checkDiscount().contains("20%"));

    }


    @And("Choose Size (.*) and count (.*)")
    public void SetValues(String Size, String Count){
        ProductPage productPage = new ProductPage(driver);

        //Choose Size
        productPage.SetSize(Size);
        //Choose Quantity
        productPage.SetQuantity(Count);
    }


    @And("Add to Cart")
    public void AddToCart() {
        ProductPage productPage = new ProductPage(driver);
        //AddToCart
        productPage.AddToCart();
    }


    @And("Go to checkout")
    public void Checkout() {
        //Go to Checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.goToCheckout();
    }

    @And("Set Delivery Conditions")

    public void SetDelivery(){
        DeliveryPage deliveryPage = new DeliveryPage(driver);

        //Accept current address
        deliveryPage.AcceptAddress();

        //Choose Delivery to Presta Shop
        deliveryPage.deliveryPrestaShop();

        //Pay By Check
        deliveryPage.PayByCheck();

        //Accept all conditions and terms
        deliveryPage.AcceptAll();

    }

    @And("Take a screenshot")
    public void TakeAScreenShot() throws IOException {

        //Screenshot
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("Screenshots/screenshot1.png"));
    }

    @Then("Order has status Awaiting check Payment and values are valid")

    public void CheckValues(){

        //Order Number
        WebElement number = driver.findElement(By.xpath("//*[contains(text(), 'Order reference:')]"));
        Order_number = number.getText();
        String[] Order = Order_number.split(" ");
        Order_number = Order[Order.length - 1];

        //Order Amount
        WebElement amount = driver.findElement(By.xpath("//*[@id=\"content-hook_payment_return\"]/div/div/div/p/span/strong"));
        Amount = amount.getText();


        //Go To history orders
        WebElement konto = driver.findElement(By.cssSelector("#_desktop_user_info > div > a.account > span"));
        konto.click();
        WebElement history = driver.findElement(By.id("history-link"));
        history.click();

        //History of Orders
        List<WebElement> Zamówienia = driver.findElements(By.tagName("tr"));

        //Search row with Order Number
        for (int i = 0; i < Zamówienia.size(); i++){
            if(Zamówienia.get(i).getText().contains(Order_number)){
                System.out.println("Numer: " + Order_number + " znaleziony!");
                Last_Order= Zamówienia.get(i).getText();
            }
        }

        //Assertion
        Assert.assertTrue(Last_Order.contains(Order_number));
        Assert.assertTrue(Last_Order.contains(Amount));
    }

    @And("tearDown")
    public void tearDown(){
        driver.quit();
    }
}



