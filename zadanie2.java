package zadanie2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;


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

    @And("^User clicks on Search Our Catalog field$")
    public void searchProduct() {
        driver.findElement(By.name("s")).click();
        driver.findElement(By.name("s")).sendKeys("Hummingbird Printed Sweater", Keys.ENTER);
        driver.findElement(By.linkText("Hummingbird Printed Sweater")).click();
        Select dropDownValue = new Select (driver.findElement(By.name("group[1]")));
        dropDownValue.selectByValue("2");


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
    public void proceedToCheckout() {
//        driver.findElement(By.className("btn btn-primary")).click();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=cart&action=show");
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=order");
        driver.findElement(By.name("confirm-addresses")).click();
    }
}


