package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MailInbox {
    private WebDriver driver;

    public MailInbox (WebDriver driver){
        this.driver=driver;
    }

    //list of messages
    By letter = By.xpath("//a[contains(@class,'letter-list-item')]");
    public List<WebElement> inbox(){
        List<WebElement> list = driver.findElements(letter);
    return list;
    }
}
