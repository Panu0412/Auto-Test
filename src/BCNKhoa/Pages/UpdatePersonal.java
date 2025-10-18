package BCNKhoa.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;                 // ✅ dùng TimeoutException của Selenium
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdatePersonal {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public UpdatePersonal(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait   = wait;
    }

    // ===== Giữ nguyên các hàm gốc =====
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

    public void clearSDT() {
        WebElement SDT = wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SDT));
        SDT.click();
        SDT.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        SDT.sendKeys(Keys.DELETE);
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SAVE_BUTTON)).click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    public void enterSDT(String SDT) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SDT));
        input.click();
        input.clear();
        input.sendKeys(SDT);
        wait.until(ExpectedConditions.elementToBeClickable(UpdatePersonalElement.SAVE_BUTTON)).click();
        try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
    }

   
}
