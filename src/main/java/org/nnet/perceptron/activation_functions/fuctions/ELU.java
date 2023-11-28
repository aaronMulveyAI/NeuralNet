package org.nnet.perceptron.activation_functions.fuctions;

import org.nnet.perceptron.activation_functions.iActivationFunction;

import static java.lang.Math.E;

/**
 * ELU activation function
 */
public class ELU implements iActivationFunction {
    
    /**
     * Default constructor
     */
    public static final double ALPHA = 1;
    
    /**
     * Activation function
     */
    @Override
    public double evaluate(double x) {
        return (x < 0) ? ALPHA * (Math.pow(E, x) - 1) : x;
    }
}
