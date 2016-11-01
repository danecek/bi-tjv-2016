/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expr;

import java.util.Objects;

/**
 *
 * @author danecek
 */
public class BinOp implements Expr {

    private final Operation op;
    private final Expr left;
    private final Expr right;

    public BinOp(Operation op, Expr left, Expr right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    public int eval() {
        int lv = left.eval();
        int rv = right.eval();
        switch (op) {
            case ADD:
                return lv + rv;
            case SUB:
                return lv - rv;
            case MLT:
                return lv * rv;
            case DIV:
                return lv / rv;
            default:
                throw new RuntimeException();
        }
    }

    /**
     * @return the left
     */
    public Expr getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public Expr getRight() {
        return this.right;
    }

    private static String wrap(String s) {
        return "(" + s + ")";
    }

    @Override
    public String toString() {
        String ls = left.toString();
        if (left.priority() < priority()) {
            ls = wrap(ls);
        }
        String rs = right.toString();
        if (right.priority() < priority()) {
            rs = wrap(rs);
        }
        return ls + op + rs;
        //enerated methods, choose Tools | Templates.
    }

    @Override
    public int priority() {
        return op.getPriority();
    }

    @Override
    public void accept(ExprVisitor visitor) {
        left.accept(visitor);
        visitor.visit(this);
        right.accept(visitor);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BinOp)) {
            return false;
        }
        BinOp that = (BinOp) obj;
        return this.op.equals(that.op)
                && left.equals(that.left)
                && right.equals(that.right);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.op);
        hash = 89 * hash + Objects.hashCode(this.left);
        hash = 89 * hash + Objects.hashCode(this.right);
        return hash;
    }

}
