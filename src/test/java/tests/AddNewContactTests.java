package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    public void login() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("b.snyder@gmail.com").setPassword("Tt12345$"));
        }
    }

    @Test
    public void addNewContactAll() {
        int i = (int) System.currentTimeMillis() / 1000;
        Contact contact = Contact.builder()
                .name("Vera")
                .lastName("Salt")
                .phone("972345" + i)
                .email("v.salt" + i + "@gmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitForm();

        Assert.assertTrue(app.getHelperContact().isActiveContacts());
    }


    @Test
    public void addNewContact() {
        int i = (int) System.currentTimeMillis() / 1000;
        Contact contact = Contact.builder()
                .name("Super")
                .lastName("Girl")
                .phone("972134" + i)
                .email("s.girl" + i + "@gmail.com")
                .address("Tel-Aviv")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitForm();

        Assert.assertTrue(app.getHelperContact().isActiveContacts());
    }
}
