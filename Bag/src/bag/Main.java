/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bag;

/**
 *
 * @author danecek
 */
public class Main {

    public static void main(String[] args) {
        Bag b = new Bag(0);
        b.add(new Integer(3));
        b.remove(new Integer(3));
        System.out.println(b);
    }
}
