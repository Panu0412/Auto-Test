package BCNKhoa.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.JavascriptExecutor;

public class UpdatePersonal {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public UpdatePersonal(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
    }

    public void openPersonalInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.PERSONAL_INFO_LINK)).click();
    }

    public void closePersonalInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.MODAL_CLOSE_X)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(UpdatePersonalElement.MODAL_CLOSE_X));
    }

    public void closePersonalInfoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.MODAL_CLOSE_BUTTON)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(UpdatePersonalElement.MODAL_CLOSE_BUTTON));
    }

    public void clearMaGVAndSave() {
        WebElement maGv = wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.MA_GV));
        maGv.click();
        maGv.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        maGv.sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SAVE_BUTTON)).click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public String getErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(UpdatePersonalElement.ERROR_MESSAGE));
        return error.getText().trim();
    }

    public void enterMaGV(String maGV) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.MA_GV));
        input.click(); input.clear(); input.sendKeys(maGV);
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SAVE_BUTTON)).click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    //--------------------------------------------SDT----------------------------------------------------------------

    // Mở form thông tin cá nhân (avatar -> menu -> form)
    public void openPersonalForm() {
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.AVATAR_BUTTON)).click();
        openPersonalInfo();
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SDT));
    }

    // Đóng form thông tin cá nhân (ổn định, có thể chờ hơi lâu nếu UI chậm)
    public void closePersonalForm() {
        try {
            closePersonalInfoButton();
        } catch (Exception e1) {
            try {
                closePersonalInfo();
            } catch (Exception e2) {
                try { driver.switchTo().activeElement().sendKeys(Keys.ESCAPE); } catch (Exception ignore) {}
            }
        }
    }

    // Nhập SDT và bấm Lưu (phiên bản chuẩn, có chờ ngắn)
    public void enterPhoneAndSave(String phone) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SDT));
        input.click();
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Keys.DELETE);
        input.sendKeys(phone);

        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SAVE_BUTTON)).click();
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Lấy thông báo lỗi SDT (nếu có)
    public String getPhoneError() {
        try {
            WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("valid-infodienthoai")));
            return error.getText().trim();
        } catch (TimeoutException te) {
            return "";
        }
    }

    // Đợi giữa các test case
    public void waitBetweenCases(int seconds) {
        try { Thread.sleep(seconds * 1000L); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // ===== Phiên bản FAST (tránh chờ lâu, phục vụ yêu cầu chỉ nghỉ 6s) =====

    /** Nhập SDT + Lưu KHÔNG sleep cố định; chỉ “nhá” đợi có điều kiện tối đa ~1s */
    public void enterPhoneAndSaveFast(String phone) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SDT));
        input.click();
        input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        input.sendKeys(Keys.DELETE);
        input.sendKeys(phone);

        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SAVE_BUTTON)).click();

        try {
            new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOfElementLocated(By.id("valid-infodienthoai")),
                    ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SAVE_BUTTON)
                ));
        } catch (TimeoutException ignore) {}
    }

    /** Đóng form với timeout NGẮN để không đội thời gian lên quá 6s tổng */
    public void closePersonalFormFast() {
        try {
            WebElement btnClose = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.MODAL_CLOSE_BUTTON));
            btnClose.click();
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.invisibilityOfElementLocated(UpdatePersonalElement.SAVE_BUTTON));
            return;
        } catch (Exception ignore) { }

        try {
            WebElement x = new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.MODAL_CLOSE_X));
            x.click();
            new WebDriverWait(driver, Duration.ofSeconds(2))
                    .until(ExpectedConditions.invisibilityOfElementLocated(UpdatePersonalElement.SAVE_BUTTON));
            return;
        } catch (Exception ignore) { }

        try { driver.switchTo().activeElement().sendKeys(Keys.ESCAPE); } catch (Exception ignore) {}
    }

    /** Lấy lỗi SDT với timeout 1s */
    public String getPhoneErrorFast() {
        try {
            WebElement error = new WebDriverWait(driver, Duration.ofSeconds(1))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("valid-infodienthoai")));
            return error.getText().trim();
        } catch (TimeoutException te) {
            return "";
        }
    }
    
 
   
    
 
}
