package org.nnet.perceptron;

import org.nnet.perceptron.abstract_gate.*;
import org.nnet.perceptron.activation_functions.fuctions.*;
import org.nnet.perceptron.activation_functions.*;
import org.nnet.perceptron.perceptron.Perceptron;

import static org.nnet.perceptron.perceptron.Output.*;
import static org.nnet.perceptron.abstract_gate.Gates.*;

/*
        INPUT	    AND		OR	   XOR	   NOR	   NAND  	XNOR
         00		     0		0	    0	    1		1	  	 1
         01		     0		1	    1		0	    1	 	 0
         10		     0		1	    1	    0		1		 0
         11		     1		1       0    	0		0		 1
*/

public class PerceptronMain {

    public static Gates[] gates = {AND, OR, XOR, NOR, NAND, XNOR};

    public static void main(String[] args) {

        iActivationFunction function = new Sigmoid();

        for (Gates gate : gates) {
            new Perceptron(gate,  function).run(DISCRETE);
        }
    }
}
