package BCNKhoa.Pages;


import org.openqa.selenium.By;

public class LoginPageElement {
    // Cảnh báo SSL của Chrome
    public static final By ADVANCED_BUTTON = By.id("details-button"); 
    public static final By PROCEED_LINK    = By.id("proceed-link");   

    // Nút đăng nhập trên portal
    public static final By MAIN_LOGIN_BUTTON = By.id("submitlogin");

    // Microsoft login
    public static final By USERNAME_INPUT = By.id("i0116");
    // Nút Next / Sign in đầu tiên (nếu cần có thể giữ Xpath cũ)
    public static final By NEXT_BUTTON    = By.id("idSIButton9");

    public static final By PASSWORD_INPUT = By.id("i0118");
    // Nút submit mật khẩu
    public static final By SIGNIN_BUTTON  = By.id("idSIButton9");

    // Checkbox “ghi nhớ tài khoản” (giữ Xpath gốc nếu không có id ổn định)
    public static final By REMEMBER_CHECKBOX = By.id("KmsiCheckboxField");

    // “Không lưu thiết bị”
    public static final By DONT_SAVE_DEVICE = By.id("idBtn_Back");
    
    public static final By AVATAR_BUTTON = 
    	    By.xpath("/html/body/div[2]/main/div/nav/div/ul/li[3]/a/div/img");
    public static final By LOGOUT_BUTTON = By.xpath("/html/body/div[2]/main/div/nav/div/ul/li[3]/div/ul[2]/li/a");
    
}

