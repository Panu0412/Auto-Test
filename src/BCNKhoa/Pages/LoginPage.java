package BCNKhoa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
    }

    public void handleSslWarningIfPresent() {
        try {
            WebElement adv = wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.ADVANCED_BUTTON));
            adv.click();
            WebElement proceed = wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.PROCEED_LINK));
            proceed.click();
        } catch (TimeoutException ignore) {
            // Không có trang cảnh báo → bỏ qua
        }
    }

    public void clickMainLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.MAIN_LOGIN_BUTTON)).click();
    }

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.USERNAME_INPUT)).sendKeys(username);
    }

    public void clickNextAfterUsername() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.NEXT_BUTTON)).click();
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.PASSWORD_INPUT)).sendKeys(password);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.SIGNIN_BUTTON)).click();
    }

    public void uncheckRememberIfVisible() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.REMEMBER_CHECKBOX)).click();
        } catch (TimeoutException ignore) {}
    }

    public void clickDontSaveDeviceIfVisible() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.DONT_SAVE_DEVICE)).click();
        } catch (TimeoutException ignore) {}
    }
    
    public void clickAvatar() {
        wait.until(
            ExpectedConditions.elementToBeClickable(
                LoginPageElement.AVATAR_BUTTON
            )
        ).click();
    }

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(LoginPageElement.LOGOUT_BUTTON)).click();
        try {
            Thread.sleep(2000); // chờ 2 giây sau khi logout
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

