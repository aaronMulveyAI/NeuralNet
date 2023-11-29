package org.nnet.matrix.producers;

/*
 * The iProducer interface represents a function that accepts an index and returns a value
 */
public interface iProducer {
    
    /**
     * Applies this function to the given argument.
     * @param index - the index
     * @return the function result
     */
    double produce(int index);
}
