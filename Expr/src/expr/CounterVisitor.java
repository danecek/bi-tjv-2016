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
public class CounterVisitor implements ExprVisitor {

    private int counter;

    @Override
    public void visit(Const cnst) {
        counter++;
    }

    @Override
    public void visit(BinOp binOP) {
        counter++;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    @Override
    public void visit(Var var) {
        counter++;
    }

}
