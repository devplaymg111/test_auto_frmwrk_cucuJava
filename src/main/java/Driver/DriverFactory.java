package Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {

    private static ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        if (webdriver.get() == null) {
            webdriver.set(createDriver());
        }
        return webdriver.get();
    }

    private static WebDriver createDriver()
    {
        WebDriver driver = null;

        String browserType = "chrome";

        switch (getBrowserType()){
            case "chrome" ->  {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//                driver = new FirefoxDriver(firefoxOptions);
                FirefoxOptions options = new FirefoxOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                if (System.getProperty("os.name").toLowerCase().contains("linux")) {
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    options.addArguments("--disable-notifications");
                }

                driver = new FirefoxDriver(options);
            }

        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void cleanupDrive()
    {
        webdriver.get().quit();
        webdriver.remove();
    }

    private static String getBrowserType(){
        String browserType = null;
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/config.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();
            System.out.println(browserType);
        }
        catch (IOException ie){
            System.out.println(ie.getMessage());
        }
        return browserType;
    }


}
