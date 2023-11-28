package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.abstract_gate.Gate;

/**
 * This class represents a XNOR gate.
 */
public class Xnor extends Gate {

    /**
     * Default constructor
     */
    public Xnor(){
        super("XNOR");
    }

    /**
     * Calls feed forward
     */
    @Override
    public double evaluate(double p, double q) {
        Gate and = new And(), nor = new Nor(), or = new Or();

        return or.evaluate(
                and.evaluate(p, q),
                nor.evaluate(p, q)
        );
    }
}