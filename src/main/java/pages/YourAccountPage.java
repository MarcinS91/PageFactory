package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourAccountPage {

    public YourAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "history-link")
    WebElement orderHistoryTab;

    public void goToOrderHistoryPage() {
        orderHistoryTab.click();
    }
}
