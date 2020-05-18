import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Pega {
    public static WebDriver driver;

    public static void LaunchBrowser(String Url, String type) throws MalformedURLException {
        if (type.equalsIgnoreCase("local")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("start-maximized");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            System.setProperty("webdriver.chrome.driver", "/usr/bin");
            driver = new ChromeDriver(capabilities);
        } else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("start-maximized");
            capabilities.setBrowserName("chrome");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            driver = new RemoteWebDriver(new URL("http://18.130.136.19:4444/wd/hub"), capabilities);
        }
        driver.get(Url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public static void LoginValid() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtUserID']")));
        driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("ashesh.bhatt");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Krishna@123");
        driver.findElement(By.xpath("//button[@id='sub']")).click();
    }

    public static void LoginInValid() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtUserID']")));
        driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("ashesh.bhatt");
        driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Krishna@1");
        driver.findElement(By.xpath("//button[@id='sub']")).click();
    }

    public static void ValidateLogin() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@title='Switch Studio']")));
        System.out.println("Success");
    }

    public  void close() {
        driver.close();
    }

}
