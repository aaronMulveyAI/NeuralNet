package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.perceptron.Neuron;
import org.nnet.perceptron.abstract_gate.Gate;

/**
 * AND gate
 */
public class And extends Gate {

    /**
     * Default constructor
     */
    public And(){super(" AND");}

    /**
     * Calls feed forward
     */
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
