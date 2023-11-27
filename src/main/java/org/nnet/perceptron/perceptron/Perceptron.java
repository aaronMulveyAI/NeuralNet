package org.nnet.perceptron.perceptron;

import org.nnet.perceptron.abstract_gate.*;
import org.nnet.perceptron.activation_functions.iActivationFunction;
import org.nnet.perceptron.abstract_gate.gates.*;

/*
        INPUT	    AND		OR	   XOR	   NOR	   NAND  	XNOR
         00		     0		0	    0	    1		1	  	 1
         01		     0		1	    1		0	    1	 	 0
         10		     0		1	    1	    0		1		 0
         11		     1		1       0    	0		0		 1
*/

public class Perceptron {
    private final Gate GATE;
    public Perceptron(Gates option, iActivationFunction activationFunction){
        this.GATE = selectGate(option);
        this.GATE.setEvaluationFunction(activationFunction);
    }

    public Gate selectGate(Gates option){
        return switch (option){
            case NAND   ->   new Nand();
            case OR     ->   new Or();
            case NOR    ->   new Nor();
            case XOR    ->   new Xor();
            case XNOR   ->   new Xnor();
            default     ->   new And();
        };
    }
    public void run(Output output){
        double[][] trueTable = new double[4][3];

        for (int i = 3; i >= 0; i--) {
            trueTable[i][0] = i / 2;
            trueTable[i][1] = i % 2;

            switch (output){
                case DISCRETE -> trueTable[i][2] = GATE.evaluate(trueTable[i][0], trueTable[i][1]) < 0.5 ? 0 : 1;
                case CONTINUOS -> trueTable[i][2] = GATE.evaluate(trueTable[i][0], trueTable[i][1]);
            }
        }
        printTable(trueTable, GATE.getName());
    }

    public void printTable(double[][] trueTable, String tableName){
        System.out.println("\n| p | q |   " + tableName + "   |\n" + "|---|---|----------|");

        for (double[] doubles : trueTable) {
            System.out.printf("| %.0f | %.0f | " + ((doubles[2] < 0) ? "" : " ") + " %.2f   |\n",
                    doubles[0],
                    doubles[1],
                    doubles[2])
            ;
        }
    }
}
