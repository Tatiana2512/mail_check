package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MailInbox {
    private WebDriver driver;

    public MailInbox (WebDriver driver){
        this.driver=driver;
    }

    //list of messages
    public void inbox(){
        driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div"));
    };
}
