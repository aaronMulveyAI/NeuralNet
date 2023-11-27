package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.perceptron.Neuron;
import org.nnet.perceptron.abstract_gate.Gate;
public class Nand extends Gate {
    public Nand(){super("NAND"); }
    @Override
    public double evaluate(double p, double q) {
        return Neuron.feedForward(
                new double[]{p, q},
                new double[]{-1, -1},
                2,
                super.getEvaluationFunction()
        );
    }
}