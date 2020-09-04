package zadanie1;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreAddress {
    private WebDriver driver;

    @Given("User is logged and is on My Account Page")
    public void goToYourAccountPage() {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=my-account");
    }

//    @When("^user inputs (.*) into email field$")
//    public void userInputsEmailIntoEmailField(String Email) {
//        WebElement element = driver.findElement(By.name("email"));
//        // Wyczyść tekst zapisany w elemencie
//        element.clear();
//        // Wpisz informacje do wyszukania
//        element.sendKeys(Email);
//    }
//
//    @And("^user inputs (.*) into password field$")
//    public void userInputsPasswordIntoPasswordField(String Password) {
//        WebElement element = driver.findElement(By.name("password"));
//        // Wyczyść tekst zapisany w elemencie
//        element.clear();
//        // Wpisz informacje do wyszukania
//        element.sendKeys(Password);
//    }
//
//    @Then("^user clicks Sign In button$")
//    public void userClicksSignInButton() {
//        driver.findElement(By.id("submit-login")).click();
//    }

}