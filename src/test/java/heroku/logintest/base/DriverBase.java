package heroku.logintest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverBase extends BaseTest {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    public static WebDriver getDriver(){
        if(driver.get() == null){
            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());

        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
