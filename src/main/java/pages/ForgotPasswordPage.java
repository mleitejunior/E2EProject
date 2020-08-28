package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
    public WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailField = By.id("user_email");
    By sendMeInstructionsButton = By.cssSelector("[type='submit']");

    public WebElement getEmailField() {
        return driver.findElement(emailField);
    }

    public WebElement getSendMeInstructionsButton() {
        return driver.findElement(sendMeInstructionsButton);
    }
}
