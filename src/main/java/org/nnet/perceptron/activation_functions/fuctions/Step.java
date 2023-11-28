package org.nnet.perceptron.activation_functions.fuctions;

import org.nnet.perceptron.activation_functions.iActivationFunction;

/**
 * Step activation function
 */
public class Step implements iActivationFunction {
    
    /**
     * Evaluate the step function
     */
    @Override
    public double evaluate(double x) {
        return (x > 0) ? 1 : 0;
    }
}
