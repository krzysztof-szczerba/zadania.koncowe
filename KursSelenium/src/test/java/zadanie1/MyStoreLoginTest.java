package zadanie1;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class MyStoreLoginTest {
    String LoginPage = "https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account";
    private WebDriver driver;

    String Address = "Glowna 2";
    String City = "Wroclaw";
    String Zip = "55-555";
    String Phone = "123456789";
    public String addressPage = "https://prod-kurs.coderslab.pl/index.php?controller=address";

    @Given("User is not logged and is on LoginPage")
    public void goToLoginPage() {
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
        //driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span")).click();
        driver.get(addressPage);
    }

    @And("user inputs (.*) in alias field")
    public void userInputsAlias(String Alias) {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[1]/div[1]/input")).sendKeys(Alias);
    }

    @And("user inputs Address in address field")
    public void userInputsAddress() {
        driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(10) > div.col-md-6 > input")).click();
        driver.findElement(By.cssSelector("#content > div > div > form > section > div:nth-child(10) > div.col-md-6 > input")).sendKeys(Address);
    }
    @And("user inputs City in city field")
    public void userInputsCity() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[8]/div[1]/input")).sendKeys(City);
    }
    @And("^user inputs Zip in zip field$")
    public void userInputsZipPostalCode() {
        driver.findElement(By.name("postcode")).click();
        driver.findElement(By.name("postcode")).sendKeys(Zip);
    }

    @And("user selects United Kingdom in Country drop-down list")
    public void userSelectsCountry() {
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]")).click();
    }



    @And("^user inputs Phone in phone field$")
    public void inputsPhone() {
        driver.findElement(By.name("phone")).click();
        driver.findElement(By.name("phone")).sendKeys(Phone);
    }

    @And("^user clicks Save button$")
    public void userClicksSaveButton() {
        driver.findElement(By.xpath("//*[@id=\"content\"]//button")).click();
    }

    @Then("^user checks address$")
    public void userChecksAddress() {
        WebElement element = driver.findElement(By.xpath("//*[@class='col-lg-4 col-md-6 col-sm-6'][last()]" +
                "//*[@class='address']//*[@class='address-body']/address"));
        Assert.assertTrue(element.getText().contains(Address));
        Assert.assertTrue(element.getText().contains(City));
        Assert.assertTrue(element.getText().contains(Zip));
        Assert.assertTrue(element.getText().contains(Phone));
        System.out.println("DONE");
        driver.quit();
    }
}
