package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.abstract_gate.*;
import org.nnet.perceptron.perceptron.Neuron;

public class Nor extends Gate {
    public Nor(){super(" NOR");}
    @Override
    public double evaluate(double p, double q) {
        return Neuron.feedForward(
                new double[]{p, q},
                new double[]{-1, -1},
                1,
                super.getEvaluationFunction()
        );
    }
}
