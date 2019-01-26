package base;

import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public static WebDriver driver = null;

    @BeforeMethod
    public void initializeTest() {
        String getOsNameFromSystem = System.getProperty("os.name");
        System.out.println("opening the browser chrome");
        if (getOsNameFromSystem.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohamed .LAPTOP-QCE4AIJL\\IdeaProjects\\TechnicalA\\driver\\._IEDriverServer.exe");

        } else if (getOsNameFromSystem.contains("Mac")) ;
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\mohamed .LAPTOP-QCE4AIJL\\IdeaProjects\\TechnicalA\\driver\\._IEDriverServer.exe");
        }
        driver =new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35,TimeUnit.SECONDS);
        driver.get("https://www.ebay.com/");
        driver.manage().window().fullscreen();
    }
    @AfterMethod
    public void tearDownTest(){
        System.out.println("closing the browser chrome");
        driver.quit();
    }
    public void brokenLink(){
        //Step:1-Get the list of all links and images
        List<WebElement> linksList =driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));
        System.out.println("Total number of link and images---->>"+linksList.size());
    }
}