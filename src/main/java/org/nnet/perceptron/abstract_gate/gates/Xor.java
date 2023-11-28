package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.abstract_gate.Gate;

/**
 * This class represents a XOR gate.
 */
public class Xor extends Gate {
   
    /**
     * Default constructor
     */
    public Xor(){
        super(" XOR");
    }

    /**
     * Calls feed forward
     */
    @Override
    public double evaluate(double p, double q) {
        Gate and = new And(), nand = new Nand(), or = new Or();

        return and.evaluate(
                or.evaluate(p, q),
                nand.evaluate(p, q)
        );
    }
}
