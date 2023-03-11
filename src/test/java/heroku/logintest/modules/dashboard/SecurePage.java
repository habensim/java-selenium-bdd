package heroku.logintest.modules.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SecurePage {
    private final WebDriver driver;
    @FindBy(id="flash")
    private WebElement noticeMessage;

    public SecurePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getNoticeMessage(){
        return noticeMessage;
    }
}
