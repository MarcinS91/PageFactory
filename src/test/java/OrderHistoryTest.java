import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderHistoryPage;
import pages.YourAccountPage;

public class OrderHistoryTest {

    private static WebDriver driver;

    String url = "https://mystore-testlab.coderslab.pl/index.php";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyPaymentStatus() {
        driver.get(url);
        HomePage homePage = new HomePage(driver);
        homePage.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logToApp();
        YourAccountPage yourAccountPage = new YourAccountPage(driver);
        yourAccountPage.goToOrderHistoryPage();
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        Assert.assertEquals(orderHistoryPage.getPaymentStatus(), "Awaiting bank wire payment");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
