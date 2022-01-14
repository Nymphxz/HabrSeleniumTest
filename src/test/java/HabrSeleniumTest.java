import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleMainPage;
import pages.GoogleSearchResultPage;
import pages.HabrMainPage;
import pages.HabrSandBoxPage;

import java.util.concurrent.TimeUnit;

public class HabrSeleniumTest {
    private static WebDriver driver;
    private static GoogleMainPage googleMainPage;
    private static GoogleSearchResultPage googleSearchResultPage;
    private static HabrMainPage habrMainPage;
    private static HabrSandBoxPage habrSandBoxPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        googleMainPage = new GoogleMainPage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        habrMainPage = new HabrMainPage(driver);
        habrSandBoxPage = new HabrSandBoxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void HabrSeleniumTest() {
        driver.get("https://google.com/");
        googleMainPage.checkMainPage();
        googleMainPage.searchGoogle("habrahabr");
        googleMainPage.clickBtnGoogleSearch();

        googleSearchResultPage.checkPage();
        googleSearchResultPage.clickHabr();

        habrMainPage.checkPage();
        habrMainPage.clickSandBoxMenu();

        habrSandBoxPage.checkPage();
        habrSandBoxPage.clickSandBoxPage(2);

        Assert.assertEquals("Проверяю URL", "https://habr.com/ru/sandbox/page2/", driver.getCurrentUrl());

    }

    @AfterClass
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
}
