package testPages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HealthPage;
import java.util.List;

public class TestHealthPage extends HealthPage {
    HealthPage page;
    @BeforeMethod
    public void getNews() {
        page = PageFactory.initElements(driver, HealthPage.class);
    }
    @Test
    public void testHealthtitle() {
        page.getTitle();
    }
    @Test
    public void testHealthNews() {
        page.SearchCurrentUrl();
    }
    @Test
    public void test2018ElectionResultNews() {
        boolean img = page.searchFoodImg();
        Assert.assertEquals(img, true);
    }
    @Test
    public void testHealthTitle() {
        String actual = page.getTitle();
        Assert.assertEquals(actual, "HealthNews-CNN");
    }
    @Test
    public void testPoliticalHeaderLink() {
        page.searchHealthLink();
        List actual = page.webElements();
        List expected = page.expectedAllWebElements();
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void testCurrentUrl() {
        String actual = page.SearchCurrentUrl();
        Assert.assertEquals(actual, "https://www.cnn.com/health");
    }

}