import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.datatype.Duration;


public class WebDriverAdidasTest {

    public static String expectedResult = "1 ПОНРАВИВШАЯСЯ МОДЕЛЬ";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void driverSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void addToWishlistTest() {
        driver.get("https://www.adidas.ru/krossovki-lxcon/FV9835.html");
        WebElement addToWishlistBtn = driver.findElement(By.xpath("//div[@data-auto-id=\"wishlist-button\"]"));
        addToWishlistBtn.click();
        WebElement goToWishlistBtn = driver.findElement(By.xpath("//div[@class=\"gl-wishlist-icon wishlist_button___3ppwb solid-icon-color___1IHWy\"]"));
        goToWishlistBtn.click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class=\"gl-modal__close\"]")));
        WebElement closeDialog = driver.findElement(By.xpath("//button[@class=\"gl-modal__close\"]"));
        closeDialog.click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"col-s-12 col-l-16 col-xl-18 \"]/p")).getText(), expectedResult);
    }

    @AfterMethod(alwaysRun = true)
    public void driverShutDown(){
        driver.quit();
        driver=null;
    }
}
