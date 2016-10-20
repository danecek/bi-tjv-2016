/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author danecek
 */
public class TestArraySet {

    public static void main(String[] args) {
        Set<Integer> as =  new ArraySet();
        System.out.println(as.isEmpty());
        as.add(new Integer(3));
        as.add(new Integer(33));
        as.add(new Integer(333));
        for (Iterator<Integer> iterator = as.iterator(); iterator.hasNext();) {
            Integer next = iterator.next();
            System.out.println(next);
        }
        System.out.println(as);
        as.add(new Integer(3));
        System.out.println(as);
        as.remove(new Integer(3));
        System.out.println(as);
    }

}
