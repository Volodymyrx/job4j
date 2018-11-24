package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * class UserConvert
 * project lesson 3.3.2
 *
 * @author Volodymyr Martynenko (VolodymyrV.Martynenko@gmail.com)
 * project job4j
 * @version 1.0
 * @since 24.11.2018
 */
public class UserConvert {
    /**
     * take from array List User and put in hashMap User
     *
     * @param list lis user
     * @return map wish kay as id User's
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> mapUser = new HashMap<>();
        for (User user : list) {
            mapUser.put(user.getId(), user);
        }
        return mapUser;
    }
}
