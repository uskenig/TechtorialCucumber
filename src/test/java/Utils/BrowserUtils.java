package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {
    public static void switchWindow( String targetTitle){
        WebDriver driver=Driver.getDriver();
        Set<String> allWindows=driver.getWindowHandles();
        if (!driver.getTitle().equals(targetTitle)){
            for (String window:allWindows){
                driver.switchTo().window(window);
                if (driver.getTitle().equals(targetTitle)){
                    break;
                }
            }
        }
    }

    public static void verifyBrokenLink(List<WebElement> links) {
        for(WebElement link:links){
            String hrefValue=link.getAttribute("href");
            try{
                URL url=new URL(hrefValue);
                HttpURLConnection connect=(HttpURLConnection)url.openConnection();
                connect.setConnectTimeout(3000);
                connect.connect();
                if(connect.getResponseCode()>=400 || connect.getResponseCode()>=500) {
                    System.out.println(links);
                    System.out.println("The link is broken " + connect.getResponseMessage()+"\n"+connect.getResponseCode());
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void hoverOver( WebElement element){
        WebDriver driver=Driver.getDriver();
        Actions actions=new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static void dragAndDrop( WebElement from, WebElement to){
        WebDriver driver=Driver.getDriver();
        Actions actions=new Actions(driver);
        actions.dragAndDrop(from, to).build().perform();
    }

    public static WebElement waitForVisibility( WebElement element, int seconds){
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), seconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickability(By locator, int seconds){
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), seconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForVisibility(By locator, int seconds){
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(), seconds);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement fluentWait(WebElement element, int seconds, int pollingTime){
        Wait<WebDriver> wait =new FluentWait<>(Driver.getDriver())
                .withTimeout(seconds, TimeUnit.SECONDS)
                .pollingEvery(pollingTime, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        WebElement element1=wait.until(
                driver -> element
        );
        return element1;
    }

    public static void takeScreenShot() throws IOException {
        WebDriver driver = Driver.getDriver();
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File desFile = new File("ScreenShotFile/" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(src, desFile);
    }

    public static void waitForSec(int time){
        time=time*1000;
        try {
            Thread.sleep(time);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void selectByVisibleText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
}



