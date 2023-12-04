package org.nnet.matrix.producers;

/*
 * The iRowColProducer interface represents a function that accepts a row, a column and a value and returns a value
 */
public interface iRowColProducer {

    /**
     * Applies this function to the given arguments.
     * @param row - the row
     * @param col - the column
     * @param value - the value
     * @return the function result
     */
    double produce(int row, int col, double value);       
}
