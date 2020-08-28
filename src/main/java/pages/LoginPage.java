package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.id("user_email");
    By passwordField = By.id("user_password");
    By loginButton = By.name("commit");
    By forgotPassword = By.cssSelector("[href*='password/new']");

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getPasswordField() {
        return driver.findElement(passwordField);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public ForgotPasswordPage forgotPassword() {
        driver.findElement(forgotPassword).click();
        return new ForgotPasswordPage(driver);
    }

}
