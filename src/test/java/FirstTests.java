import Models.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Models.Helper;

import java.time.Duration;

public class FirstTests {

    @BeforeMethod
    public void beforeMethod() {
        Helper.driver.get("https://sutarta.lt/redaguoti/baldai-interjeras/baldai-namams/miegamojo-baldai/dvigules-lovos");
//        Helper.driver.findElement(By.id("contacts_name")).clear();
//        Helper.driver.findElement(By.id("contacts_email")).clear();
//        Helper.driver.findElement(By.id("contacts_phone")).clear();
//        Helper.driver.findElement(By.id("width")).clear();
//        Helper.driver.findElement(By.id("length")).clear();
//        Helper.driver.findElement(By.id("fk_place_cities_id[]")).clear();
//        Helper.driver.findElement(By.id("title_lt")).clear();
//        Helper.driver.findElement(By.id("comments_lt")).clear();
//        Helper.driver.findElement(By.id("sell_price_eur")).clear();
//        Helper.driver.findElement(By.id("video_url")).clear();
    }

    @AfterMethod
    public void afterMethod() {
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeClass
    public void beforeClass() {
        Helper.driver = new ChromeDriver();
        Helper.driver.manage().window().maximize();
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Helper.acceptCookies();
    }

    @AfterClass
    public void afterClass() {
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Helper.driver.quit();
    }

    @Test
    public void addNewAdTest() { // Nr 1 positive Test
        Helper.driver.findElement(By.id("contacts_name")).sendKeys("Nammeeee");
        Helper.driver.findElement(By.id("contacts_email")).sendKeys("asdefgmhejj@gmail.com");
        Helper.driver.findElement(By.id("contacts_phone")).sendKeys("+37061111111");
        Helper.driver.findElement(By.id("condition_id")).click();                                             // condition
        Helper.driver.findElement(By.xpath("//*[@id=\"condition_id\"]/option[2]")).click();
        Helper.driver.findElement(By.id("color_id")).click();                                                // color
        Helper.driver.findElement(By.xpath("//*[@id=\"color_id\"]/option[3]")).click();
        Helper.driver.findElement(By.id("width")).sendKeys("1000");
        Helper.driver.findElement(By.id("length")).sendKeys("1000");
        Helper.driver.findElement(By.id("fk_place_cities_id[]")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"fk_place_cities_id[]\"]/optgroup[1]/option[2]")).click();
        Helper.driver.findElement(By.id("title_lt")).sendKeys("titeltitle");
        Helper.driver.findElement(By.id("comments_lt")).sendKeys("descriptiondescription");
        Helper.driver.findElement(By.id("sell_price_eur")).sendKeys("99999");
        String path = System.getProperty("user.dir") + "/TestPictures/logo.png"; // upload pic
        WebElement upload_file = Helper.driver.findElement(By.id("filedata"));
        upload_file.sendKeys(path);
        Helper.driver.findElement(By.id("video_url")).sendKeys("https://www.youtube.com/watch?v=AfKZclMWS1U&pp=ygUOZ3plZ296IHlvdXR1YmU%3D&ab_channel=trouchelle");
        Helper.driver.findElement(By.xpath("//*[@id=\"main_form\"]/div[3]/div/input")).click();
        Helper.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("superpassword3456");
        Helper.driver.findElement(By.className("submit-button")).click();
    }
    @Test
    public void secondTest() {
        Register r = new Register("nicename", "uvdeve@gmail.com", "+37060000000", "super nice",
                "nice color", "3456", "1234", "Vilnius", "short title", "long description",
                "900000", "superpassword");
        r.fill();
    }
}

