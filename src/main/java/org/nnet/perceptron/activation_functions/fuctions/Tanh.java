package org.nnet.perceptron.activation_functions.fuctions;

import org.nnet.perceptron.activation_functions.iActivationFunction;

/**
 * Tanh activation function
 */
public class Tanh implements iActivationFunction {
    
    /**
     * Evaluate the tanh function
     */
    @Override
    public double evaluate(double x) {
        return Math.tanh(x);
    }
}
