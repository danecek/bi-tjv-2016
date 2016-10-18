/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expr;

import static expr.Operation.*;

public class Main {

    public static void main(String[] args) {
        Expr e = new BinOp(ADD, 
                       new BinOp(Operation.MLT, 
                            new Const(1), 
                            new Const(2)), 
                 new Const(3));
        System.out.println(e.eval());
        System.out.println(e);
    }
}