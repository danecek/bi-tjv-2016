/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customers.model;

public class CustomerId implements Comparable<CustomerId> {

    private final int id;

    public CustomerId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof CustomerId)) {
            return false;
        }
        return compareTo((CustomerId) obj) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public int compareTo(CustomerId o) {
        return id - o.id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "" + id;
    }

}
