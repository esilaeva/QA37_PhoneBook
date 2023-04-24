package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder()
                .name("Vera")
                .lastName("Girl")
                .phone("123")
                .email("s.girl345@gmail.com")
                .address("Tel-Aviv")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Vera1")
                .lastName("Salt")
                .phone("1234567890123456")
                .email("v.salt@gmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Vera1")
                .lastName("Salt")
                .phone("123456789f")
                .email("v.salt@gmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Vera1")
                .lastName("Salt")
                .phone("")
                .email("v.salt@gmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build()});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();

        list.add(new Object[]{Contact.builder()
                .name("Vera2")
                .lastName("Girl")
                .phone("97213423456")
                .email("s.girl345@gmail.com")
                .address("Tel-Aviv")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Vera1")
                .lastName("Salt")
                .phone("97234564567")
                .email("v.salt@gmail.com")
                .address("Tel-Aviv")
                .description("The best friend")
                .build()});

        return list.iterator();
    }

}
