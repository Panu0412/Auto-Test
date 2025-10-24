package BCNKhoa.Testcase;

import java.io.FileReader;
import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import BCNKhoa.Pages.BaseTest;
import BCNKhoa.Pages.LoginPage;
import BCNKhoa.Pages.UpdatePersonal; // để mở/đóng form
import BCNKhoa.Pages.TTCN;          // nhập liệu

public class TTCN_TC extends BaseTest {

    private WebDriverWait wait;
    private UpdatePersonal page;
    private TTCN ttcn;

    @BeforeClass
    public void classSetup() throws Exception {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        page = new UpdatePersonal(driver, wait);
        ttcn = new TTCN(driver);

        // Login 1 lần
        String user = System.getenv().getOrDefault(
                "VLU_USER", System.getProperty("VLU_USER", "nhut.2274802010621@vanlanguni.vn"));
        String pass = System.getenv().getOrDefault(
                "VLU_PASS", System.getProperty("VLU_PASS", "04122004nhut"));

        LoginPage lp = new LoginPage(driver, wait);
        lp.handleSslWarningIfPresent();
        lp.clickMainLogin();
        lp.enterUsername(user);
        lp.clickNextAfterUsername();
        lp.enterPassword(pass);
        lp.clickSignIn();
        lp.uncheckRememberIfVisible();
        lp.clickDontSaveDeviceIfVisible();
    }

    @BeforeMethod
    public void beforeEach() {
        page.openPersonalForm();
    }

    @AfterMethod
    public void afterEach() {
        page.closePersonalFormFast();
        page.waitBetweenCases(2); // nghỉ 2s cho chắc
    }

    @DataProvider(name = "DataTTCN")
    public Object[][] getEmployeeData() throws Exception {
        JSONParser jsonparser = new JSONParser();
        try (FileReader reader = new FileReader("D:\\TTCN.json")) {
            JSONObject root = (JSONObject) jsonparser.parse(reader);
            JSONArray array = (JSONArray) root.get("info");

            Object[][] data = new Object[array.size()][2];
            for (int i = 0; i < array.size(); i++) {
                JSONObject info = (JSONObject) array.get(i);
                data[i][0] = (String) info.get("maGV");
                data[i][1] = (String) info.get("SDT");
            }
            return data;
        }
    }

    // Test nhập Mã GV
    @Test(dataProvider = "DataTTCN", priority = 1)
    public void testNhapMaGV(String maGV, String sdt) throws InterruptedException {
        ttcn.NhapMAGV(maGV);
        Thread.sleep(1000);
    }

    // Test nhập SDT
    @Test(dataProvider = "DataTTCN", priority = 2, dependsOnMethods = "testNhapMaGV")
    public void testNhapSDT(String maGV, String sdt) throws InterruptedException {
        ttcn.NhapSDT(sdt);
        Thread.sleep(1000);
    }
    //Test Gtinh
    @Test(priority = 3)
    public void ChonGioiTinhNu_TC() throws InterruptedException {
        TTCN thongtin = new TTCN(driver);
        thongtin.ChonGioiTinhNu();
        Thread.sleep(2000);
    }
    
    @Test(priority = 4)
    public void ChonGioiTinhNam_TC() throws InterruptedException {
        TTCN thongtin = new TTCN(driver);
        thongtin.ChonGioiTinhNam();
        Thread.sleep(2000);
    }
    
    @Test(priority = 5)
    public void ChonNganh_TC() throws InterruptedException {
        TTCN thongtin = new TTCN(driver);
        thongtin.ChonNganh();
        Thread.sleep(2000);
    }
    
    @Test(priority = 6)
    public void FullTT_TC() throws InterruptedException {
        TTCN thongtin = new TTCN(driver);
        thongtin.FullTT("2274802010621", "0981645227");;
        Thread.sleep(2000);
    }
    @Test(priority = 7)
    public void ErrorTT_TC() throws InterruptedException {
        TTCN thongtin = new TTCN(driver);
        thongtin.ErrorTT("Nhựt", "Nhut");;
        Thread.sleep(2000);
    }
    @Test(priority = 8)
    public void LostTT_TC() throws InterruptedException {
        TTCN thongtin = new TTCN(driver);
        thongtin.LostTT(" ", " ");;
        Thread.sleep(2000);
    }
    
}
