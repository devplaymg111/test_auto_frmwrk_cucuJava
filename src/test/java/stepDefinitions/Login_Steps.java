package stepDefinitions;

import PageObjects.Base_PO;
import PageObjects.Login_PO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Random;

public class Login_Steps extends Base_PO {
    private final WebDriver driver = getDriver();

    private Login_PO loginPo;

    public Login_Steps(Login_PO loginPo){
        this.loginPo = loginPo;
    }

//    @Before("@login")
//    public void setup(){
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//    }
//
//
//    @After("@login")
//    public void tearDown() {
//        driver.quit();
//    }
public static int generateRandomNumber() {
    Random random = new Random();
    int number = 1000 + random.nextInt(9000); // ensures 4 digits
    return number;
}

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        //driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
      //  navigateto_Url("https://www.webdriveruniversity.com/Login-Portal/index.html?");
        loginPo.navigate_to_univerisity_login();
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        // driver.findElement(By.id("text")).sendKeys(username + generateRandomNumber());
       // sendKeys(By.id("text"),username);
          loginPo.setUserName(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        //driver.findElement(By.id("password")).sendKeys(password + generateRandomNumber());
      //  sendKeys(By.id("password"),password);
        loginPo.setPasswrd(password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {

        //driver.findElement(By.id("login-button")).click();
        loginPo.clickOn_Login_Button();
    }

    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation succeeded");
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, "validation failed");
    }

    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        String login_Message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_Message, expectedMessage);
    }
}
