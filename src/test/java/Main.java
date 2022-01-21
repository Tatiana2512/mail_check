import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream input = null;
        try{
            input=new FileInputStream("src/test/resources/config.properties");
            prop.load(input);
        } catch (
                IOException ex){ex.printStackTrace();}
        finally {
            if (input != null){
                try {input.close();}
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.setProperty("webdriver.chrome.driver",prop.getProperty("driverPath"));
        WebDriver driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));

        MailLogin mailLogin = new MailLogin(driver);

        MailInbox mailInbox = new MailInbox(driver);

        mailLogin.emailDomain(prop.getProperty("domain"));
        mailLogin.enterUserName(prop.getProperty("login"));
        mailLogin.clickPass();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        mailLogin.enterPassword(prop.getProperty("password"));
        mailLogin.clickLogin();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        System.out.println("You have " +mailInbox.inbox().size()+" messages inside Inbox folder");
        driver.manage().deleteAllCookies();
        driver.close();

    }
}
