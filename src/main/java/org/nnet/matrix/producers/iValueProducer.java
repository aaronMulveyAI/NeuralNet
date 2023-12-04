package org.nnet.matrix.producers;

/*
 * The iValueProducer interface represents a function that accepts a value and returns a value
 */
public interface iValueProducer {

    /**
     * Applies this function to the given argument.
     * @param value - the value
     * @return the function result
     */
    double produce(double value);       
}
