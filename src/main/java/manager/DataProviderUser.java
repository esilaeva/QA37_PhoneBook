package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {

    @DataProvider
    public Iterator<Object[]> loginData() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"pups+1@gmail.com", "Ff12345$"});
        list.add(new Object[]{"b.snyder@gmail.com", "Tt12345$"});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

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
