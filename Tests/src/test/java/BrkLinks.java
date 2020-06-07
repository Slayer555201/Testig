import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrkLinks {
    public static int brokenLinks;
    public static int validLinks;
    public static String driverPath = "C:/Users/Booster/Downloads/";

    public static void main(String[] args) throws IOException {

        // Setting up Chrome driver path.
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        // Launching Chrome browser.
        WebDriver driver = new ChromeDriver();
        // Enter Url.
        driver.get("https://kinogo.by/");
        // Get all the links url.
        List<WebElement> allURLs = driver.findElements(By.tagName("a"));
        System.out.println("size:" + allURLs.size());

        // The below code will find broken links and check their status.
        //
        validLinks = brokenLinks = 0;
        for (int iter = 0; iter < allURLs.size(); iter++) {
            System.out.println(allURLs.get(iter).getAttribute("href"));
            int statusCode = 0;
            try {
                statusCode = verifyURLStatus(allURLs.get(iter).getAttribute("href"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (statusCode == 404) {
                ++brokenLinks;
            } else {
                ++validLinks;
            }
        }

        System.out.println("Total broken links found# " + brokenLinks);
        System.out.println("Total valid links found#" + validLinks);

    }

    // The below function verifies any broken links and return the server
    // status. It eats up any malformed URL exception and send 404.
    //
    public static int verifyURLStatus(String urlString) {

        int status = 404;
        try {
            URL link = new URL(urlString);
            HttpURLConnection hConn = null;
            hConn = (HttpURLConnection) link.openConnection();
            hConn.setRequestMethod("GET");
            hConn.connect();
            status = hConn.getResponseCode();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return status;
    }

}