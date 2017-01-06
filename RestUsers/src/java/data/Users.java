/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class Users {

    private Map<Integer, User> usersMap = new TreeMap<>();
     private static int counter;

    @PostConstruct
    public void init() {
        add(new User("Tom"));
    }

    public List<User> all() {
        return new ArrayList<>(usersMap.values());
    }

    public User find(Integer id) {
        return usersMap.get(id);
    }

    private Integer id() {
        SortedSet<Integer> ss = ((SortedSet) usersMap.keySet());
        if (ss.isEmpty()) {
            return 1;
        }
        return ss.last() + 1;
    }

    private void setId(User user) {
        if (user.getId() == null) {
            user.setId(id());
        }
    }

    public void add(User user) {
        setId(user);
        usersMap.put(user.getId(), user);
    }

}
