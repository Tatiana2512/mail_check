import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {

        /* File file = new File("C:\\config.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file)); */

        System.setProperty("webdriver.chrome.driver","C:\\tools\\webdrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.ru/");

        MailLogin mailLogin = new MailLogin(driver);

        MailInbox mailInbox = new MailInbox(driver);

        mailLogin.emailDomain("@inbox.ru");
        mailLogin.enterUserName("example-test");
        mailLogin.clickPass();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        mailLogin.enterPassword("lu&rrrTLJA13");
        mailLogin. clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        System.out.println("You have " +mailInbox.inbox().size()+" messages inside Inbox folder");
        driver.manage().deleteAllCookies();
        driver.close();

    }
}
