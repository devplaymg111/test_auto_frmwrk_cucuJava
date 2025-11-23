package stepDefinitions;
import PageObjects.Base_PO;
import PageObjects.Contact_Us_PO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;

public class Contact_us extends Base_PO {

    private Contact_Us_PO contact_us_po;

    public Contact_us(Contact_Us_PO contact_us_po) {
        this.contact_us_po = contact_us_po;
    }

    private final WebDriver driver = getDriver();


//    @Before("@contact-us")
//    public void setup(){
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//    }
//
//    @After("@contact-us")
//    public void TearDown(){
//        driver.quit();
//    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        // Write code here that turns the phrase above into concrete actions
       //navigateto_Url("https://webdriveruniversity.com/Contact-Us/contactus.html");
        contact_us_po.navigateTo_WebDriverUniversity_Contact_Us_Page();
        System.out.println("Test1");
        //throw new io.cucumber.java.PendingException();
    }
    @When("I enter a unique First Name")
    public void i_enter_a_unique_first_name() {
        // Write code here that turns the phrase above into concrete actions
     //   driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Tester" );
        contact_us_po.setUnique_FirstName();
     //   System.out.println("Test2");
       // throw new io.cucumber.java.PendingException();
    }

    @And("I Enter a unique Last Name")
    public void i_enter_a_unique_last_name() {
        // Write code here that turns the phrase above into concrete actions
      //  driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[2]")).sendKeys("LastnameT");
        contact_us_po.setUnique_LastName();
       // System.out.println("Test4");
       // throw new io.cucumber.java.PendingException();
    }
    @And("I Enter a unique Email address")
    public void i_enter_a_unique_email_address() {
        // Write code here that turns the phrase above into concrete actions
      //  driver.findElement(By.xpath("//*[@id=\"contact_form\"]/input[3]")).sendKeys("email.email.com");
        //System.out.println("Test5");
        contact_us_po.setUnique_EmailAddress();
        //throw new io.cucumber.java.PendingException();
    }
    @And("I Enter a unique Comment")
    public void i_enter_a_unique_comment() {
        // Write code here that turns the phrase above into concrete actions
     //   driver.findElement(By.xpath("//textarea[@placeholder='Comments']")).sendKeys("CommentsEnters");
      //  System.out.println("Test6");
        contact_us_po.setUnique_Comment();
      //  throw new io.cucumber.java.PendingException();
    }
    @And("I Click on the submit button")
    public void i_click_on_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
      //  By.xpath("//input[@value='SUBMIT']").findElement(driver).click();
       // System.out.println("Test7");
        contact_us_po.clickOn_Submit_Button();
        //throw new io.cucumber.java.PendingException();
    }
    @Then("I Should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        // Write code here that turns the phrase above into concrete actions
//       WebElement contact_us_message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
//        Assert.assertEquals("Thank You for your Message!", contact_us_message.getText());
      //  System.out.println("Test8");
        contact_us_po.validate_Successful_SubmissionMessage_Text();
        //throw new io.cucumber.java.PendingException();
    }


}
