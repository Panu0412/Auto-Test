package BCNKhoa.Pages;

import org.openqa.selenium.By;

public class UpdatePersonalElement {
    // Nút/Link "Thông tin cá nhân" trong dropdown avatar
    public static final By PERSONAL_INFO_LINK = By.xpath("/html/body/div[2]/main/div/nav/div/ul/li[3]/div/ul[1]/li/a");
    // nut X
    public static final By MODAL_CLOSE_X = By.xpath("/html/body/div[3]/div/div/div[1]/button");
    // DONG BUTTON
    public static final By MODAL_CLOSE_BUTTON = By.xpath("/html/body/div[3]/div/div/div[3]/button[1]");
    // Luu thong tin
    public static final By SAVE_BUTTON = By.id("btnInfoSubmit");
    //Ma GV
    public static final By MA_GV = By.id("infoma");
    // thong bao loi ma giang vien
    public static final By ERROR_MESSAGE = By.id("valid-infoma");
  //SDT
    public static final By SDT = By.id("infodienthoai");
  //Avata
    public static final By AVATAR_BUTTON = 
    	    By.xpath("/html/body/div[2]/main/div/nav/div/ul/li[3]/a/div/img");
   

}