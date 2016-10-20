/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayset;

import java.util.Iterator;

public class ArraySetIterator implements Iterator<Integer> {
    
    Integer[] data;
    int size;

    public ArraySetIterator(Integer[] data, int size) {
        this.data = data;
        this.size = size;
    }
    
    int actPos = 0;

    @Override
    public boolean hasNext() {
        return actPos < size;
    }

    @Override
    public Integer next() {
        return data[actPos++];
    }

}
