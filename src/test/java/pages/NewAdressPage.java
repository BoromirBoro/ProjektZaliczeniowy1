package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAdressPage {

    private WebDriver driver;

    public NewAdressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    WebElement aliasInput;

    @FindBy(id = "field-address1")
    WebElement addressInput;

    @FindBy(id = "field-city")
    WebElement cityInput;

    @FindBy(id = "field-postalcode")
    WebElement zipInput;

    @FindBy(id = "field-id_country")
    WebElement countryDropDownListToggle;

    @FindBy(id = "field-phone")
    WebElement phoneInput;

    @FindBy(className = "form-control-submit")
    WebElement saveButton;

    @FindBy(css = ".address-body")
    private WebElement addedAddress;

    public void fillAddressForm(String alias, String address, String city, String zip, String country, String phone){
        aliasInput.sendKeys(alias);
        addressInput.sendKeys(address);
        cityInput.sendKeys(city);
        zipInput.sendKeys(zip);

        Select countrySelect = new Select(countryDropDownListToggle);
        countrySelect.selectByVisibleText(country);

        phoneInput.sendKeys(phone);
        saveButton.click();
    }

    public String getAddedAddressText(){
        return addedAddress.getText();
    }
}
