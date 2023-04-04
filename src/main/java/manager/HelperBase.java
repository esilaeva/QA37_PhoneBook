package manager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        clearNew(element);
        if (text != null) {
            element.sendKeys(text);
        }
    }

    public void click(By locator) {
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public boolean isElementPresent(By locator) {
        List<WebElement> list = wd.findElements(locator);
        return list.size() > 0;
    }


    public boolean isAlertPresent(String message) {
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        if (alert != null && alert.getText().contains(message)) {
            // click Ok
            alert.accept();
            // click Cancel ----> alert.dismiss();
            // click text   ----> alert.sendKeys("text");
            return true;
        }
        return false;
    }

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearNew(WebElement element) {
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }


}
