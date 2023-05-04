package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {

    Contact contact;

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().setEmail("b.snyder@gmail.com").setPassword("Tt12345$"));
        }
        app.getHelperContact().provideContacts();
    }

//    @BeforeMethod
//    public void preConditionMethod() {
//        app.getHelperContact().provideContacts(); /// if list <3 ===> add 3 contacts
//    }

    @Test(groups = {"smoke"})
    public void removeFirstContact() {
       // int size = app.getHelperContact().listContactSize();
        app.getHelperContact().selectContact();
        app.getHelperContact().submitDeleteContact();
        app.getHelperContact().pause(3000);

        //Assert.assertEquals(app.getHelperContact().listContactSize(), size - 1);
        Assert.assertEquals(app.getHelperContact().removeOneContact(), 1);
    }

    @Test
    public void removeAllContacts() {
//        app.getHelperContact().selectContact();
//        app.getHelperContact().deleteAllContact();
//

        app.getHelperContact().removeAllContacts();
        Assert.assertEquals(app.getHelperContact().getMessage(), "No Contacts here!");
    }

}
