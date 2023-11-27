package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.perceptron.Neuron;
import org.nnet.perceptron.abstract_gate.Gate;
public class And extends Gate {
    public And(){super(" AND");}
    @Override
    public double evaluate(double p, double q) {
        return Neuron.feedForward(
                new double[]{p, q},
                new double[]{1, 1},
                -1,
                super.getEvaluationFunction()
        );
    }
}
