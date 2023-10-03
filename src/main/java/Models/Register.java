package Models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Register {

    public WebDriver driver;
    public String name;
    public String email;
    public String phone;
    public String condition;
    public String color;
    public String width;
    public String length;
    public String city;
    public String title;
    public String description;
    public String price;

    public String password;

    public Register (String name, String email, String phone, String condition, String color, String width, String length,
                     String city, String title, String description, String price, String password){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.condition = condition;
        this.color = color;
        this.width = width;
        this.length = length;
        this.city = city;
        this.title = title;
        this.description = description;
        this.price = price;
        this.password = password;
        this.driver = Helper.driver;
    }
    public void fill(){
        driver.findElement(By.id("contacts_name")).sendKeys(this.name);
        driver.findElement(By.id("contacts_email")).sendKeys(this.email);
        driver.findElement(By.id("contacts_phone")).sendKeys(this.phone);
        driver.findElement(By.id("condition_id")).click();
        driver.findElement(By.xpath("//*[@id=\"condition_id\"]/option[2]")).click();
        driver.findElement(By.id("color_id")).click();
        driver.findElement(By.xpath("//*[@id=\"color_id\"]/option[3]")).click();
        driver.findElement(By.id("width")).sendKeys(this.width);
        driver.findElement(By.id("length")).sendKeys(this.length);
        driver.findElement(By.id("fk_place_cities_id[]")).click();
        driver.findElement(By.xpath("//*[@id=\"fk_place_cities_id[]\"]/optgroup[1]/option[2]")).click();
        driver.findElement(By.id("title_lt")).sendKeys(this.title);
        driver.findElement(By.id("comments_lt")).sendKeys(this.description);
        driver.findElement(By.id("sell_price_eur")).sendKeys(this.price);
        driver.findElement(By.id("video_url")).sendKeys("https://www.youtube.com/watch?v=AfKZclMWS1U&pp=ygUOZ3plZ296IHlvdXR1YmU%3D&ab_channel=trouchelle");
        driver.findElement(By.xpath("//*[@id=\"main_form\"]/div[3]/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(this.password);
        driver.findElement(By.className("submit-button")).click();
    }
}
