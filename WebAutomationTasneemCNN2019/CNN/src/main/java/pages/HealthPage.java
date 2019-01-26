package pages;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HealthPage extends CommonAPI {

  @FindBy(linkText ="Health" )
  WebElement healthLink;
  @FindBy(id="logo")
  WebElement findLogo;
  @FindBy(linkText = "Food")
  WebElement foodlink;
  @FindBy(linkText = "Fitness")
  WebElement fitnissLink;
  @FindBy(linkText = "Wellness")
  WebElement wellnessLink;
  @FindBy(linkText = "Parenting")
  WebElement parentingLink;
  @FindBy(xpath = "Live Longer")
  WebElement liveLongerLink;
  @FindBy(xpath = "//*[@id=\"zone2\"]/div[2]/div/div[1]/ul/li/article/div/div[1]/a/img")
  WebElement verifyFoodImg;
  public String getTitle(){
        driver.findElement(By.linkText("")).click();
        String actual=driver.getTitle();
        return actual;
  }
  public  boolean testlogo(){ boolean logo=findLogo.isDisplayed();return logo;}
  public void searchPoliticalNews(){
        healthLink.click();
        foodlink.click();
  }
  public boolean searchFoodImg(){
        healthLink.click();
        foodlink.click();
        boolean picture=verifyFoodImg.isDisplayed();
        return picture;
  }
  public String searchTitle(){
        String text=driver.getTitle();
        return text ;
  }
  public void searchFitness(){
        healthLink.click();
        fitnissLink.click();
  }
  public void searchWellness() {
        healthLink.click();
        wellnessLink.click();
  }
    public void searchHealthLink() {
        healthLink.click();}
  public List webElements(){
        List<WebElement> webElements=new ArrayList<>();
        webElements.add(foodlink);
        webElements.add(fitnissLink);
        webElements.add(wellnessLink);
        webElements.add(parentingLink);
        List<String>list =new ArrayList<>();
        for(int i=0;i<webElements.size();i++){
            list.add(webElements.get(i).getText()); }
        System.out.println(list);
        return list;
  }
  public List expectedAllWebElements(){
        List<String> expectedHealthInfo =new ArrayList<>();
        expectedHealthInfo.add("Food");
        expectedHealthInfo.add("Fitness");
        expectedHealthInfo.add("Wellness");
        expectedHealthInfo.add("Parenting");
        return expectedHealthInfo;
  }
  public String SearchCurrentUrl(){
        healthLink.click();
        String url=driver.getCurrentUrl();
        System.out.println(url);
        return url; }


}
