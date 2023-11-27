package org.nnet.perceptron.perceptron;

import org.nnet.perceptron.activation_functions.iActivationFunction;

public class Neuron {
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
