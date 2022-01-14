package actions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebChecks {

    public void checkGoogleMainpage(WebDriver driver, WebElement btnSearch) {
        System.out.println("Проверяю, что находимся на странице google.com");
        Assert.assertEquals("URL не совпадает", "https://www.google.com/", driver.getCurrentUrl());
        Assert.assertTrue(btnSearch.isEnabled());
    }

    public void checkSearchResultPage(WebElement habr) {
        System.out.println("Проверяю, что находимся на странице результата поиска");
        Assert.assertTrue(habr.isDisplayed() && habr.isEnabled());
    }

    public void checkHabrMainPage(WebDriver driver, WebElement sandBoxMenu) {
        System.out.println("Проверяю, что находимся на странице habr.com");
        Assert.assertEquals("URL не совпадает", "https://habr.com/ru/all/", driver.getCurrentUrl());
        Assert.assertTrue(sandBoxMenu.isDisplayed() && sandBoxMenu.isEnabled());
    }

    public void checkSandBoxPage(WebElement pagination) {
        System.out.println("Проверяю страницу песочницы");
        Assert.assertTrue(pagination.isDisplayed() && pagination.isEnabled());
    }
}
