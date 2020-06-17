package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {
    Map<Integer, User> userDb = new HashMap<>();


    {
        userDb.put(0, new User(0, "smith", "smith@gmail.com", "123"));
        userDb.put(1, new User(1, "galbert", "galberncw@gmail.com", "123"));
        userDb.put(2, new User(2, "gordon", "gordon@gmail.com", "123"));
        userDb.put(3, new User(3, "fahad", "fahad@gmail.com", "123"));
    }


    public int generateID() {
        return userDb.size() + 1;
    }

    public List<User> getUser() {
        return new ArrayList<>(userDb.values());
    }

    public User findUserByEmail(String email, String password) {
        for (User user: getUser()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
