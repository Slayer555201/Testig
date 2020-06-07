import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import static org.testng.AssertJUnit.assertEquals;

public class SingUp {


    private WebDriver driver;

    @Test
    public void SignUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Booster/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://bulavka.by/");
        driver.findElement(By.linkText("Регистрация")).click();
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);

        WebDriverWait wait = new WebDriverWait(driver,10);
        Thread.sleep(1000);
        Random random = new Random();
        int n = random.nextInt(100) +1;
        String email = "ivanlushakov" + n + "@mail.ru";

        driver.findElement(By.id("name")).sendKeys("Ivan Lushakov");
        driver.findElement(By.id("login")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("password12345");
        driver.findElement(By.id("password2")).sendKeys("password12345");

        driver.switchTo().window(parentWindowHandler);






       /* driver.findElement(By.xpath("//div[@id='react-root']/section/main/article/div[2]/div[2]/div/p/a/span")).click();
        wait.until(ExpectedConditions.titleIs("Зарегистрироваться • Instagram"));
        Random random = new Random();
        int n = random.nextInt(100) +1;
        String email = "lushakovivan" + n + "@mail.ru";
        String username = "lushakovivan" +n;

        driver.findElement(By.name("emailOrPhone")).sendKeys(email);
        driver.findElement(By.name("fullName")).sendKeys("Ivan Pupkin");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys("vanya2000");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait.until(ExpectedConditions.titleIs("Зарегистрироваться • Instagram"));
driver.findElement(By.linkText("июня")).click();
        new Select(driver.findElement(By.xpath("id(\"nav\")/div[1]/div[2]/div[2]/div[1]/div[1]/a[1]/span[1]"))).selectByVisibleText("Начните здесь");
        driver.findElement(By.xpath("id(\"nav\")/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/a[1]")).click();

*/


    }
}
