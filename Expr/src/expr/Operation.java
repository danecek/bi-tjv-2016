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
public enum Operation {
    ADD("+", 0),
    SUB("-", 0),
    MLT("*", 1),
    DIV("/", 1);

    private final String symbol;
    private final int priority;

    private Operation(String symbol, int priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return getSymbol();
    }

    /**
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

}
