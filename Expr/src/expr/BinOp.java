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
public class BinOp extends Expr {

    private final Operation op;
    private final Expr left;
    private final Expr right;

    public BinOp(Operation op, Expr left, Expr right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    @Override
    int eval() {
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
            default: throw new RuntimeException();
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
        return wrap(left.toString()) + op + wrap(right.toString());
                //enerated methods, choose Tools | Templates.
    }
    
    

}
