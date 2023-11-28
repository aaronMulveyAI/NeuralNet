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

/**
 * This class represents a perceptron.
 */
public class Perceptron {

    /**
     * The gate to use.
     */
    private final Gate GATE;

    /**
     * This constructor creates a perceptron object.
     * @param option The gate to use.
     * @param activationFunction The activation function to use.
     */
    public Perceptron(Gates option, iActivationFunction activationFunction){
        this.GATE = selectGate(option);
        this.GATE.setEvaluationFunction(activationFunction);
    }


    /**
     * This method returns a gate object based on the option passed.
     * @param option The gate to return.
     * @return A gate object.
     */
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

    /**
     * This method runs the perceptron and prints the truth table.
     * @param output
     */
    public void run(Output output){

        double[][] trueTable = new double[4][3];

        for (int i = 3; i >= 0; i--) {
            trueTable[3 - i][0] = i / 2;    /*   (3 / 2 = 1), (2 / 2 = 1), (1 / 2 = 0), (0 / 2 = 0)   */ 
            trueTable[3 - i][1] = i % 2;    /*   (3 % 2 = 1), (2 % 2 = 0), (1 % 2 = 1), (0 % 2 = 0)   */ 

            switch (output){
                case DISCRETE -> trueTable[i][2] = GATE.evaluate(trueTable[i][0], trueTable[i][1]) < 0.5 ? 0 : 1;
                case CONTINUOS -> trueTable[i][2] = GATE.evaluate(trueTable[i][0], trueTable[i][1]);
            }
        }
        printTable(trueTable, GATE.getName());
    }

    
    /**
     * This method prints a truth table.
     * @param trueTable A 2D double array representing the truth table to print.
     * @param tableName The name of the truth table.
     * 
     * The truth table is printed to the console in the format:
     * |  p  |  q  | tableName |
     * |-----|-----|-----------|
     * | 0/1 | 0/1 |    0/1    |
     * 
     * Where 'p' and 'q' are the inputs to the truth table and 'tableName' is the name of the table.
     * The values of 'p' and 'q' are taken from the first two columns of the 'trueTable' array.
     * The final value is taken from the third column of the 'trueTable' array.
     * If the final value is less than 0, an additional space is printed before the value for proper alignment.
     */

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
