package org.nnet.perceptron.abstract_gate;

import org.nnet.perceptron.activation_functions.fuctions.Step;
import org.nnet.perceptron.activation_functions.iActivationFunction;

public abstract class Gate {
    protected String name;
    protected iActivationFunction evaluationFunction;

    public Gate(String name){
        this(name, new Step());
    }
    public Gate(String name, iActivationFunction evaluationFunction){
        this.name = name;
        this.evaluationFunction = evaluationFunction;
    }
    public abstract double evaluate(double p, double q);
    public String getName() {
        return name;
    }
    public iActivationFunction getEvaluationFunction() {
        return evaluationFunction;
    }
    public void setEvaluationFunction(iActivationFunction evaluationFunction) {
        this.evaluationFunction = evaluationFunction;
    }
}
