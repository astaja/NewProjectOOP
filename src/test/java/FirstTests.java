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
//    public static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        Helper.driver.get("https://sutarta.lt/redaguoti/baldai-interjeras/baldai-namams/miegamojo-baldai/dvigules-lovos");
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
        acceptCookies();
    }

    @AfterClass
    public void afterClass() {
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Helper.driver.quit();
    }

    public void acceptCookies() {
        Helper.driver.get("https://sutarta.lt/");
        Helper.driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

//    @Test
//    public void addNewAdTest() { // Nr 1 positive Test
//        driver.findElement(By.id("contacts_name")).sendKeys("Nammeeee");
//        driver.findElement(By.id("contacts_email")).sendKeys("asdefgmhejj@gmail.com");
//        driver.findElement(By.id("contacts_phone")).sendKeys("+37061111111");
//        driver.findElement(By.id("condition_id")).click();                                             // condition
//        driver.findElement(By.xpath("//*[@id=\"condition_id\"]/option[2]")).click();
//        driver.findElement(By.id("color_id")).click();                                                // color
//        driver.findElement(By.xpath("//*[@id=\"color_id\"]/option[3]")).click();
//        driver.findElement(By.id("width")).sendKeys("1000");
//        driver.findElement(By.id("length")).sendKeys("1000");
//        driver.findElement(By.id("fk_place_cities_id[]")).click();
//        driver.findElement(By.xpath("//*[@id=\"fk_place_cities_id[]\"]/optgroup[1]/option[2]")).click();
//        driver.findElement(By.id("title_lt")).sendKeys("titeltitle");
//        driver.findElement(By.id("comments_lt")).sendKeys("descriptiondescription");
//        driver.findElement(By.id("sell_price_eur")).sendKeys("99999");
//        String path = System.getProperty("user.dir") + "/TestPictures/logo.png"; // upload pic
//        WebElement upload_file = driver.findElement(By.id("filedata"));
//        upload_file.sendKeys(path);
//        driver.findElement(By.id("video_url")).sendKeys("https://www.youtube.com/watch?v=AfKZclMWS1U&pp=ygUOZ3plZ296IHlvdXR1YmU%3D&ab_channel=trouchelle");
//        driver.findElement(By.xpath("//*[@id=\"main_form\"]/div[3]/div/input")).click();
//        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("superpassword3456");
//        driver.findElement(By.className("submit-button")).click();
//    }
    @Test
    public void secondTest() {
        Register r = new Register("nicename", "uvdeve@gmail.com", "+37060000000", "super nice",
                "nice color", "3456", "1234", "Vilnius", "short title", "long description",
                "900000");
        r.fill();
    }
}

