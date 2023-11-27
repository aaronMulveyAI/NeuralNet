package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.abstract_gate.Gate;
public class Xor extends Gate {
    public Xor(){
        super(" XOR");
    }
    @Override
    public double evaluate(double p, double q) {
        Gate and = new And(), nand = new Nand(), or = new Or();

        return and.evaluate(
                or.evaluate(p, q),
                nand.evaluate(p, q)
        );
    }
}
