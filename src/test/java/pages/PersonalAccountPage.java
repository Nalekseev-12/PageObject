package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage extends AbstractPage{

    private WebElement myName = driver.findElement(By.xpath("//*[@class='header2-menu__item-wrapper header2-menu__item-wrapper__username']"));
    private WebElement buttonBiography = driver.findElement(By.xpath("//*[@href='/lk/biography/personal/']"));
    Actions actions = new Actions(driver);
    private Logger logger = LogManager.getLogger(PersonalAccountPage.class);

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    public BiographyPage clickButtonBiography() {
        actions.moveToElement(myName).build().perform();
        logger.info("Навели мышкой на свое имя");
        wait.until(driver -> buttonBiography.isDisplayed());
        logger.info("Дождались пока элемент Мой профиль будет виден");
        buttonBiography.click();
        logger.info("ВКликнули по кнопке Мой профиль");

        return new BiographyPage(driver);
    }
}
