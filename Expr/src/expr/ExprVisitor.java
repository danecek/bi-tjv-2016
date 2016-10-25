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
public interface ExprVisitor {

    public void visit(Const cnst);
    
    public void visit(BinOp binOP);

    public void visit(Var var);
}
