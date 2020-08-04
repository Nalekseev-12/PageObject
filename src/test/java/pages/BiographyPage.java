package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BiographyPage extends AbstractPage {

    private By inputNameLatin = By.xpath("//*[@name='fname_latin']");
    private By inputSurnameLatin = By.xpath("//*[@name='lname_latin']");
    private By firstCommunicationMethod = By.xpath("//*[@class='input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation']");
    private By secondCommunicationMethod = By.xpath("//*[@class='input input_full lk-cv-block__input input_straight-bottom-right input_straight-top-right input_no-border-right lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation']/span");
    private By communicationMethodViber = By.xpath("//*[@data-value='viber']");
    private By communicationMethodTelegram = By.xpath("//*[@class='lk-cv-block__select-options lk-cv-block__select-options_left js-custom-select-options-container']/div/button[@data-value='telegram']");
    private By firstContactValue = By.xpath("//*[@name='contact-0-value']");
    private By secondContactValue = By.xpath("//*[@name='contact-1-value']");
    private By buttonSubmit = By.xpath("//*[@class='lk-cv-action-buttons']/button[2]");
    private By buttonAdd = By.xpath("//*[@class='lk-cv-block__action lk-cv-block__action_md-no-spacing js-formset-add js-lk-cv-custom-select-add']");
    private Logger logger = LogManager.getLogger(BiographyPage.class);

    public BiographyPage(WebDriver driver) {
        super(driver);
    }

    public void writeData (String name, String surname, String firstContact, String secondContact) {
        driver.findElement(inputNameLatin).sendKeys(name);
        logger.info("Ввели имя латиницей");
        driver.findElement(inputSurnameLatin).sendKeys(surname);
        logger.info("Ввели фамилию латиницей");
        driver.findElement(firstCommunicationMethod).click();
        logger.info("Нажали на способ связи");
        WebElement cmv = driver.findElement(communicationMethodViber);
        wait.until(driver -> cmv.isDisplayed());
        cmv.click();
        logger.info("Добавили способ связи: Viber");
        driver.findElement(firstContactValue).sendKeys(firstContact);
        logger.info("Ввели номер телефона в первый способ связи");
        driver.findElement(buttonAdd).click();
        logger.info("Добавили еще один способ связи");
        driver.findElement(secondCommunicationMethod).click();
        WebElement cmt = driver.findElement(communicationMethodTelegram);
        wait.until(driver -> cmt.isDisplayed());
        cmt.click();
        logger.info("Добавили способ связи: Telegram");
        driver.findElement(secondContactValue).sendKeys(secondContact);
        logger.info("Ввели номер телефона во второй способ связи");
        driver.findElement(buttonSubmit).click();
        logger.info("Нажали на Сохранить и заполнить позже");
    }

    public String getName() {
        logger.info("Сравнили значение имени");
       return driver.findElement(inputNameLatin).getAttribute("value");
    }

    public String getSurname() {
        logger.info("Сравнили значение фамилии");
        return driver.findElement(inputSurnameLatin).getAttribute("value");
    }

    public String getFirstContact() {
        logger.info("Сравнили значение первоко контакта");
        return driver.findElement(firstContactValue).getAttribute("value");
    }

    public String getSecondContact() {
        logger.info("Сравнили значение второго контакта");
        return driver.findElement(secondContactValue).getAttribute("value");
    }
}
