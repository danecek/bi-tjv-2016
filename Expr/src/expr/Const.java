/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expr;

/**
 *
 * @author danecek
 */
public class Const implements Expr {

    private int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return getValue();
        //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public int priority() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void accept(ExprVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Const)) {
            return false;
        }
        return ((Const) obj).value == value;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.value;
        return hash;
    }

}
