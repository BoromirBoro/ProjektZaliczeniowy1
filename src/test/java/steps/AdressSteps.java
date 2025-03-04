package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.AddressesPage;
import pages.LoginPage;
import pages.NewAddressPage;
import pages.YourAccountPage;


import java.time.Duration;

public class AdressSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private YourAccountPage yourAccountPage;
    private NewAddressPage newAddressPage;
    private AddressesPage addressesPage;

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
        yourAccountPage.clickAddressOption();
        addressesPage = new AddressesPage(driver);
    }

    @And("I click the Create new address button")
    public void iClickTheCreateNewAddressButton() {
        addressesPage.clickCreateNewAddressBtn();
    }

    @Then("I should be on the addresses page")
    public void iShouldBeOnTheAddressesPage() {
        String expectedURl = "https://mystore-testlab.coderslab.pl/index.php?controller=address";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURl, currentURL);
    }

    @When("I fill the address form with alias {string}, address {string}, city {string}, zip {string}, country {string}, phone {string}")
    public void fillTheAddNewAddressForm(String alias, String address, String city, String zip, String country, String phone) {
        newAddressPage = new NewAddressPage(driver);
        newAddressPage.fillAddressForm(alias, address, city, zip, country, phone);
    }

    @And("The browser closes")
    public void closeBrowser(){
        driver.quit();
    }


}

