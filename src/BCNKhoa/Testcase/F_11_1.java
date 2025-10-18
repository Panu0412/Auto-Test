package BCNKhoa.Testcase;

import BCNKhoa.Pages.BaseTest;
import BCNKhoa.Pages.LoginPage;
import org.testng.annotations.Test;

public class F_11_1 extends BaseTest {

    @Test
    public void loginTest01_02() {
        // Lấy credential an toàn (ưu tiên biến môi trường / -D system property)
        String user = System.getenv().getOrDefault("VLU_USER",
                       System.getProperty("VLU_USER", "nhut.2274802010621@vanlanguni.vn"));
        String pass = System.getenv().getOrDefault("VLU_PASS",
                       System.getProperty("VLU_PASS", "04122004nhut"));

        LoginPage page = new LoginPage(driver, wait);

        page.handleSslWarningIfPresent();
        page.clickMainLogin();

        page.enterUsername(user);
        page.clickNextAfterUsername();

        page.enterPassword(pass);
        page.clickSignIn();

        page.uncheckRememberIfVisible();
        page.clickDontSaveDeviceIfVisible();

        page.clickAvatar();
        page.clickLogout();
        
    }
    
    
    @Test
    public void logintest03() {
        // Lấy credential an toàn (ưu tiên biến môi trường / -D system property)

        LoginPage page = new LoginPage(driver, wait);

        page.clickMainLogin();

        
    }
    
    
}
