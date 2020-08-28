package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    By signIn = By.cssSelector("a[href*='sign_in']");
    By contentTitle = By.cssSelector(".text-center > h2");
    By navBar = By.cssSelector(".navbar-right>li>a");

    public LoginPage getLogin() {
        driver.findElement(signIn).click();
        LoginPage lp = new LoginPage(driver);
        return lp;
    }

    public WebElement getContentTitle() {
        return driver.findElement(contentTitle);
    }

    public WebElement getNavBar() {
        return driver.findElement(navBar);
    }
}
