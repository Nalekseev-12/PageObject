package cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.BaseHooks;

public class HomeWork extends BaseHooks {
    @Test
    public void HomeWorkPageObjects () {
       MainPage mainPage = new MainPage(driver);
       String email = "test";
       String password = "test";
       String name = "Nikita";
       String surname = "Alekseev";
       String firstContact = "12345678";
       String secondContact = "12345678";



      mainPage.open().clickLoginButton()
               .login(email, password)
               .clickButtonBiography()
               .writeData(name, surname, firstContact, secondContact);
      mainPage.switchToNewTab().open().clickLoginButton()
              .login(email, password)
              .clickButtonBiography();

      BiographyPage biographyPage = new BiographyPage(driver);

      String getName = biographyPage.getName();
      Assert.assertEquals(getName, name);

      String getSurname = biographyPage.getSurname();
      Assert.assertEquals(getSurname,surname);

      String getFirstContact = biographyPage.getFirstContact();
      Assert.assertEquals(getFirstContact, firstContact);

      String getSecondContact = biographyPage.getSecondContact();
      Assert.assertEquals(getSecondContact, secondContact);
    }
}
