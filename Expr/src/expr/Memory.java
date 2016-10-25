/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expr;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author danecek
 */
public class Memory {

    public static Memory inst = new Memory();

    Map<Var, Integer> vars = new TreeMap<>();

    private Memory() {
        vars.put(new Var("X"), 1);
        vars.put(new Var("Y"), 2);
    }

    public int getValue(Var var) {
        if (!vars.containsKey(var)) {
            throw new RuntimeException("unknown variable: " + var);
        }
        return vars.get(var);
    }
}
