/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danecek
 */
public class Names {

    public static Names inst = new Names();

    private List<String> names = new ArrayList<>();

    public void addname(String name) {
        names.add(name);
    }

    public List<String> allNames() {
        return names;
    }

    public void deletAll() {
        names.clear();
    }

    private Names() {
    }

}
