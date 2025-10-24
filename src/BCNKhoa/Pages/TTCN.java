package BCNKhoa.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class TTCN {
    // Avata
    @FindBy(xpath = "/html/body/div[2]/main/div/nav/div/ul/li[3]/a/div/img")
    private WebElement Avata;
    // TCCN
    @FindBy(xpath = "/html/body/div[2]/main/div/nav/div/ul/li[3]/div/ul[1]/li/a")
    private WebElement TTCN;
    // Mã GV
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div/div[1]/div/input")
    private WebElement MaGV;
    // SDT
    @FindBy(xpath = "/html/body/div[3]/div/div/div[2]/div/div[4]/div/input")
    private WebElement SDT;
    // Nút Lưu
    @FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button[2]")
    private WebElement Luu;
    // Gtioitinh
    @FindBy(id = "infogioitinh")
    private WebElement Gender;
    // Nganh
    @FindBy(id = "infonganh")
    private WebElement Nganh;

    public TTCN(WebDriver driver) {
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);
    }
    
    
    // MỞ form (Avatar → TTCN)
    public void MoForm() {
        Avata.click();
        TTCN.click();
    }

    //Ma GV
    public void NhapMAGV(String inMaGV) {
        MaGV.clear();
        MaGV.sendKeys(inMaGV);
        Luu.click(); // lưu xong modal sẽ đóng
    }
    
    //SDT
    public void NhapSDT(String inSDT) {
        SDT.clear();
        SDT.sendKeys(inSDT);
        Luu.click(); // lưu xong modal sẽ đóng
    }
    
    //Gtinh
    public void ChonGioiTinhNu() {
        Select select = new Select(Gender);
        select.selectByValue("Nữ");   
        Luu.click(); 
    }
    public void ChonGioiTinhNam() {
        Select select = new Select(Gender);
        select.selectByValue("Nam");   
        Luu.click(); 
    }
    
    //Nganh
    public void ChonNganh() {
        Select select = new Select(Nganh);
        select.selectByValue("1");   
        Luu.click(); 
    }
    
    public void FullTT(String nhapten,String nhapsdt) {
        MaGV.clear();
        SDT.clear();
        MaGV.sendKeys(nhapten);
        SDT.sendKeys(nhapsdt);
        
        Select genderSelect = new Select(Gender);
        genderSelect.selectByValue("Nữ");  

        Select nganhSelect = new Select(Nganh);
        nganhSelect.selectByValue("5");
        Luu.click(); 
    }
    
    public void ErrorTT(String nhapsaiten,String nhapsaisdt) {
        MaGV.clear();
        SDT.clear();
        MaGV.sendKeys(nhapsaiten);
        SDT.sendKeys(nhapsaisdt);
        
        Select genderSelect = new Select(Gender);
        genderSelect.selectByValue("Nam");  

        Select nganhSelect = new Select(Nganh);
        nganhSelect.selectByValue("25");
        Luu.click(); 
        }
    public void LostTT(String nhapthieuten,String nhapthieusdt) {
        MaGV.clear();
        SDT.clear();
        MaGV.sendKeys(nhapthieuten);
        SDT.sendKeys(nhapthieusdt);
        
        Select genderSelect = new Select(Gender);
        genderSelect.selectByValue("Nam");  

        Select nganhSelect = new Select(Nganh);
        nganhSelect.selectByValue("25");
        Luu.click(); 
        }

}
