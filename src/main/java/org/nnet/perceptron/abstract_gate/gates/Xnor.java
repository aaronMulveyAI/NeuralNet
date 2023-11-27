package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.abstract_gate.Gate;
public class Xnor extends Gate {
    public Xnor(){
        super("XNOR");
    }
    @Override
    public double evaluate(double p, double q) {
        Gate and = new And(), nor = new Nor(), or = new Or();

        return or.evaluate(
                and.evaluate(p, q),
                nor.evaluate(p, q)
        );
    }
}