package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert; // Dodane do weryfikacji
import java.time.Duration;
import java.util.List;

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
        saveButton.click();
    }
}
