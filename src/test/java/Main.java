import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;

import java.time.Duration;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\tools\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.ru/");

        MailLogin mailLogin = new MailLogin(driver);

        MailInbox mailInbox = new MailInbox(driver);

        mailLogin.emailDomain("@inbox.ru");
        mailLogin.enterUserName("example-test");
        mailLogin.clickPass();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        mailLogin.enterPassword("A)trO3uTIuy2");
        mailLogin.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        int num = driver.findElements(By.xpath("/html/body/div[5]/div/div[1]/div[1]/div/div[2]/span/div[2]/div/div/div/div/div[1]/div/div/div/div[1]/div/div")).size();

        System.out.println("You have " +num+" messages inside Inbox folder");
        driver.close();

    }
}
