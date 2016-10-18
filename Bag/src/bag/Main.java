/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bag;

import java.util.Iterator;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) {
        Bag b = new Bag();
        b.add(new Integer(33));
        b.add(new Integer(333));
        for (Iterator<Integer> it = b.iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

        System.out.println(b);
        b.remove(new Integer(33));
        System.out.println(b);
        // TODO code application logic here
    }

}
