package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);

        int z = (int) System.currentTimeMillis() / 1000;

        User user = new User().setEmail("pups+" + z + "@gmail.com")
                .setPassword("Tt12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

    @Test
    public void registrationSuccess2() {
        Random random = new Random();
        int i = random.nextInt(1000);

        int z = (int) System.currentTimeMillis() / 1000;

        User user = new User().setEmail("pups+" + z + "@gmail.com")
                .setPassword("Tt12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isElementPresent(By.xpath("//*[text()='Sign Out']")));
    }

    @Test
    public void registrationWrongEmail() {
        Random random = new Random();
        int i = random.nextInt(1000);

        int z = (int) System.currentTimeMillis() / 1000;

        User user = new User().setEmail("pups+" + z + "gmail.com")
                .setPassword("Tt12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void registrationWrongPassword() {
        Random random = new Random();
        int i = random.nextInt(1000);

        int z = (int) System.currentTimeMillis() / 1000;

        User user = new User().setEmail("pups+" + z + "@gmail.com")
                .setPassword("Tt12345");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

}
