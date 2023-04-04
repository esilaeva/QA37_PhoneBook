package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    Contact contact;

    @BeforeClass
    public void preConditionClass() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("b.snyder@gmail.com").setPassword("Tt12345$"));
        }
    }

    @BeforeMethod
    public void preConditionMethod() {
        app.getHelperContact().provideContacts(); /// if list <3 ===> add 3 contacts
    }

    @Test
    public void removeFirstContact() {
        int size = app.getHelperContact().listContactSize();

        app.getHelperContact().selectContact();
        app.getHelperContact().submitDeleteContact();
        app.getHelperContact().pause(3000);

        Assert.assertEquals(app.getHelperContact().listContactSize(), size - 1);
    }

    @Test
    public void removeAllContacts() {

        app.getHelperContact().selectContact();
        app.getHelperContact().deleteAllContact();

        Assert.assertEquals(app.getHelperContact().getMessage(), "No Contacts here!");
    }

}
