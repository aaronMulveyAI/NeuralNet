package org.nnet.perceptron.activation_functions.fuctions;

import org.nnet.perceptron.activation_functions.iActivationFunction;

public class ReLU implements iActivationFunction {
    @Override
    public double evaluate(double x) {
        return Math.max(0, x);
    }
}
