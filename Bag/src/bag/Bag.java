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
public class Bag extends Object {

    private Integer[] data;
    private int size;

    public Bag() {
        this(100);
    }

    public Bag(int initSize){
        if (initSize <=0)
            throw new BagException("must be positive");
        data = new Integer[initSize];
    }

    public void add(Integer e) {
        if (full())
            throw new BagException("is full");
        data[size++] = e;
    }

    public boolean contains(Integer e) {
        return find(e) != -1;
    }

    private int find(Integer e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean remove(Integer e) {
        int i = find(e);
        if (i == -1) {
            return false;
        }
        // System.arraycopy(i, 0, e, 0, 0);
        data[i] = data[size - 1];
        data[--size] = null;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public int getSize() {
        return size;
    }

    public boolean full() {
        return size == data.length;
    }

}
