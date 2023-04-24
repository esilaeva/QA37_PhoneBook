package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"pups+1@gmail.com", "Ff12345$"});
        list.add(new Object[]{"b.snyder@gmail.com", "Tt12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/phonebook.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split(",");
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginFile2() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/test.csv")));
        String line = reader.readLine();
        while (line != null){
            String[] all = line.split("/");
            list.add(new Object[]{new User().setEmail(all[0]).setPassword(all[1])});
            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> loginModels() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().setEmail("pups+1@gmail.com").setPassword("Ff12345$")});
        list.add(new Object[]{new User().setEmail("b.snyder@gmail.com").setPassword("Tt12345$")});
        return list.iterator();
    }


}
