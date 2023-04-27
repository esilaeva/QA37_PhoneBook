package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    public Iterator<Object[]> contactFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contact.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }
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
