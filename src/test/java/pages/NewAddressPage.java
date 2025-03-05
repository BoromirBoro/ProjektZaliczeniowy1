package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class NewAddressPage {
    private WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement zipInput;

    @FindBy(id = "field-id_country")
    private WebElement countryDropDownListToggle;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(className = "form-control-submit")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillAddressForm(String alias, String address, String city, String zip, String country, String phone) {
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipInput.sendKeys(zip);
        Select countrySelect = new Select(countryDropDownListToggle);
        countrySelect.selectByVisibleText(country);
        phoneInput.sendKeys(phone);
        // Nie klikamy saveButton tutaj – weryfikacja będzie przed zapisaniem
    }

    public void verifyFormData(String alias, String address, String city, String zip, String country, String phone) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Czekaj, aż wszystkie pola będą widoczne i interaktywne
        wait.until(ExpectedConditions.visibilityOf(aliasInput));
        wait.until(ExpectedConditions.visibilityOf(addressInput));
        wait.until(ExpectedConditions.visibilityOf(cityInput));
        wait.until(ExpectedConditions.visibilityOf(zipInput));
        wait.until(ExpectedConditions.visibilityOf(countryDropDownListToggle));
        wait.until(ExpectedConditions.visibilityOf(phoneInput));

        // Pobierz wartości z pól formularza
        String actualAlias = aliasInput.getAttribute("value").trim();
        String actualAddress = addressInput.getAttribute("value").trim();
        String actualCity = cityInput.getAttribute("value").trim();
        String actualZip = zipInput.getAttribute("value").trim();
        String actualPhone = phoneInput.getAttribute("value").trim();

        // Pobierz wybrany kraj z listy rozwijanej
        Select countrySelect = new Select(countryDropDownListToggle);
        String actualCountry = countrySelect.getFirstSelectedOption().getText().trim();

        // Porównaj z podanymi danymi
        Assert.assertEquals("Alias does not match the provided value", alias, actualAlias);
        Assert.assertEquals("Address does not match the provided value", address, actualAddress);
        Assert.assertEquals("City does not match the provided value", city, actualCity);
        Assert.assertEquals("Zip does not match the provided value", zip, actualZip);
        Assert.assertEquals("Country does not match the provided value", country, actualCountry);
        Assert.assertEquals("Phone does not match the provided value", phone, actualPhone);
    }

    public void hitSaveButton(){
        saveButton.click();
    }
}
