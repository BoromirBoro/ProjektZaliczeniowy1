package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourAccountPage {

    private WebDriver driver;


    public YourAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "address-link")
    private WebElement addFirstAddressButton;

    @FindBy(id = "addresses-link")
    private WebElement addressesButton;

    public void clickAddressOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (wait.until(ExpectedConditions.elementToBeClickable(addFirstAddressButton)).isDisplayed()) {
            addFirstAddressButton.click();
        } else if (wait.until(ExpectedConditions.elementToBeClickable(addressesButton)).isDisplayed()) {
            addressesButton.click();
        } else {
            throw new RuntimeException("Neither 'Add First Address' button nor 'Addresses' button is available or clickable.");
        }
    }
}
