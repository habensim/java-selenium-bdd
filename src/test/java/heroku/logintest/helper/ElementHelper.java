package heroku.logintest.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.URL;

public class ElementHelper {
    private WebDriver driver;
    public ElementHelper(WebDriver driver){
        this.driver = driver;
    }
    public static boolean isValidUrl(String url){
        try{
            new URL(url);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
