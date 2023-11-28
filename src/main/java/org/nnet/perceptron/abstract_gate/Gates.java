package org.nnet.perceptron.abstract_gate;

/**
 * This enum represents the gates that can be used in the perceptron
 */
public enum Gates {

    // Gates
    AND("AND"),
    OR("OR"),
    NOR("NOR"),
    XOR("XOR"),
    NAND("NAND"),
    XNOR("XNOR");

    /**
     * The name of the gate
     */
    public final String name;
    
    /**
     * Default constructor
     * @param name The name of the gate
     */
    Gates(String name){this.name = name;}
}
