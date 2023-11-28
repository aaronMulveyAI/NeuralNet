package org.nnet.perceptron.activation_functions.fuctions;

import org.nnet.perceptron.activation_functions.iActivationFunction;

/**
 * ReLU activation function
 */
public class ReLU implements iActivationFunction {
    
    /**
     * Evaluate the ReLU function
     */
    @Override
    public double evaluate(double x) {
        return Math.max(0, x);
    }
}
