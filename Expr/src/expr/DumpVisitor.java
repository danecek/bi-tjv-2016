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
public class DumpVisitor implements ExprVisitor {

    @Override
    public void visit(Const cnst) {
        System.out.println(cnst.toString());
    }

    @Override
    public void visit(BinOp binOP) {
        System.out.println(binOP.toString());

    }

    @Override
    public void visit(Var var) {
        System.out.println(var.toString());
    }
    
}
