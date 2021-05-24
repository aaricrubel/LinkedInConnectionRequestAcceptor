import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("user-data-dir="+System.getProperty("user.dir")+ "\\dd");

        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://www.linkedin.com");
        while(!new Scanner(System.in).next().equals("1")){
            System.out.println("press 1 when signed in: ");
        }

        try {
            driver.findElement(By.id("ember21")).click();
            Thread.sleep(5000);
//            driver.findElement(By.id("ember2732")).click();
//            driver.findElement(By.className("ember-view mn-invitations-preview__manage-all artdeco-button artdeco-button--tertiary  artdeco-button--muted artdeco-button--2")).click();
//            Thread.sleep(5000);
//            List<WebElement> accepts = driver.findElements(By.className("invitation-card__action-btn artdeco-button artdeco-button--2 artdeco-button--secondary ember-view"));
//            for(var el : accepts) {
//                el.click();
//            }
//            var i = 0;
//            while(accepts.size() > 1){
//                accepts.get(i).click();
//                i++;
//            }

            boolean element_exists =  true;
            while(element_exists) {
                try {
                    driver.findElement(By.className("invitation-card__action-btn")).click();
                }
                catch (NoSuchElementException exception) {
                    element_exists = false;
                }
                finally {
                    if (element_exists) {
                        driver.findElement(By.className("invitation-card__action-btn artdeco-button--secondary")).click();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
