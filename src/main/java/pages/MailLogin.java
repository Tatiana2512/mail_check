package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MailLogin {

        private WebDriver driver;

        public MailLogin (WebDriver driver){
            this.driver=driver;
        }

        //choose domain
        public void emailDomain(String domain_option) {
            By domain = By.xpath("//select[@name='domain']");
            WebElement element=driver.findElement(domain);
            Select se=new Select(element);
            se.selectByValue(domain_option);
        }

        //enter login
        By login = By.xpath("//input[contains(@class,'email-input')]");
        public void enterUserName(String username){
            driver.findElement(login).sendKeys(username);
        }
        //enter pass
        By pass = By.xpath("//input[contains(@class,'password-input')]");
        public void enterPassword(String userpass){
            driver.findElement(pass).sendKeys(userpass);
        }

        public void clickLogin() {
            driver.findElement(By.xpath("//button[@data-testid='login-to-mail']")).click();
        }

        public void clickPass(){
            driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        }


        boolean atPage(){
            if(driver.getTitle().equals("Mail.ru: почта, поиск в интернете, новости, игры")) {
                return true;
            } else{ return false;
            }
        }
    }


