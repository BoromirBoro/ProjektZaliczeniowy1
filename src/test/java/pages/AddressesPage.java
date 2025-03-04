package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressesPage {


    private  WebDriver driver;

    @FindBy(partialLinkText = "Create new address")
    private WebElement createNewAddressLink;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewAddressBtn(){
        createNewAddressLink.click();
    }


}
