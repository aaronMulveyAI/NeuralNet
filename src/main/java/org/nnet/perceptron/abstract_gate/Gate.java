package org.nnet.perceptron.abstract_gate;

import org.nnet.perceptron.activation_functions.fuctions.Step;
import org.nnet.perceptron.activation_functions.iActivationFunction;

public abstract class Gate {
    
    /**
     * Name of the gate
     */
    protected String name;

    /**
     * Evaluation function
     */
    protected iActivationFunction evaluationFunction;

    /**
     * Default constructor
     * @param name name of the gate
     */
    public Gate(String name){
        this(name, new Step());
    }

    /**
     * Constructor
     * @param name name of the gate
     * @param evaluationFunction evaluation function
     */
    public Gate(String name, iActivationFunction evaluationFunction){
        this.name = name;
        this.evaluationFunction = evaluationFunction;
    }

    /**
     * Evaluate the gate
     * @param p first input
     * @param q second input
     * @return output
     */
    public abstract double evaluate(double p, double q);

    /**
     * @return name of the gate
    */
    public String getName() {
        return name;
    }

    /**
     * @return evaluation function
     */
    public iActivationFunction getEvaluationFunction() {
        return evaluationFunction;
    }

    /**
     * @param evaluationFunction evaluation function
     */
    public void setEvaluationFunction(iActivationFunction evaluationFunction) {
        this.evaluationFunction = evaluationFunction;
    }
}
