import Models.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
    } // delete

    @BeforeClass
    public void beforeClass() {
        Helper.driver = new ChromeDriver();
        Helper.driver.manage().window().maximize();
        Helper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Helper.acceptCookies();
    }

    @AfterClass
    public void afterClass() {
        Helper.driver.quit();
    }

    @Test
    public void addNewAdTest() { // Nr 1 positive Test
        Helper.driver.findElement(By.id("contacts_name")).sendKeys("Nammmeeee");
        Helper.driver.findElement(By.id("contacts_email")).sendKeys("ahejj@gmail.com");
        Helper.driver.findElement(By.id("contacts_phone")).sendKeys("+37061121111");
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
    public void secondTest() { // NR 2 positive test
        Register r = new Register("mynamme", "ue@gmail.com", "+37060110000", "super nice",
                "nice color", "3456", "1234", "Vilnius", "short title", "long description",
                "900000", "superpassword");
        r.fill();
    }
    @Test
    public void noNameTest() { // NR 3 name is empty
        Register r = new Register("", "ue@gmail.com", "+37060110000", "super nice",
                "nice color", "3456", "1234", "Vilnius", "short title", "long description",
                "900000", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("contacts_name")).getAttribute("class").contains("fl textbox req required-box");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noEmailTest() { // NR 4 email is empty
        Register r = new Register("mynamme", "", "+37060110000", "super nice",
                "nice color", "3456", "1234", "Vilnius", "short title", "long description",
                "900000", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("contacts_email")).getAttribute("class").contains("textbox req required-box");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noPhoneTest() { // NR 5 phone field is empty
        Register r = new Register("mynamme", "ue@gmail.com", "", "super nice",
                "nice color", "3456", "1234", "Vilnius", "short title", "long description",
                "900000", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("contacts_phone")).getAttribute("class").contains("textbox req required-box");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noConditionTest() { // NR 6 condition is empty
        Register r = new Register("mynamme", "ue@gmail.com", "+37060110000", "",
                "nice color", "3456", "1234", "Vilnius", "short title", "long description",
                "900000", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("condition_id")).getAttribute("class").contains("textbox req required-box");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noColorTest() { // NR 7 color is empty
        Register r = new Register("mynamme", "ue@gmail.com", "+37060110000", "super nice",
                "", "3456", "1234", "Vilnius", "short title", "long description",
                "900000", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("color_id")).getAttribute("class").contains("textbox ");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noCityTest() { // NR 8 city is empty (this tes will fail due to incorrect code - it does not give "required-box" class)
        Register r = new Register("mynamme", "ue@gmail.com", "+37060110000", "Nauja",
                "Balta", "4567", "1234", "", "short title", "long description",
                "900000", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.xpath("//*[@id=\"static_fields\"]/table/tbody/tr[1]/td/div[3]/div")).getAttribute("class").contains("error-msg");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noTitleTest() { // NR 9 title is empty
        Register r = new Register("name", "ue@gmail.com", "+37060110000", "super nice",
                "nice color", "3456", "1234", "Vilnius", "", "long description",
                "900000", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("title_lt")).getAttribute("class").contains("fl textbox req required-box");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noDescrTest() { // NR 10 descr is empty
        Register r = new Register("names", "ue@gmail.com", "+37060110000", "super nice",
                "nice color", "3456", "1234", "Vilnius", "short title", "",
                "900000", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("comments_lt")).getAttribute("class").contains("fl textbox req required-box");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noPriceTest() { // NR 11 price is empty
        Register r = new Register("names", "ue@gmail.com", "+37060110000", "super nice",
                "nice color", "3456", "1234", "Vilnius", "short title", "sdbersrhr",
                "", "superpassword");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("sell_price_eur")).getAttribute("class").contains("textbox short req required-box");
        Assert.assertTrue(hasClass);
    }
    @Test
    public void noPasswTest() { // NR 12 password is empty
        Register r = new Register("names", "ue@gmail.com", "+37060110000", "Nauja",
                "Balta", "3456", "1234", "Vilnius", "short title", "sdbersrhr",
                "999999", "");
        r.fill();
        boolean hasClass = Helper.driver.findElement(By.id("password")).getAttribute("class").contains("textbox");
        Assert.assertTrue(hasClass);
    }

}

