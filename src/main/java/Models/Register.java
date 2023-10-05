package Models;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

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
        this.condition = condition.toLowerCase();
        this.color = color;
        this.width = width;
        this.length = length;
        this.city = city.toLowerCase();
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
//        selectCondition();
//        selectColor();
        driver.findElement(By.id("width")).sendKeys(this.width);
        driver.findElement(By.id("length")).sendKeys(this.length);
//        selectCity();
        driver.findElement(By.id("title_lt")).sendKeys(this.title);
        driver.findElement(By.id("comments_lt")).sendKeys(this.description);
        driver.findElement(By.id("sell_price_eur")).sendKeys(this.price);
        driver.findElement(By.id("video_url")).sendKeys("https://www.youtube.com/watch?v=AfKZclMWS1U&pp=ygUOZ3plZ296IHlvdXR1YmU%3D&ab_channel=trouchelle");
        driver.findElement(By.xpath("//*[@id=\"main_form\"]/div[3]/div/input")).click();
        allSelects(); // all selects put to the end of the test, due to avoid condition dropdown making tests fail
//        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(this.password);
//        driver.findElement(By.className("submit-button")).click();
    }

    public void allSelects() {
        selectCondition();
        selectColor();
        selectCity();
    }

    public void selectCity() {
        WebElement select = driver.findElement(By.id("fk_place_cities_id[]"));
        select.click();
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().toLowerCase().contains(city)) {
                option.click();
                break;
            }
        }
    }
    public void selectCondition() {
        driver.findElement(By.id("condition_id"));
        switch (condition) {
            case "Nauja":
                driver.findElement(By.xpath("//*[@id=\"condition_id\"]/option[2]"));
                break;
            case "Naudota":
                driver.findElement(By.xpath("//*[@id=\"condition_id\"]/option[3]"));
                break;
        }
    }
    public void selectColor() {
        WebElement select = driver.findElement(By.id("color_id"));
        select.click();
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.getText().contains(color)) {
                option.click();
                break;
            }
        }
    }
}
