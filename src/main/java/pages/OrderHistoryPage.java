package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    public OrderHistoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[contains(text(), 'Awaiting bank wire payment')])[1]")
    WebElement paymentStatus;

    public String getPaymentStatus() {
        return paymentStatus.getText();
    }
}
