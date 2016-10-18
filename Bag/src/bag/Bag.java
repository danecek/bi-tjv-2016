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
public class Bag implements Iterable<Integer> {

    private Integer[] data;
    private int size;

    public Bag(int initLength) {
        if (initLength <= 0) {
            throw new IllegalArgumentException("must be positive");
        }
        data = new Integer[initLength];
    }

    public Bag() {
        this(100);
    }

    public boolean isFull() {
        return size == data.length;
    }

    public void add(Integer e) {
        if (isFull()) {
            throw new BagException("is full");
        }
        data[size++] = e;
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
        data[i] = data[size - 1];
        data[size - 1] = null;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
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

    @Override
    public Iterator<Integer> iterator() {
        //   return new BagIterator(this);
        return new Iterator<Integer>() {

            int actaulPos = 0;

            @Override
            public boolean hasNext() {
                return actaulPos < size();
            }

            @Override
            public Integer next() {
                return data[actaulPos++];
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        }; //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

}
