package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MailLogin {

        private WebDriver driver;

        public MailLogin (WebDriver driver){
            this.driver=driver;
        }

        //choose domain
        public void emailDomain(String domain_option) {
            By domain = By.xpath("/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/select");
            WebElement element=driver.findElement(domain);
            Select se=new Select(element);
            se.selectByValue(domain_option);
        }

        //enter login
        By login = By.xpath("/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input");
        public void enterUserName(String username){
            driver.findElement(login).sendKeys(username);
        }
        //enter pass
        By pass = By.xpath("/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/input");
        public void enterPassword(String userpass){
            driver.findElement(pass).sendKeys(userpass);
        }

        public void clickLogin() {
            driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/button[2]")).click();
        }

        public void clickPass(){
            driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/button[1]")).click();
        }

        public void open(){
            driver.get("https://mail.ru/");
        }
        boolean atPage(){
            if(driver.getTitle().equals("Mail.ru: почта, поиск в интернете, новости, игры")) {
                return true;
            } else{ return false;
            }
        }
    }


