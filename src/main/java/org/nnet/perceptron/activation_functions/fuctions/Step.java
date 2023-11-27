package org.nnet.perceptron.activation_functions.fuctions;

import org.nnet.perceptron.activation_functions.iActivationFunction;

public class Step implements iActivationFunction {
    @Override
    public double evaluate(double x) {
        return (x > 0) ? 1 : 0;
    }
}
