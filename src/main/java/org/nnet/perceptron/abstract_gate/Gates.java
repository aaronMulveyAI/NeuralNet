package org.nnet.perceptron.abstract_gate;

public enum Gates {
    AND("AND"),
    OR("OR"),
    NOR("NOR"),
    XOR("XOR"),
    NAND("NAND"),
    XNOR("XNOR");
    public final String name;
    Gates(String name){this.name = name;}
}
