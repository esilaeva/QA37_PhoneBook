package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
//        Random random = new Random();
//        int i = random.nextInt(1000);

        int z = (int) System.currentTimeMillis() / 1000;

        User user = new User().setEmail("pups+" + z + "@gmail.com")
                .setPassword("Tt12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
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
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }

    @Test(description = "Bug report #234543 Fixed", groups = {"smoke"})
    public void registrationWrongEmail() {
        Random random = new Random();
        int i = random.nextInt(1000);

        int z = (int) System.currentTimeMillis() / 1000;

        User user = new User().setEmail("pups+" + z + "gmail.com")
                .setPassword("Tt12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submitRegistration();

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
        app.getHelperUser().submitRegistration();

        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void registrationExistsUser() {

        User user = new User().setEmail("noa@gmail.com").setPassword("Nnoa12345$");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));


    }


}
