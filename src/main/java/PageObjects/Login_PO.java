package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Global_vars;

public class Login_PO extends Base_PO{

 //   private WebDriver driver;
    private  @FindBy(id = "text")
     WebElement userNameTxtField;

     @FindBy(id = "password")
     WebElement userPasswrd;

    private @FindBy(id = "login-button")
    WebElement login_Button;

//    public Login_PO(){
//        super();
//    }

//    public Login_PO() {
//        super();
////        this.driver = driver;
////        PageFactory.initElements(driver, this);
//           }

      public Login_PO() {
         super();
     }

    public void navigate_to_univerisity_login(){
        //navigateto_Url("https://www.webdriveruniversity.com/Login-Portal/index.html?");
        navigateto_Url(Global_vars.TestURLUniv +"Login-Portal/index.html?");
    }

    public void setUserName(String username){
        sendKeys(userNameTxtField,username);
    }

    public void setPasswrd(String paswd){
        sendKeys(userPasswrd,paswd);
    }

    public void clickOn_Login_Button() {
        //waitForWebElementAndClick(login_Button);
        clickWhenClickable(login_Button);
    }
}

