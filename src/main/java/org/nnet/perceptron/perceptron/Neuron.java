package org.nnet.perceptron.perceptron;

import org.nnet.perceptron.activation_functions.iActivationFunction;

public class Neuron {


    public Neuron(){

    }

    /**
     * Feed forward method for a single neuron with a single input, single weight and bias  
     * @param input input vector
     * @param weight weight vector
     * @param bias bias value
     * @param activationFunction activation function to be used
     * @return output
     */
    public static double feedForward(
                                        double[]  input,
                                        double[]  weight,
                                        double    bias,
                                        iActivationFunction activationFunction
    ){

        double[] x = input;                         /*       input         */
        double[] w = weight;                        /*       weight        */
        double b = bias;                            /*        bias         */
        double z = 0;                               /*   action potential  */

        for (int i = 0; i < x.length; i++) {
            z += x[i] * w[i];                       /*    weighted sum     */
        }

        z += b;                                     /*      add bias       */
        return activationFunction.evaluate(z);      /* activation function */
    }
}
