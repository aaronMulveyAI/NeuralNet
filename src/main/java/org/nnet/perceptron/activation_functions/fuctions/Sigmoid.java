package org.nnet.perceptron.activation_functions.fuctions;

import org.nnet.perceptron.activation_functions.iActivationFunction;

/**
 * Sigmoid activation function
 */
public class Sigmoid implements iActivationFunction {
    
    /**
     * Evaluate the sigmoid function
     */
    @Override
    public double evaluate(double x) {
        return Math.tanh(x);
    }
}
