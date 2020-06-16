package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDao {

    Map<Integer, User> userDb = new HashMap<>();

    {
        userDb.put(1, new User(1, "user", "123"));
        userDb.put(2, new User(1, "user1", "123"));
        userDb.put(3, new User(1, "user2", "123"));
        userDb.put(4, new User(1, "user3", "123"));
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
