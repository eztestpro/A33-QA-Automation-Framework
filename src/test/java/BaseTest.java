import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import java.time.Duration;


public class BaseTest {
    WebDriver driver;
    By emailField = By.cssSelector("[type='email']");
    By passwordField = By.cssSelector("[type='password']");
    String url = "https://bbb.testpro.io";
    public void openLoginUrl() {
        driver.get(url);
    }
    public void provideEmail (String email) {
        WebElement emailElement = driver.findElement(emailField);
        emailElement.sendKeys(email);
    }
    public void enterPassword (String password) {
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }
    @BeforeMethod
    public void setUpBrowser () {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDownBrowser() {

        driver.quit();
    }
    @BeforeSuite
     static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

}
