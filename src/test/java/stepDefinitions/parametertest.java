package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class parametertest {


    private WebDriver driver;

    @Before("@parameter")
    public void setup(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After("@parameter")
    public void TearDown(){
        driver.quit();
    }

    @Given("I access the webdriver universitys contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
        System.out.println("Test1");
        //throw new io.cucumber.java.PendingException();
    }
    @When("I enter a unique First Names {word}")
    public void i_enter_a_unique_first_name(String Firstname) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(Firstname);
        System.out.println(Firstname);
        // throw new io.cucumber.java.PendingException();
    }

    @And("I Enter a unique Last Names {word}")
    public void i_enter_a_unique_last_name(String Lastname) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys(Lastname);
        System.out.println(Lastname);
        // throw new io.cucumber.java.PendingException();
    }
    @And("I Enter a unique Email addresss {word}")
    public void i_enter_a_unique_email_address(String email) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys(email);
        System.out.println(email);
        //throw new io.cucumber.java.PendingException();
    }
    @And("I Enter a unique Comments {string}")
    public void i_enter_a_unique_comment(String comment) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys(comment);
        System.out.println(comment);
        //  throw new io.cucumber.java.PendingException();
    }
    @And("I Click on the submits button")
    public void i_click_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        By.xpath("//input[@value='SUBMIT']").findElement(driver).click();
        System.out.println("Test7");
        //throw new io.cucumber.java.PendingException();
    }
    @Then("I Should be presented with a successful contact us submission messages")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        // Write code here that turns the phrase above into concrete actions
//       WebElement contact_us_message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
//        Assert.assertEquals("Thank You for your Message!", contact_us_message.getText());
        System.out.println("Test8");
        //throw new io.cucumber.java.PendingException();
    }
}
