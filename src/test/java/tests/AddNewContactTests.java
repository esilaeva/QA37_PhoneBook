package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase {

    @BeforeClass
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("b.snyder@gmail.com").setPassword("Tt12345$"));
        }
    }

    @Test
    public void addContactSuccessAllFields() {
        int i = (int) System.currentTimeMillis() / 1000;
        Contact contact = Contact.builder()
                .name("Vera1")
                .lastName("Salt")
                .phone("972345" + i)
                .email("v.salt" + i + "@gmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isActiveContacts());
        Assert.assertTrue(app.getHelperContact().isContactAddByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddByPhone(contact.getPhone()));
    }


    @Test
    public void addContactSuccessRequiredFields() {
        int i = (int) System.currentTimeMillis() / 1000;
        Contact contact = Contact.builder()
                .name("Vera2")
                .lastName("Girl")
                .phone("972134" + i)
                .email("s.girl" + i + "@gmail.com")
                .address("Tel-Aviv")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperContact().isActiveContacts());
        Assert.assertTrue(app.getHelperContact().isContactAddByName(contact.getName()));
        Assert.assertTrue(app.getHelperContact().isContactAddByPhone(contact.getPhone()));
    }

    @Test
    public void addNewContactWrongName() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("GirlName")
                .phone("972134454545")
                .email("s.girl@gmail.com")
                .address("Tel-Aviv")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperUser().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongAddress() {
        Contact contact = Contact.builder()
                .name("Vera3")
                .lastName("Salt")
                .phone("972345343434")
                .email("v.salt@gmail.com")
                .address("")
                .description("The best friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperUser().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongLastName() {
        Contact contact = Contact.builder()
                .name("Vera4")
                .lastName("")
                .phone("972345232323")
                .email("v.salt@gmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperUser().isAddPageStillDisplayed());
    }

    @Test
    public void addNewContactWrongPhone() {
        Contact contact = Contact.builder()
                .name("Vera5")
                .lastName("Salt")
                .phone("")
                .email("v.salt@gmail.com")
                .address("Tel-Aviv")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperUser().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(" Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }

    @Test
    public void addNewContactWrongEmail() {
        Contact contact = Contact.builder()
                .name("Vera6")
                .lastName("Salt")
                .phone("972345778899")
                .email("v.saltgmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().saveContact();

        Assert.assertTrue(app.getHelperUser().isAddPageStillDisplayed());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid: must be a well-formed email address"));
    }


}
