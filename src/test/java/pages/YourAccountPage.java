package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        addressesButton.click();
    }
}
