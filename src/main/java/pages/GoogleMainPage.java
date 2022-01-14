package pages;

import actions.WebChecks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private WebChecks checks = new WebChecks();

    @FindBy(xpath="//input[@title='Поиск']")
    private WebElement txtSearch;

    @FindBy(xpath="//input[@aria-label='Поиск в Google']")
    private WebElement btnSearch;

    public void searchGoogle(String text) {
        txtSearch.sendKeys(text);
    }

    public void clickBtnGoogleSearch() {
        btnSearch.click();
    }

    public void checkMainPage() {
        checks.checkGoogleMainpage(driver, btnSearch);
    }
}
