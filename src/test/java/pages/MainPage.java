package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class MainPage extends AbstractPage {
    private static final String URL = "https://otus.ru/";
    private By buttonLogin = By.xpath("//*[@class='header2__auth js-open-modal']");
    private Logger logger = LogManager.getLogger(MainPage.class);



    public MainPage(WebDriver driver) {
        super(driver);
    }




    public MainPage open() {
        driver.get(URL);
        logger.info("Перешли на https://otus.ru/");
        return this;
    }



    public LoginPage clickLoginButton() {
        driver.findElement(buttonLogin).click();
        logger.info("Кликнули по кнопке Вход и регистрация");
        return new LoginPage(driver);
    }

    public MainPage switchToNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.manage().deleteAllCookies();
        driver.close();
        driver.switchTo().window(tabs.get(1));
        logger.info("Переключились на новое онко, перед этим закрыв старую вкладку и удалив куки");
        return this;
    }

}
