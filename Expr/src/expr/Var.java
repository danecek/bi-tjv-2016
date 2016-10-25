/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expr;


public class Var extends Expr implements Comparable<Var> {

    private final String name;

    public Var(String name) {
        this.name = name;
    }

    @Override
    int eval() {
        return Memory.inst.getValue(this);
    }

    @Override
    int priority() {
        return Integer.MAX_VALUE;
    }

    @Override
    void accept(ExprVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        if (!(that instanceof Var)) {
            return false;
        }
        Var thatVar = (Var) that;
        return compareTo(thatVar) == 0;

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Var that) {
        return name.compareTo(that.name);
    }

}
