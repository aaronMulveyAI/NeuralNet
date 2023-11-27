package org.nnet.perceptron.activation_functions.fuctions;

import org.nnet.perceptron.activation_functions.iActivationFunction;

import static java.lang.Math.E;

public class ELU implements iActivationFunction {
    public static final double ALPHA = 1;
    @Override
    public double evaluate(double x) {
        return (x < 0) ? ALPHA * (Math.pow(E, x) - 1) : x;
    }
}
