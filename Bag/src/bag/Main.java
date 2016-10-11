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
        Bag b = new Bag(1);
        b.add(new Integer(33));
        b.remove(new Integer(33));
        System.out.println(b);
        // TODO code application logic here
    }

}
