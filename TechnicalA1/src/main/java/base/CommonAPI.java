package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public static WebDriver driver = null;

    @BeforeMethod
    public void initializeTest() {
        String getOsNameFromSystem = System.getProperty("os.name");
        System.out.println("opening the browser chrome");
        if (getOsNameFromSystem.contains("Windows")) {
            System.setProperty("webdriver.chrome.driver", "C://Users//mohamed .LAPTOP-QCE4AIJL//IdeaProjects//TechnicalA1//driver//chromedriver.exe");

        } else if (getOsNameFromSystem.contains("Mac")) ;
        {
            System.setProperty("webdriver.chrome.driver", "C://Users//mohamed .LAPTOP-QCE4AIJL//IdeaProjects//TechnicalA1//driver//chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.get("https://www.makemysushi.com/");
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void tearDownTest() {
        System.out.println("closing the browser chrome");
        driver.quit();
    }

    public void brokenLink()throws IOException {
        //Step:1-Get the list of all links and images
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        linksList.addAll(driver.findElements(By.tagName("img")));
        System.out.println("Total number of link and images---->>" + linksList.size());
        List<WebElement> activeLinks =new ArrayList<WebElement>();

        //Step:2-->Iterrate linkList:exclude all links/images which does not have any href attribute
        for(int i=0;i<linksList.size();i++){
            linksList.get(i).getAttribute("href");
            System.out.println(linksList.get(i).getAttribute("href"));
            if(linksList.get(i).getAttribute("href")!=null
                    && (! linksList.get(i).getAttribute("href").contains("javascript")
                    && (! linksList.get(i).getAttribute("href").contains("mailto")))){
                activeLinks.add(linksList.get(i));
            }


        }
        System.out.println("Total number of link and images---->>" + activeLinks.size());
        //Step:3--> Check the href url,with http connection api
        for(int j=0;j<activeLinks.size();j++){
            HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
            connection.connect();
            String response=connection.getResponseMessage();
            connection.disconnect();
            System.out.println(activeLinks.get(j).getAttribute("href")+"--->>+"+response);
        }
    }
}