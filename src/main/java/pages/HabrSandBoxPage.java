package pages;

import actions.WebChecks;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HabrSandBoxPage {
    public HabrSandBoxPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    private WebDriver driver;
    private WebChecks checks = new WebChecks();

    @FindBy(className="tm-pagination__pages")
    private WebElement pagination;

    public void clickSandBoxPage(int pageNumber) {
        try {
            pagination.findElement(By.xpath("//a[contains(text(), '" + pageNumber + "')]")).click();
        } catch(StaleElementReferenceException e) {
            pagination.findElement(By.xpath("//a[contains(text(), '" + pageNumber + "')]")).click();
            }
    }

    public void checkPage() {
        checks.checkSandBoxPage(pagination);
    }
}
