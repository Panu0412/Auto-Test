package BCNKhoa.Testcase;

import BCNKhoa.Pages.BaseTest;
import BCNKhoa.Pages.LoginPage;
import BCNKhoa.Pages.UpdatePersonal;

import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class F_11_2 extends BaseTest {

    @Test
    public void TC04() {
        // Lấy credential an toàn (ưu tiên biến môi trường / -D system property)
        String user = System.getenv().getOrDefault("VLU_USER",
                       System.getProperty("VLU_USER", "nhut.2274802010621@vanlanguni.vn"));
        String pass = System.getenv().getOrDefault("VLU_PASS",
                       System.getProperty("VLU_PASS", "04122004nhut"));

        LoginPage page = new LoginPage(driver, wait);
        UpdatePersonal personalPage = new UpdatePersonal(driver, wait);

        
        page.handleSslWarningIfPresent();
        page.clickMainLogin();

        page.enterUsername(user);
        page.clickNextAfterUsername();

        page.enterPassword(pass);
        page.clickSignIn();

        page.uncheckRememberIfVisible();
        page.clickDontSaveDeviceIfVisible();

//        page.clickAvatar();
//        personalPage.openPersonalInfo();    
    }

//    @Test
//    public void TC05() {
//        LoginPage page = new LoginPage(driver, wait);
//        UpdatePersonal personalPage = new UpdatePersonal(driver, wait);
//
//        personalPage.closePersonalInfoButton(); 
//
//    
//    }
//    @Test
//    public void TC06() {
//        UpdatePersonal personalPage = new UpdatePersonal(driver, wait);
//        LoginPage page = new LoginPage(driver, wait);
//        page.clickAvatar();
//        personalPage.openPersonalInfo(); 
//        personalPage.closePersonalInfo();    
//    }
//   
//    @Test
//    public void TC07() {
//    	UpdatePersonal personalPage = new UpdatePersonal(driver, wait);
//    	LoginPage page = new LoginPage(driver, wait);
//        UpdatePersonal up = new UpdatePersonal(driver, wait);
//    	page.clickAvatar();
//    	up.openPersonalInfo();
//    	up.clearMaGVAndSave();   // mở form → xóa mã GV → bấm Lưu    
//    	String actualMessage = up.getErrorMessage();  // ✅ gọi đúng biến
//        Assert.assertEquals(actualMessage, "Vui lòng nhập mã tài khoản.");
//    }

//    @Test
//    public void TC08() {
//        UpdatePersonal up = new UpdatePersonal(driver, wait);
//
//    	LoginPage page = new LoginPage(driver, wait);
//    	page.clickAvatar();
//    	up.openPersonalInfo();
//
//        // Nhập mã giảng viên
//        up.enterMaGV("2274802010623");
//
//    }
//    
//    @Test
//    public void TC09() {
//        UpdatePersonal up = new UpdatePersonal(driver, wait);
//    	LoginPage page = new LoginPage(driver, wait);
//    	page.clickAvatar();
//    	up.openPersonalInfo();
//
//        // Nhập mã giảng viên
//        up.enterMaGV("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\r\n"
//        		+ "");
//    }
//   
//    @Test
//    public void TC10() {
//        UpdatePersonal up = new UpdatePersonal(driver, wait);
//    	LoginPage page = new LoginPage(driver, wait);
//    	page.clickAvatar();
//    	up.openPersonalInfo();
//
//        // Nhập mã giảng viên
//        up.enterMaGV("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\r\n"
//        		+ "");
//    }
//    
//    @Test
//    public void TC11() {
//        UpdatePersonal up = new UpdatePersonal(driver, wait);
//    	LoginPage page = new LoginPage(driver, wait);
//    	page.clickAvatar();
//    	up.openPersonalInfo();
//
//        // Nhập mã giảng viên
//        up.enterMaGV("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111\r\n"
//        		+ "");
//    }
    
//    @Test
//    public void TC12() {
//        UpdatePersonal up = new UpdatePersonal(driver, wait);
//    	LoginPage page = new LoginPage(driver, wait);
//    	page.clickAvatar();
//    	up.openPersonalInfo();
//
//        // Nhập mã giảng viên
//        up.enterMaGV("PhanMinhNhut" + "");
//    }
    
//    @Test
//    public void TC13() {
//        UpdatePersonal up = new UpdatePersonal(driver, wait);
//    	LoginPage page = new LoginPage(driver, wait);
//    	page.clickAvatar();
//    	up.openPersonalInfo();
//
//        // Nhập mã giảng viên
//        up.enterMaGV("Phan Minh Nhựt" + "");
//    }
    
//    @Test
//    public void TC14() {
//        UpdatePersonal up = new UpdatePersonal(driver, wait);
//    	LoginPage page = new LoginPage(driver, wait);
//    	page.clickAvatar();
//    	up.openPersonalInfo();
//
//        // Nhập mã giảng viên
//        up.enterMaGV("#$%^" + "");
//    }
    
//  @Test
//  public void TC15() {
//  	UpdatePersonal personalPage = new UpdatePersonal(driver, wait);
//  	LoginPage page = new LoginPage(driver, wait);
//      UpdatePersonal up = new UpdatePersonal(driver, wait);
//  	page.clickAvatar();
//  	up.openPersonalInfo();
//  	up.clearSDT();   // mở form → xóa SDT → bấm Lưu    
//  }
    
  @Test 
  public void TC16() {
      UpdatePersonal up = new UpdatePersonal(driver, wait);
  	LoginPage page = new LoginPage(driver, wait);
  	page.clickAvatar();
  	up.openPersonalInfo();

      // Nhập mã giảng viên
      up.enterSDT("0946778542" + "");
  }
    
   
}
    


   

