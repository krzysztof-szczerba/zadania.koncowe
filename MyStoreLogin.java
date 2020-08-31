package zadanie1;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class MyStoreLogin {
    private WebDriver driver;

    @Given("User is not logged and is on (.*)")
    public void goToLoginPage(String LoginPage) {
        // Skonfiguruj sterownik przeglądarki
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver");
        // Uruchom nowy egzemplarz przeglądarki Chrome
        driver = new ChromeDriver();
        // Zmaksymalizuj okno przeglądarki
        driver.manage().window().maximize();
        // Przejdź do Google
        driver.get(LoginPage);
    }

    @When("^user inputs (.*) into email field$")
    public void userInputsEmailIntoEmailField(String Email) {
        WebElement element = driver.findElement(By.name("email"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(Email);
    }

    @And("^user inputs (.*) into password field$")
    public void userInputsPasswordIntoPasswordField(String Password) {
        WebElement element = driver.findElement(By.name("password"));
        // Wyczyść tekst zapisany w elemencie
        element.clear();
        // Wpisz informacje do wyszukania
        element.sendKeys(Password);
    }

    @And("^user clicks Sign In button$")
    public void userClicksSignInButton() {
        driver.findElement(By.id("submit-login")).click();
    }

    @And("user clicks Addresses button")
    public void userClicksAddressesButton() {
        driver.findElement(By.id("addresses-link")).click();
    }

    @And("user clicks Create new address button")
    public void userClicksCreateNewAddressButton() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span")).click();
    }

    @And("user inputs (.*) in alias field")
    public void userInputsAlias(String Alias) {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")).sendKeys(Alias);
    }

    @And("user inputs (.*) in address field")
    public void userInputsAddress(String Address) {
        driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(10) > div.col-md-6 > input")).click();
        driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(10) > div.col-md-6 > input")).sendKeys(Address);
    }
    @And("user inputs (.*) in city field")
    public void userInputsCity(String City) {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")).sendKeys(City);
    }

    @And("user selects United Kingdom in Country drop-down list")
    public void userSelectsCountry() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]")).click();
    }

}
