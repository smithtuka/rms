package model;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    Map<Integer, User> userDb = new HashMap<>();


    {
        userDb.put(0, new User(0, "smithtuka@gmail.com", "123"));
        userDb.put(1, new User(1, "galberncw@gmail.com", "123"));
        userDb.put(2, new User(2, "gordon@gmail.com", "123"));
        userDb.put(3, new User(3, "f.faraqhan@gmail.com", "123"));

    }


    public int generateID() {
        return userDb.size() + 1;
    }
}
