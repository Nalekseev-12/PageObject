package utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class BaseHooks {
    protected static WebDriver driver;
    private static Logger logger = LogManager.getLogger(BaseHooks.class);

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup(); //Поднимаем драйвер
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        logger.info("Драйвер поднят");

    }

   @AfterClass
   public static void teardown() {
     if (driver != null) {
       driver.quit();
         logger.info("Закрыли драйвер, после теста");
     }
   }

    @After
    public void cleanUp() {
      driver.manage().deleteAllCookies();
        logger.info("Удалили куки, после теста");
    }

}
