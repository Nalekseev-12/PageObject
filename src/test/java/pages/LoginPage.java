package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {

    private By inputLogin = By.xpath("//*[@class='new-log-reg__body']/form/div[@class='new-input-line new-input-line_slim new-input-line_relative']/input");
    private By inputPassword = By.xpath("//*[@type='password']");
    private By buttonSubmit = By.xpath("//*[@class='new-button new-button_full new-button_blue new-button_md']");
    private Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public PersonalAccountPage login(String email, String password) {
        driver.findElement(inputLogin).sendKeys(email);
        logger.info("Ввели email");
        driver.findElement(inputPassword).sendKeys(password);
        logger.info("Ввели пароль");
        driver.findElement(buttonSubmit).click();
        logger.info("Кликнули по кнопке Войти");

        return new PersonalAccountPage(driver);
    }


}
