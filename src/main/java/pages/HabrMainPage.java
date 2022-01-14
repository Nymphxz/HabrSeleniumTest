package pages;

import actions.WebChecks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HabrMainPage {
    public HabrMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private WebChecks checks = new WebChecks();

    @FindBy(xpath="//li/a[contains(text(),'Песочница')]")
    private WebElement sandBoxMenu;

    public void clickSandBoxMenu() {
        sandBoxMenu.click();
    }

    public void checkPage() {
        checks.checkHabrMainPage(driver, sandBoxMenu);
    }
}
