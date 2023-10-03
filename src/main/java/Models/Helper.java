package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper {
    public static WebDriver driver;

    public static void acceptCookies() {
        Helper.driver.get("https://sutarta.lt/");
        Helper.driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
}
