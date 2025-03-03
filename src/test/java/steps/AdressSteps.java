package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.NewAdressPage;
import pages.YourAccountPage;


import java.time.Duration;

public class AdressSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private YourAccountPage yourAccountPage;
    private NewAdressPage newAdressPage;

    @Given("I am on the mystore login page")
    public void openLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
        loginPage = new LoginPage(driver);
    }

    @When("I login with email {string} and password {string}")
    public void login(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("I should be logged in successfully")
    public void verifySuccessLogin() {
        String expectedURl = "https://mystore-testlab.coderslab.pl/index.php?controller=my-account";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURl, currentURL);
        yourAccountPage = new YourAccountPage(driver);
    }


    @When("I click on the Addresses tile")
    public void clickAddFirstAddress() {
        yourAccountPage.clickAddNewAdress();
    }


    @Then("I should be on the addresses page")
    public void iShouldBeOnTheAddressesPage() {
        String expectedURl = "https://mystore-testlab.coderslab.pl/index.php?controller=address";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURl, currentURL);
    }

    @When("I fill the address form with alias {string}, address {string}, city {string}, zip {string}, country {string}, phone {string}")
    public void fillTheAddNewAddressForm(String alias, String address, String city, String zip, String country, String phone) {
        newAdressPage = new NewAdressPage(driver);
        newAdressPage.fillAddressForm(alias, address, city, zip, country, phone);
    }

    @Then("The new address should be added with alias {string}, address {string}, city {string}, zip {string}, country {string}, phone {string}")
    public void theNewAddressShouldBeAddedWithProvidedData(String alias, String address, String city, String zip, String country, String phone) {
        String addressText = newAdressPage.getAddedAddressText();
        Assert.assertTrue("Alias not found", addressText.contains(alias));
        Assert.assertTrue("Address not found", addressText.contains(address));
        Assert.assertTrue("City not found", addressText.contains(city));
        Assert.assertTrue("Zip not found", addressText.contains(zip));
        Assert.assertTrue("Country not found", addressText.contains(country));
        Assert.assertTrue("Phone not found", addressText.contains(phone));
    }


}

