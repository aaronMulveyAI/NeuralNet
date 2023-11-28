package org.nnet.perceptron.abstract_gate.gates;

import org.nnet.perceptron.perceptron.Neuron;
import org.nnet.perceptron.abstract_gate.Gate;

/**
 * OR gate
 */
public class Or extends Gate {

    /**
     * Default constructor
     */
    public Or(){super(" OR ");}
    
    /**
     * Calls feed forward
     */
    @Override
    public double evaluate(double p, double q) {

        return Neuron.feedForward(
                new double[]{p, q},
                new double[]{1, 1},
                0,
                super.getEvaluationFunction()
        );
    }
}

