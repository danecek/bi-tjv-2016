/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

interface Expr extends Serializable {

    int eval();

    int priority();

    void accept(ExprVisitor visitor);

    default void save(String out) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(out))) {
            oos.writeObject(this);
        }
    }

    static Expr load(String in) throws IOException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(in));
            return (Expr) ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Expr.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

}
