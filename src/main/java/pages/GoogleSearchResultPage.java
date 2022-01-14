package pages;

import actions.WebChecks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchResultPage {

    public GoogleSearchResultPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private WebChecks checks = new WebChecks();

    @FindBy(xpath="//a[@href='https://habr.com/']")
    private WebElement habr;

    public void clickHabr() {
        habr.click();
    }

    public void checkPage() {
        checks.checkSearchResultPage(habr);
    }
}
