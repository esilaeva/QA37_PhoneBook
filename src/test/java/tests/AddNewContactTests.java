package tests;

import models.Contact;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{
    @Test
    public void addNewContact(){
        int i = (int) System.currentTimeMillis()/1000;
        Contact contact = Contact.builder()
                .name("")
                .lastName("")
                .phone("")
                .address("")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm();
        app.getHelperContact().submitForm();


    }

}
