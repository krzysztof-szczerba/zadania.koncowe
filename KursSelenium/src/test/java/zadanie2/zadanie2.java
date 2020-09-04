package zadanie2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;


public class zadanie2 {

    private WebDriver driver;

    public String loginPage = "https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account";

    @Given("^Registered user is not logged and is on login page$")
    public void registeredUserIsOnLoginPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get(loginPage);
    }

    @When("^Registered user inputs (.*) into email field$")
    public void registeredUserInputsEmailIntoEmailField(String Email) {
        WebElement element = driver.findElement(By.name("email"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(Email);
    }

    @And("^Registered user inputs (.*) into password field$")
    public void registeredUserInputsPasswordIntoPasswordField(String Password) {
        WebElement element = driver.findElement(By.name("password"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(Password);
    }

    @And("^Registered user clicks Sign In button$")
    public void registeredUserClicksSignInButton() {
        driver.findElement(By.id("submit-login")).click();
    }

    @And("^User clicks on Search Our Catalog field, searches for Hummingbird Printed Sweater and chooses (.*)$")
    public void searchProduct(String size) {
        driver.findElement(By.name("s")).click();
        driver.findElement(By.name("s")).sendKeys("Hummingbird Printed Sweater", Keys.ENTER);
        driver.findElement(By.linkText("Hummingbird Printed Sweater")).click();
        Select dropDownValue = new Select (driver.findElement(By.name("group[1]")));
        dropDownValue.selectByVisibleText(size);


    }

    @And("^User selects quantity of a product$")
    public void userSelectsQuantityOfAProduct() throws InterruptedException {

        driver.findElement(By.id("quantity_wanted")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("quantity_wanted")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("quantity_wanted")).sendKeys("5", Keys.ENTER);
    }


    @And("^Proceed to Checkout$")
    public void proceedToCheckout() throws InterruptedException {
        Thread.sleep(1500);
        WebElement proceedButton = driver.findElement(By.xpath("//*[@class='cart-content-btn']" +
                "//*[@class='btn btn-primary']"));
        proceedButton.click();
        WebElement proceedButton2 = driver.findElement(By.xpath("//*[@class='text-sm-center']" +
                "//*[@class='btn btn-primary']"));
        proceedButton2.click();
    }

    @And("^Confirm order$")
    public void confirmOrder() {
        /*This method/function:
        a) confirms by click that earlier created address is correct for this order,
        b) chooses shipping method,
        c) chooses payment method
        d) ticks a box what confirms that user agrees with terms of service
        e) confirms order
        */
        driver.findElement(By.name("confirm-addresses")).click();
        driver.findElement(By.xpath("//*[@class='custom-radio float-xs-left']" +
                "//*[@id='delivery_option_1']")).sendKeys("1");
        driver.findElement(By.xpath("//*[@class='continue btn btn-primary float-xs-right']")).click();
        driver.findElement(By.id("payment-option-1")).click();
        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        driver.findElement(By.xpath("//*[@class='btn btn-primary center-block']")).click();

    }

    @And("^Take a screenshot$")
    public void takeAScreenshot() throws IOException {
        File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source_file, new File("/home/krzysztof/IdeaProjects/KursSelenium/" +
                "src/test/java/zadanie2/screenshots/order-confirmation.png"));
    }

    @Then("^User confirms order has been made$")
    public void userConfirmsOrderHasBeenMade() {
        String message = "YOUR ORDER IS CONFIRMED";
        WebElement confirmationMessage = driver.findElement(By.xpath("//*[@class='h1 card-title']"));
        Assert.assertTrue(confirmationMessage.getText().contains(message));
        System.out.println("DONE");
        driver.quit();


    }
}


