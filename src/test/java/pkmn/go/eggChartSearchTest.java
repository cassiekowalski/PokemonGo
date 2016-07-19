package pkmn.go;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/* Created by kowalskic on 7/19/2016. */
public class eggChartSearchTest {
    @DataProvider(name = "myTest")
    public Object[][] createData(){
        return new Object[][]{
                {"Pokemon Go Egg Chart", "http://www.google.com"},
                {"Pokemon Go Reddit", "http://www.google.com"},
        };
    }

    @Test(dataProvider = "myTest")
    public void test(String searchStr, String URL){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver_win32\\chromedriver.exe");
        //initialize variables
        WebDriver driver = new ChromeDriver();

        //navigate to google
        driver.get(URL);

        //WebElement imageLink = driver.findElement(By.cssSelector("div.gb_ef.gb_R.gb_tf.gb_lf div:nth-child(3) > a"));
        //imageLink.click();

        //get the search text box and enter the given search string
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(searchStr);
        element.submit();

        WebDriverWait wait = (new WebDriverWait(driver, 10));
        wait.until(ExpectedConditions.titleContains(searchStr));

        System.out.println("Page title is " + driver.getTitle());

        //close the browser
        driver.quit();
    }
}
